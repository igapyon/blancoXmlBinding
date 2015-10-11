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

import javax.xml.transform.sax.TransformerHandler;

import org.xml.sax.Locator;
import org.xml.sax.SAXException;

import blanco.commons.util.BlancoStringUtil;
import blanco.xml.bind.valueobject.BlancoXmlAttribute;
import blanco.xml.bind.valueobject.BlancoXmlCdata;
import blanco.xml.bind.valueobject.BlancoXmlCharacters;
import blanco.xml.bind.valueobject.BlancoXmlComment;
import blanco.xml.bind.valueobject.BlancoXmlDocument;
import blanco.xml.bind.valueobject.BlancoXmlDtd;
import blanco.xml.bind.valueobject.BlancoXmlElement;
import blanco.xml.bind.valueobject.BlancoXmlIgnorableWhitespace;
import blanco.xml.bind.valueobject.BlancoXmlNode;
import blanco.xml.bind.valueobject.BlancoXmlPrefixMapping;

/**
 * blancoXmlBinding �̃o�����[�I�u�W�F�N�g�\������ XML �𐶐����邽�߂̃V���A���C�U�����ł��B
 * 
 * ���̃N���X�� XML/�o�����[�I�u�W�F�N�g�}�b�s���O (X/O�}�b�s���O) blancoXmlBinding �̈ꕔ�ł��B
 * 
 * @author IGA Tosiki
 */
public class BlancoXmlMarshallerSerializer {
    /**
     * �����I�ɗ��p����o�͗pSAX�n���h��<br>
     * �A����̃X�g���[���͊O����close�����K�v������܂��B
     */
    private TransformerHandler fSaxHandler;

    /**
     * SAX�V���A���C�U��p�������񉻃N���X�𐶐����܂��B
     * 
     * @param argHandler
     *            SAX�V���A���C�U�̃n���h���B
     */
    public BlancoXmlMarshallerSerializer(final TransformerHandler argHandler) {
        fSaxHandler = argHandler;
    }

    /**
     * �^����ꂽDocument��SAX�V���A���C�U�ւƓW�J���܂��B
     * 
     * @param document
     *            �h�L�������g�I�u�W�F�N�g�B
     * @throws SAXException
     *             SAX��O�����������ꍇ�B
     */
    public void serialize(final BlancoXmlDocument document) throws SAXException {
        expandLocator(document);

        fSaxHandler.startDocument();

        // �v���t�B�b�N�X�E�}�b�s���O��W�J�B
        for (final BlancoXmlPrefixMapping prefixMapping : document
                .getPrefixMappings()) {
            fSaxHandler.startPrefixMapping(BlancoStringUtil
                    .null2Blank(prefixMapping.getPrefix()), BlancoStringUtil
                    .null2Blank(prefixMapping.getUri()));
            fSaxHandler.endPrefixMapping(BlancoStringUtil
                    .null2Blank(prefixMapping.getPrefix()));
        }

        // �ŏ��̉��s�B
        // �|�C���g: ���[�J���V�X�e���̉��s�R�[�h�ɂ�炸�ɁA\n ���o�͂��܂��B
        fSaxHandler.characters("\n".toCharArray(), 0, 1);

        final int sizeChildNodes = document.getChildNodes().size();
        for (int index = 0; index < sizeChildNodes; index++) {
            final BlancoXmlNode objLook = document.getChildNodes().get(index);
            if (objLook instanceof BlancoXmlDtd) {
                expandDtd((BlancoXmlDtd) objLook);
            } else if (objLook instanceof BlancoXmlElement) {
                expandElement((BlancoXmlElement) objLook);
            } else {
                throw new IllegalArgumentException(
                        "BlancoXmlMarshallerSerializer: �z�肵�Ȃ��ӏ���ʉ߂��܂����B");
            }
        }

        fSaxHandler.endDocument();
    }

    /**
     * ���P�[�^��W�J���܂��B
     * 
     * @param document
     *            �h�L�������g�I�u�W�F�N�g�B
     */
    private void expandLocator(final BlancoXmlDocument document) {
        if (document.getLocator() != null) {
            fSaxHandler.setDocumentLocator(new Locator() {
                public String getPublicId() {
                    // Locator�̊e���\�b�h��null��߂��\��������܂��B
                    return document.getLocator().getPublicId();
                }

                public String getSystemId() {
                    // Locator�̊e���\�b�h��null��߂��\��������܂��B
                    return document.getLocator().getSystemId();
                }

                public int getLineNumber() {
                    return document.getLocator().getLineNumber();
                }

                public int getColumnNumber() {
                    return document.getLocator().getColumnNumber();
                }
            });
        }
    }

    /**
     * DTD��W�J���܂��B
     * 
     * @param argDtd
     *            DTD���B
     * @throws SAXException
     *             SAX��O�����������ꍇ�B
     */
    private void expandDtd(final BlancoXmlDtd argDtd) throws SAXException {
        fSaxHandler.startDTD(argDtd.getName(), argDtd.getPublicId(), argDtd
                .getSystemId());
        fSaxHandler.endDTD();
    }

    /**
     * �G�������g��W�J���܂��B
     * 
     * @param element
     *            �G�������g�B
     * @throws SAXException
     *             SAX��O�����������ꍇ�B
     */
    private void expandElement(final BlancoXmlElement element)
            throws SAXException {
        if (BlancoStringUtil.null2Blank(element.getLocalName()).length() == 0
                && BlancoStringUtil.null2Blank(element.getQName()).length() == 0) {
            throw new IllegalArgumentException(
                    "localName��QName���w�肳��Ă��Ȃ�Element������܂��B�������f���܂��B");
        }

        String qName = element.getQName();
        if (BlancoStringUtil.null2Blank(qName).length() == 0) {
            // QName�ɉ����w�肳��Ă��Ȃ��ꍇ�ɂ�localName�̒l���Z�b�g���܂��B
            qName = element.getLocalName();
        }

        // �A�g���r���[�g�ɂ��Ă� QName�����w��̏ꍇ�ɂ� localName�𕡎ʂ���Ȃ�null�΍���قǂ����܂��B
        for (int index = 0; index < element.getAtts().size(); index++) {
            final BlancoXmlAttribute attrLook = (BlancoXmlAttribute) element
                    .getAtts().get(index);
            attrLook.setLocalName(BlancoStringUtil.null2Blank(attrLook
                    .getLocalName()));
            attrLook.setType(BlancoStringUtil.null2Blank(attrLook.getType()));
            attrLook.setValue(BlancoStringUtil.null2Blank(attrLook.getValue()));

            if (BlancoStringUtil.null2Blank(attrLook.getQName()).length() == 0) {
                // QName�ɉ����w�肳��Ă��Ȃ��ꍇ�ɂ�localName�̒l���Z�b�g���܂��B
                attrLook.setQName(attrLook.getLocalName());
            }
            if (attrLook.getQName().length() == 0) {
                // ����ł�QName���u�����N�̏ꍇ�B
                throw new IllegalArgumentException(
                        "�A�g���r���[�g��QName��null�̂܂ܗ^�����܂����BlocalName��������o�ł��܂���ł����B:"
                                + element.toString());
            }
        }

        // �w�肪�����ꍇ�ɂ�null�ł͂Ȃ���̕������n���K�v������_�ɒ��ӁB
        fSaxHandler.startElement(BlancoStringUtil.null2Blank(element.getUri()),
                BlancoStringUtil.null2Blank(element.getLocalName()), qName,
                new BlancoXmlAttributesImpl(element.getAtts()));

        // �q�m�[�h��W�J���܂��B
        final int sizeChildNodes = element.getChildNodes().size();
        for (int index = 0; index < sizeChildNodes; index++) {
            final BlancoXmlNode objLook = element.getChildNodes().get(index);
            if (objLook instanceof BlancoXmlElement) {
                expandElement((BlancoXmlElement) objLook);
            } else if (objLook instanceof BlancoXmlCharacters) {
                expandCharacters((BlancoXmlCharacters) objLook);
            } else if (objLook instanceof BlancoXmlIgnorableWhitespace) {
                expandIgnorableWhitespace((BlancoXmlIgnorableWhitespace) objLook);
            } else if (objLook instanceof BlancoXmlComment) {
                expandComment((BlancoXmlComment) objLook);
            } else if (objLook instanceof BlancoXmlCdata) {
                expandCdata((BlancoXmlCdata) objLook);
            } else {
                throw new IllegalArgumentException(
                        "BlancoXmlMarshallerSerializer: �z�肵�Ȃ��ӏ���ʉ߂��܂����B");
            }
        }

        // �w�肪�����ꍇ�ɂ�null�ł͂Ȃ���̕������n���K�v������_�ɒ��ӁB
        fSaxHandler.endElement(BlancoStringUtil.null2Blank(element.getUri()),
                BlancoStringUtil.null2Blank(element.getLocalName()), qName);
    }

    /**
     * �����f�[�^��W�J���܂��B
     * 
     * @param argCharacters
     *            �����f�[�^�B
     * @throws SAXException
     *             SAX��O�����������ꍇ�B
     */
    private void expandCharacters(final BlancoXmlCharacters argCharacters)
            throws SAXException {
        if (argCharacters == null) {
            throw new IllegalArgumentException(
                    "expandCharacters�̈�����null���^�����܂����B");
        }
        if (argCharacters.getValue() == null) {
            // null���w�肳��Ă���ꍇ�ɂ� "" �������ė�O���������Ȃ��悤�ɂ��܂��B
            argCharacters.setValue("");
        }

        final char[] buf = argCharacters.getValue().toCharArray();
        fSaxHandler.characters(buf, 0, buf.length);
    }

    /**
     * �����\�ȋ󔒃f�[�^��W�J���܂��B
     * 
     * @param argIgnorableWhitespace
     *            �����\�ȋ󔒃f�[�^�B
     * @throws SAXException
     *             SAX��O�����������ꍇ�B
     */
    private void expandIgnorableWhitespace(
            final BlancoXmlIgnorableWhitespace argIgnorableWhitespace)
            throws SAXException {
        final char[] buf = argIgnorableWhitespace.getValue().toCharArray();
        fSaxHandler.ignorableWhitespace(buf, 0, buf.length);
    }

    /**
     * �R�����g��W�J���܂��B
     * 
     * @param argComment
     *            �R�����g�I�u�W�F�N�g�B
     * @throws SAXException
     *             SAX��O�����������ꍇ�B
     */
    private void expandComment(final BlancoXmlComment argComment)
            throws SAXException {
        final char[] buf = argComment.getValue().toCharArray();
        fSaxHandler.comment(buf, 0, buf.length);
    }

    /**
     * CDATA��W�J���܂��B
     * 
     * @param argCdata
     *            CDATA�I�u�W�F�N�g�B
     * @throws SAXException
     *             SAX��O�����������ꍇ�B
     */
    private void expandCdata(final BlancoXmlCdata argCdata) throws SAXException {
        fSaxHandler.startCDATA();

        // �q�m�[�h��W�J���܂��B
        final int sizeChildNodes = argCdata.getChildNodes().size();
        for (int index = 0; index < sizeChildNodes; index++) {
            final BlancoXmlNode objLook = argCdata.getChildNodes().get(index);
            if (objLook instanceof BlancoXmlElement) {
                expandElement((BlancoXmlElement) objLook);
            } else if (objLook instanceof BlancoXmlCharacters) {
                expandCharacters((BlancoXmlCharacters) objLook);
            } else if (objLook instanceof BlancoXmlIgnorableWhitespace) {
                expandIgnorableWhitespace((BlancoXmlIgnorableWhitespace) objLook);
            } else if (objLook instanceof BlancoXmlComment) {
                expandComment((BlancoXmlComment) objLook);
            } else {
                throw new IllegalArgumentException(
                        "BlancoXmlMarshallerSerializer: �z�肵�Ȃ��ӏ���ʉ߂��܂����B");
            }
        }

        fSaxHandler.endCDATA();
    }
}
