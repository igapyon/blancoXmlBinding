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

import java.util.List;

import org.xml.sax.Attributes;

import blanco.commons.util.BlancoStringUtil;
import blanco.xml.bind.valueobject.BlancoXmlAttribute;

/**
 * blancoXmlBinding �ŗ��p�����A�g���r���[�g�����ł��B
 * 
 * ���̃N���X�� XML/�o�����[�I�u�W�F�N�g�}�b�s���O (X/O�}�b�s���O) blancoXmlBinding �̈ꕔ�ł��B
 * 
 * @author IGA Tosiki
 */
public class BlancoXmlAttributesImpl implements Attributes {
    /**
     * ���ۂ̃A�g���r���[�g�̃��X�g�B
     */
    private List<BlancoXmlAttribute> fAttrs = null;

    /**
     * �A�g���r���[�g�����̃C���X�^���X�𐶐����܂��B
     * 
     * @param attrs
     *            �A�g���r���[�g�̃��X�g�B
     */
    public BlancoXmlAttributesImpl(final List<BlancoXmlAttribute> attrs) {
        if (attrs == null) {
            throw new IllegalArgumentException(
                    "BlancoXmlMarshallerAttributesImpl�̃R���X�g���N�^��null�̈������^�����܂����B");
        }

        fAttrs = attrs;
    }

    /**
     * ���X�g���ɂ��鑮���̐���Ԃ��܂��B
     * 
     * @return �����̐��B
     */
    public int getLength() {
        return fAttrs.size();
    }

    /**
     * �����̖��O���URI ���������܂��B
     * 
     * @param index
     *            �����C���f�B�b�N�X�B
     * @return ���O���URI�B
     */
    public String getURI(int index) {
        final BlancoXmlAttribute attribute = getAttr(index);
        if (attribute == null) {
            return null;
        }

        return attribute.getUri();
    }

    /**
     * �����̃��[�J�������������܂��B
     * 
     * @param index
     *            �����C���f�B�b�N�X�B
     * @return ���[�J�����B
     */
    public String getLocalName(int index) {
        final BlancoXmlAttribute attribute = getAttr(index);
        if (attribute == null) {
            return null;
        }

        return attribute.getLocalName();
    }

    /**
     * ������ XML 1.0 �C�������������܂��B
     * 
     * @param index
     *            �����C���f�B�b�N�X�B
     * @return �C�����B
     */
    public String getQName(int index) {
        final BlancoXmlAttribute attribute = getAttr(index);
        if (attribute == null) {
            return null;
        }

        final String qName = BlancoStringUtil.null2Blank(attribute.getQName());
        if (qName.length() == 0) {
            // qName�ɒl���w�肳��Ă��Ȃ��ꍇ�ɂ�localName��߂��܂��B
            return getLocalName(index);
        }

        return attribute.getQName();
    }

    /**
     * �����̌^���������܂��B
     * 
     * @param index
     *            �����C���f�B�b�N�X�B
     * @return �����̌^�B
     */
    public String getType(int index) {
        final BlancoXmlAttribute attribute = getAttr(index);
        if (attribute == null) {
            return null;
        }

        return attribute.getType();
    }

    /**
     * �����̒l���������܂��B
     * 
     * @param index
     *            �����C���f�B�b�N�X�B
     * @return �����̒l�B
     */
    public String getValue(int index) {
        final BlancoXmlAttribute attribute = getAttr(index);
        if (attribute == null) {
            return null;
        }

        return attribute.getValue();
    }

    /**
     * �����̃C���f�b�N�X���������܂��B
     * 
     * @param uri
     *            ���O���URI�B
     * @param localName
     *            ���[�J�����B
     * @return �����C���f�b�N�X�B���X�g���ɊY�����鑮�������݂��Ȃ��ꍇ�� -1�B
     */
    public int getIndex(final String uri, final String localName) {
        final int attrSize = fAttrs.size();
        for (int index = 0; index < attrSize; index++) {
            final BlancoXmlAttribute attrLook = (BlancoXmlAttribute) fAttrs
                    .get(index);
            if (BlancoStringUtil.null2Blank(attrLook.getUri()).equals(uri)
                    && BlancoStringUtil.null2Blank(attrLook.getLocalName())
                            .equals(localName)) {
                return index;
            }
        }

        // �����ł��܂���ł����B
        return -1;
    }

    /**
     * �����̃C���f�b�N�X���������܂��B
     * 
     * @param qName
     *            �C�����B
     * @return �����C���f�b�N�X�B���X�g���ɊY�����鑮�������݂��Ȃ��ꍇ�� -1�B
     */
    public int getIndex(final String qName) {
        final int attrSize = fAttrs.size();
        for (int index = 0; index < attrSize; index++) {
            final BlancoXmlAttribute attrLook = (BlancoXmlAttribute) fAttrs
                    .get(index);
            if (BlancoStringUtil.null2Blank(attrLook.getQName()).equals(qName)) {
                return index;
            }
        }

        // �����ł��܂���ł����B
        return -1;
    }

    /**
     * �����̌^���������܂��B
     * 
     * @param uri
     *            ���O���URI�B
     * @param localName
     *            ���[�J�����B
     * @return �����̌^�B
     */
    public String getType(final String uri, final String localName) {
        final BlancoXmlAttribute attrFound = findByUriLocalName(uri, localName);
        if (attrFound == null) {
            // �����ł��܂���ł����B
            return null;
        }

        return attrFound.getType();
    }

    /**
     * �����̌^���������܂��B
     * 
     * @param qName
     *            �C�����B
     * @return �����̌^�B
     */
    public String getType(final String qName) {
        final BlancoXmlAttribute attrFound = findByQName(qName);
        if (attrFound == null) {
            // �����ł��܂���ł����B
            return null;
        }

        return attrFound.getType();
    }

    /**
     * �����̒l���������܂��B
     * 
     * @param uri
     *            ���O���URI�B
     * @param localName
     *            ���[�J�����B
     * @return �����̒l�B
     */
    public String getValue(final String uri, final String localName) {
        final BlancoXmlAttribute attrFound = findByUriLocalName(uri, localName);
        if (attrFound == null) {
            // �����ł��܂���ł����B
            return null;
        }

        return attrFound.getValue();
    }

    /**
     * �����̒l���������܂��B
     * 
     * @param qName
     *            �C�����B
     * @return �����̒l�B
     */
    public String getValue(final String qName) {
        final BlancoXmlAttribute attrFound = findByQName(qName);
        if (attrFound == null) {
            // �����ł��܂���ł����B
            return null;
        }

        return attrFound.getValue();
    }

    /**
     * ���ʂɗp�ӂ��Ă���A������\�I���邽�߂̃��\�b�h�B
     * 
     * �ʏ�́A���̃��\�b�h�͗��p���܂���B
     * 
     * @return �������X�g�B
     */
    public List<BlancoXmlAttribute> getList() {
        return fAttrs;
    }

    /**
     * �w��̃C���f�B�b�N�X�ɂ��鑮�����擾���܂��B
     * 
     * @param index
     *            �����C���f�B�b�N�X�B
     * @return �����B�w���index���͈͊O�̏ꍇ��null�B
     */
    private BlancoXmlAttribute getAttr(int index) {
        if (index >= fAttrs.size()) {
            return null;
        }

        return (BlancoXmlAttribute) fAttrs.get(index);
    }

    /**
     * ���O���URI�ƃ��[�J������p���đ������������܂��B
     * 
     * @param uri
     *            ���O���URI�B
     * @param localName
     *            ���[�J�����B
     * @return �����B
     */
    private BlancoXmlAttribute findByUriLocalName(final String uri,
            final String localName) {
        final int attrSize = fAttrs.size();
        for (int index = 0; index < attrSize; index++) {
            final BlancoXmlAttribute attrLook = (BlancoXmlAttribute) fAttrs
                    .get(index);
            if (BlancoStringUtil.null2Blank(attrLook.getUri()).equals(uri)
                    && BlancoStringUtil.null2Blank(attrLook.getLocalName())
                            .equals(localName)) {
                return attrLook;
            }
        }

        // �����ł��܂���ł����B
        return null;
    }

    /**
     * �C������p���đ������������܂��B
     * 
     * @param qName
     *            �C�����B
     * @return �����B
     */
    private BlancoXmlAttribute findByQName(final String qName) {
        final int attrSize = fAttrs.size();
        for (int index = 0; index < attrSize; index++) {
            final BlancoXmlAttribute attrLook = (BlancoXmlAttribute) fAttrs
                    .get(index);
            if (BlancoStringUtil.null2Blank(attrLook.getUri()).equals(qName)) {
                return attrLook;
            }
        }

        // �����ł��܂���ł����B
        return null;
    }
}
