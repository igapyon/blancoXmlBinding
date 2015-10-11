/*
 * blanco Framework
 * Copyright (C) 2004-2009 IGA Tosiki
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 */
/*******************************************************************************
 * Copyright (c) 2009 IGA Tosiki, NTT DATA BUSINESS BRAINS Corp.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IGA Tosiki (NTT DATA BUSINESS BRAINS Corp.) - initial API and implementation
 *******************************************************************************/
package blanco.xml.bind;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import blanco.xml.bind.valueobject.BlancoXmlDocument;

/**
 * XML ���� blancoXmlBinding �o�����[�I�u�W�F�N�g�\���𐶐����邽�߂̃N���X�ł��B
 * 
 * ���̃N���X�� XML/�o�����[�I�u�W�F�N�g�}�b�s���O (X/O�}�b�s���O) blancoXmlBinding �̈ꕔ�ł��B
 * 
 * @author IGA Tosiki
 */
public class BlancoXmlUnmarshaller {
    /**
     * XML����Java�I�u�W�F�N�g�𐶐����܂��B
     * 
     * �Q�l: http://java.sun.com/webservices/docs/1.6/api/javax/xml/bind/
     * Unmarshaller.html
     * 
     * @param fileInput
     *            XML�t�@�C���B
     * @return blancoXml�Ƃ��ẴI�u�W�F�N�g�B
     */
    public BlancoXmlDocument unmarshal(final File fileInput) {
        if (fileInput.exists() == false) {
            throw new IllegalArgumentException("�t�@�C��["
                    + fileInput.getAbsolutePath() + "]�͌�����܂���B");
        }
        if (fileInput.isDirectory()) {
            throw new IllegalArgumentException("�t�@�C��["
                    + fileInput.getAbsolutePath() + "]�͎��ۂɂ̓f�B���N�g���ł��B");
        }
        if (fileInput.canRead() == false) {
            throw new IllegalArgumentException("�t�@�C��["
                    + fileInput.getAbsolutePath() + "]�͓ǂݍ��ނ��Ƃ��ł��܂���B");
        }

        InputStream inStream = null;

        try {
            inStream = new BufferedInputStream(new FileInputStream(fileInput));

            return unmarshal(inStream);
        } catch (IOException e) {
            throw new IllegalArgumentException("�������ɓ��o�͗�O���������܂����B: "
                    + e.toString(), e);
        } finally {
            if (inStream != null) {
                try {
                    inStream.close();
                } catch (IOException e) {
                    throw new IllegalArgumentException(
                            "���̓X�g���[���̃N���[�Y�������ɓ��o�͗�O���������܂����B: " + e.toString(), e);
                }
            }
        }
    }

    /**
     * XML����Java�I�u�W�F�N�g�𐶐����܂��B
     * 
     * �Q�l: http://java.sun.com/webservices/docs/1.6/api/javax/xml/bind/
     * Unmarshaller.html
     * 
     * @param inStream
     *            XML���̓X�g���[���B
     * @return blancoXml�Ƃ��ẴI�u�W�F�N�g�B
     */
    public BlancoXmlDocument unmarshal(final InputStream inStream) {
        if (inStream == null) {
            throw new IllegalArgumentException(
                    "BlancoXmlUnmarshaller#unmarshal: ���̓X�g���[���� null ���^�����܂����B");
        }

        final BlancoXmlUnmarshallerContentHandler handler = new BlancoXmlUnmarshallerContentHandler();

        try {
            // XML�p�[�T�̐ݒ���R���g���[���������̂ŁAXMLReader��D�悵�ė��p�B
            XMLReader reader = null;
            try {
                reader = XMLReaderFactory.createXMLReader();
            } catch (SAXException e) {
                Logger.getLogger("blanco.xml.bind").fine(
                        "XMLReader �̎擾�Ɏ��s���܂���: " + e.toString());

                // ���ɂ���Ă�(JDK 1.4.2�ŋH��?) XMLReader�̎擾�Ɏ��s����ꍇ������܂��B

                // XMLReaderFactory.createXMLReader() �Ăяo�����ɁA
                // org.xml.sax.SAXException: System property org.xml.sax.driver
                // not specified ���������邱�Ƃ��m�F����Ă��܂��B
                final SAXResult result = new SAXResult(handler);
                result.setHandler(handler);
                result.setLexicalHandler(handler);
                final TransformerFactory tf = TransformerFactory.newInstance();
                try {
                    final Transformer transformer = tf.newTransformer();
                    transformer.transform(new StreamSource(inStream), result);
                    return handler.getDocument();

                } catch (TransformerException e2) {
                    throw new IllegalArgumentException("�������� XML ��͗�O���������܂����B"
                            + e2.toString(), e2);
                }
            }

            // XMLReader�𖳎��Ɏ擾�ł����ꍇ�ɂ́A�������ʂ�܂��B

            try {
                // �O����DTD��ǂݍ��܂Ȃ����邽�߂̎����B
                reader
                        .setFeature(
                                "http://apache.org/xml/features/nonvalidating/load-external-dtd",
                                false);
            } catch (SAXNotRecognizedException e) {
                Logger.getLogger("blanco.xml.bind").finest(
                        "�O�� DTD ��ǂݍ��܂Ȃ����邽�߂̐ݒ�̎��{���ɗ�O���������܂���: " + e.toString());
            }

            reader.setContentHandler(handler);
            reader.setDTDHandler(handler);
            // �R�����g���������邽�߂Ƀv���p�e�B��ݒ�B
            reader.setProperty("http://xml.org/sax/properties/lexical-handler",
                    handler);

            // DTD �錾�͌��݂͏������Ă��܂���B
            // ����́A���݂̏����͈͂� javax.xml.transform.sax.TransformerHandler
            // �ƌ��肵�Ă��邽�߂ł��B
            // reader.setProperty(
            // "http://xml.org/sax/properties/declaration-handler",
            // handler);

            reader.parse(new InputSource(inStream));
            return handler.getDocument();

        } catch (SAXException e) {
            throw new IllegalArgumentException("�������� XML ��͗�O���������܂����B: "
                    + e.toString(), e);
        } catch (IOException e) {
            throw new IllegalArgumentException("�������ɓ��o�͗�O���������܂����B: "
                    + e.toString(), e);
        } finally {
            if (inStream != null) {
                try {
                    inStream.close();
                } catch (IOException e) {
                    throw new IllegalArgumentException(
                            "���̓X�g���[���̃N���[�Y�������ɓ��o�͗�O���������܂����B: " + e.toString(), e);
                }
            }
        }
    }
}
