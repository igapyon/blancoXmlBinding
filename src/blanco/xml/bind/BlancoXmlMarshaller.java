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

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.SAXException;

import blanco.commons.util.BlancoStringUtil;
import blanco.xml.bind.valueobject.BlancoXmlDocument;

/**
 * blancoXmlBinding �̃o�����[�I�u�W�F�N�g�\������ XML �𐶐����邽�߂̃N���X�ł��B
 * 
 * ���̃N���X�� XML/�o�����[�I�u�W�F�N�g�}�b�s���O (X/O�}�b�s���O) blancoXmlBinding �̈ꕔ�ł��B
 * 
 * @author IGA Tosiki
 */
public class BlancoXmlMarshaller {
    /**
     * �����I�ɗ��p����o�͗pSAX�n���h��
     * 
     * �A����̃X�g���[���͊O����close�Ȃǂ̏��������{�����K�v������܂��B
     */
    private TransformerHandler fSaxHandler;

    /**
     * Java�I�u�W�F�N�g����XML�𐶐����܂��B
     * 
     * @param document
     *            blancoXml�Ƃ��ẴI�u�W�F�N�g�B
     * @param outFile
     *            XML�o�͐�t�@�C���B
     */
    public void marshal(final BlancoXmlDocument document, final File outFile) {
        if (document == null) {
            throw new IllegalArgumentException(
                    "BlancoXmlMarshaller#marshal: ���� XML �h�L�������g�� null ���n����܂����B");
        }
        if (outFile == null) {
            throw new IllegalArgumentException(
                    "BlancoXmlMarshaller#marshal: �o�͐� XML �t�@�C���� null ���n����܂����B");
        }
        if (outFile.exists()) {
            if (outFile.canWrite() == false) {
                throw new IllegalArgumentException("�o�͐� XML �t�@�C��["
                        + outFile.getName() + "]�͏������ނ��Ƃ��ł��܂���B");
            }
        }

        try {
            final OutputStream outStream = new BufferedOutputStream(
                    new FileOutputStream(outFile));
            try {
                marshal(document, outStream);

                outStream.flush();
            } finally {
                outStream.close();
            }
        } catch (IOException ex) {
            throw new IllegalArgumentException(
                    "BlancoXmlMarshaller#marshal: �t�@�C���o�͂Ɏ��s���܂����B"
                            + ex.toString(), ex);
        }
    }

    /**
     * Java�I�u�W�F�N�g����XML�𐶐����܂��B
     * 
     * �Q�l:
     * http://java.sun.com/webservices/docs/1.6/api/javax/xml/bind/Marshaller
     * .html
     * 
     * @param document
     *            blancoXml�Ƃ��ẴI�u�W�F�N�g�B
     * @param outStream
     *            XML�o�͐�X�g���[���B
     */
    public void marshal(final BlancoXmlDocument document,
            final OutputStream outStream) {
        final TransformerFactory tf = TransformerFactory.newInstance();
        final SAXTransformerFactory saxTf = (SAXTransformerFactory) tf;
        try {
            fSaxHandler = saxTf.newTransformerHandler();
            if (BlancoStringUtil.null2Blank(document.getVersion()).length() > 0) {
                fSaxHandler.getTransformer().setOutputProperty("version",
                        document.getVersion());
            }
            if (BlancoStringUtil.null2Blank(document.getEncoding()).length() > 0) {
                fSaxHandler.getTransformer().setOutputProperty("encoding",
                        document.getEncoding());
            }
        } catch (TransformerConfigurationException e) {
            throw new IllegalArgumentException(
                    "BlancoXmlMarshaller#marshal: �g�����X�t�H�[�}�[�n���h�������Ɏ��s���܂����B: "
                            + e.toString(), e);
        }

        fSaxHandler.setResult(new StreamResult(outStream));

        try {
            new BlancoXmlMarshallerSerializer(fSaxHandler).serialize(document);
        } catch (SAXException e) {
            throw new IllegalArgumentException(
                    "BlancoXmlMarshaller#marshal: �I�u�W�F�N�g���� XML �ւ̕ϊ��ߒ��ŗ�O���������܂����B: "
                            + e.toString(), e);
        }

        // �Ō�Ƀn���h�����J�����܂��B
        fSaxHandler = null;
    }
}
