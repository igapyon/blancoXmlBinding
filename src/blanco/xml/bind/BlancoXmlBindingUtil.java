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

import java.util.ArrayList;
import java.util.List;

import blanco.xml.bind.valueobject.BlancoXmlAttribute;
import blanco.xml.bind.valueobject.BlancoXmlCdata;
import blanco.xml.bind.valueobject.BlancoXmlCharacters;
import blanco.xml.bind.valueobject.BlancoXmlDocument;
import blanco.xml.bind.valueobject.BlancoXmlElement;
import blanco.xml.bind.valueobject.BlancoXmlNode;

/**
 * blancoXmlBinding �̃o�����[�I�u�W�F�N�g�\���ɑ΂��鑀��x�����[�e�B���e�B�ł��B
 * 
 * @author IGA Tosiki
 */
public class BlancoXmlBindingUtil {
    /**
     * ���̃N���X�̓C���X�^���X���͂��܂���B
     */
    protected BlancoXmlBindingUtil() {
    }

    /**
     * �^����ꂽ�h�L�������g����G�������g���擾���܂��B
     * 
     * �ŏ��Ɍ��������G�������g��߂��܂��B
     * 
     * @param argDocument
     *            �����ΏۂƂȂ�h�L�������g�B
     * @return (�ŏ��Ɍ�������)�G�������g�B�G�������g��������Ȃ������ꍇ�ɂ�null���߂�܂��B
     */
    public static final BlancoXmlElement getDocumentElement(
            final BlancoXmlDocument argDocument) {
        final List<blanco.xml.bind.valueobject.BlancoXmlNode> listRoot = argDocument
                .getChildNodes();
        for (int index = 0; index < listRoot.size(); index++) {
            final BlancoXmlNode objLook = listRoot.get(index);
            if (objLook instanceof BlancoXmlElement == false) {
                continue;
            }
            return (BlancoXmlElement) objLook;
        }

        // �ЂƂ�������܂���ł����B
        return null;
    }

    /**
     * �^����ꂽ�G�������g�̎q�m�[�h����G�������g���擾���܂��B
     * 
     * �����ɍ��v�����S�ẴG�������g��߂��܂��B
     * 
     * @param argElement
     *            �����ΏۂƂȂ�G�������g�B
     * @param argTagname
     *            �����������^�O���B(���[�J����)
     * @return ���������G�������g�̃��X�g�B�G�������g��������Ȃ������ꍇ�ɂ͋��List���߂�܂��B
     */
    public static final List<blanco.xml.bind.valueobject.BlancoXmlElement> getElementsByTagName(
            final BlancoXmlElement argElement, final String argTagname) {
        if (argElement == null) {
            throw new IllegalArgumentException(
                    "BlancoXmlBindingUtil.getElementsByTagName: ����(�G�������g)��null���^�����܂����B");
        }

        final List<blanco.xml.bind.valueobject.BlancoXmlElement> listResult = new ArrayList<blanco.xml.bind.valueobject.BlancoXmlElement>();

        final List<blanco.xml.bind.valueobject.BlancoXmlNode> listChild = argElement
                .getChildNodes();
        for (int index = 0; index < listChild.size(); index++) {
            final BlancoXmlNode objLook = listChild.get(index);
            if (objLook instanceof BlancoXmlElement == false) {
                continue;
            }

            final BlancoXmlElement elementLook = (BlancoXmlElement) objLook;
            if (elementLook.getLocalName().equals(argTagname)) {
                listResult.add((BlancoXmlElement) objLook);
            }
        }

        return listResult;
    }

    /**
     * �^����ꂽ�G�������g�̎q�m�[�h����G�������g���擾���܂��B
     * 
     * �ŏ��Ɍ��������G�������g��߂��܂��B�����̃G�������g�����v�����Ƃ��Ă��Q�ڈȍ~�͖�������܂��B
     * 
     * @param argElement
     *            �����ΏۂƂȂ�G�������g�B
     * @param argTagname
     *            �����������^�O���B(���[�J����)
     * @return �ŏ��Ɍ��������G�������g�B�G�������g��������Ȃ������ꍇ�ɂ�null���߂�܂��B
     */
    public static final BlancoXmlElement getElement(
            final BlancoXmlElement argElement, final String argTagname) {
        final List<blanco.xml.bind.valueobject.BlancoXmlNode> listChild = argElement
                .getChildNodes();
        for (int index = 0; index < listChild.size(); index++) {
            final BlancoXmlNode objLook = listChild.get(index);
            if (objLook instanceof BlancoXmlElement == false) {
                continue;
            }

            final BlancoXmlElement elementLook = (BlancoXmlElement) objLook;
            if (elementLook.getLocalName().equals(argTagname)) {
                return elementLook;
            }
        }

        // �ЂƂ�������܂���ł����B
        return null;
    }

    /**
     * �I�����ꂽ�m�[�h(�G�������g�ł���)���當������擾���܂��B
     * 
     * ����m�[�h�ɂԂ炳�����Ă���S�Ẵe�L�X�g�f�[�^���擾����ꍇ�ɗ��p���܂��B
     * 
     * @param argElement
     *            �ΏۂƂ���^�[�Q�b�g�G�������g
     * @return �擾���ꂽ�e�L�X�g������B�擾����Ȃ������ꍇ�ɂ�null���߂�܂��B
     */
    public static final String getTextContent(final BlancoXmlElement argElement) {
        if (argElement == null) {
            throw new IllegalArgumentException(
                    "�m�[�h����e�L�X�g���擾���郁�\�b�h��null���^�����܂����Bnull�ȊO�̒l��^����悤�ɂ��Ă��������B");
        }

        final StringBuffer result = new StringBuffer();
        boolean isProcessed = false;

        final List<blanco.xml.bind.valueobject.BlancoXmlNode> listText = argElement
                .getChildNodes();
        final int sizeChildList = listText.size();
        for (int indexChild = 0; indexChild < sizeChildList; indexChild++) {
            final BlancoXmlNode objLook = listText.get(indexChild);
            if (objLook instanceof BlancoXmlCharacters) {
                final BlancoXmlCharacters textLook = (BlancoXmlCharacters) objLook;
                result.append(textLook.getValue());
                isProcessed = true;
            } else if (objLook instanceof BlancoXmlCdata) {
                final BlancoXmlCdata cdataLook = (BlancoXmlCdata) objLook;
                result.append(getTextContent(cdataLook));
                isProcessed = true;
            }
            // BlancoXmlIgnorableWhitespace �͏����Ώۂ���͂����܂��B
        }

        if (isProcessed == false) {
            return null;
        } else {
            return result.toString();
        }
    }

    /**
     * �G�������g����w��̃^�O���̕������ǂݍ��݂܂��B
     * 
     * @param elementTarget
     *            �ΏۂƂ���^�[�Q�b�g�G�������g
     * @param tagName
     *            �^�O��
     * @return �擾���ꂽ�e�L�X�g������B�擾����Ȃ������ꍇ�ɂ�null���߂�܂��B
     */
    public static final String getTextContent(
            final BlancoXmlElement elementTarget, final String tagName) {
        if (elementTarget == null) {
            throw new IllegalArgumentException(
                    "�G�������g����e�L�X�g���擾���郁�\�b�h�ɃG�������g�Ƃ���null���^�����܂����Bnull�ȊO�̒l��^����悤�ɂ��Ă��������B");
        }
        if (tagName == null) {
            throw new IllegalArgumentException(
                    "�G�������g����e�L�X�g���擾���郁�\�b�h�Ƀ^�O���Ƃ���null���^�����܂����Bnull�ȊO�̒l��^����悤�ɂ��Ă��������B");
        }

        final StringBuffer result = new StringBuffer();
        boolean isProcessed = false;

        final List<blanco.xml.bind.valueobject.BlancoXmlElement> listElementTarget = getElementsByTagName(
                elementTarget, tagName);
        final int sizeList = listElementTarget.size();
        for (int index = 0; index < sizeList; index++) {
            final BlancoXmlNode nodeLook = listElementTarget.get(index);
            if (nodeLook instanceof BlancoXmlElement) {
                final BlancoXmlElement elementLook = (BlancoXmlElement) nodeLook;

                final List<blanco.xml.bind.valueobject.BlancoXmlNode> listText = elementLook
                        .getChildNodes();
                final int sizeChildList = listText.size();
                for (int indexChild = 0; indexChild < sizeChildList; indexChild++) {
                    final BlancoXmlNode nodeChild = listText.get(indexChild);
                    if (nodeChild instanceof BlancoXmlCharacters) {
                        final BlancoXmlCharacters textLook = (BlancoXmlCharacters) nodeChild;
                        result.append(textLook.getValue());
                        isProcessed = true;
                    } else if (nodeChild instanceof BlancoXmlCdata) {
                        final BlancoXmlCdata cdataLook = (BlancoXmlCdata) nodeChild;
                        result.append(getTextContent(cdataLook));
                        isProcessed = true;
                    }
                    // BlancoXmlIgnorableWhitespace �͏����Ώۂ���͂����܂��B
                }
            }
        }

        if (isProcessed == false) {
            return null;
        } else {
            return result.toString();
        }
    }

    /**
     * �^����ꂽ CDATA ����e�L�X�g��ǂݏo���܂��B
     * 
     * @param argCdata
     *            CDATA�B
     * @return �e�L�X�g�B
     */
    public static final String getTextContent(final BlancoXmlCdata argCdata) {
        if (argCdata == null) {
            throw new IllegalArgumentException(
                    "CDATA����e�L�X�g���擾���郁�\�b�h��null���^�����܂����Bnull�ȊO�̒l��^����悤�ɂ��Ă��������B");
        }

        final StringBuffer result = new StringBuffer();
        boolean isProcessed = false;

        final List<blanco.xml.bind.valueobject.BlancoXmlNode> listText = argCdata
                .getChildNodes();
        final int sizeChildList = listText.size();
        for (int indexChild = 0; indexChild < sizeChildList; indexChild++) {
            final BlancoXmlNode objLook = listText.get(indexChild);
            if (objLook instanceof BlancoXmlCharacters) {
                final BlancoXmlCharacters textLook = (BlancoXmlCharacters) objLook;
                result.append(textLook.getValue());
                isProcessed = true;
            } else if (objLook instanceof BlancoXmlCdata) {
                final BlancoXmlCdata cdataLook = (BlancoXmlCdata) objLook;
                for (int index = 0; index < cdataLook.getChildNodes().size(); index++) {

                    result.append(getTextContent(cdataLook));
                }
                isProcessed = true;
            }
            // BlancoXmlIgnorableWhitespace �͏����Ώۂ���͂����܂��B
        }

        if (isProcessed == false) {
            return null;
        } else {
            return result.toString();
        }
    }

    /**
     * �G�������g����^����ꂽQName�ɂ��A�g���r���[�g�l���擾���܂��B
     * 
     * @param argElement
     *            �G�������g�B
     * @param argQName
     *            ���O�B
     * @return �A�g���r���[�g�l�B
     */
    public static final String getAttribute(final BlancoXmlElement argElement,
            final String argQName) {
        for (int indexAttr = 0; indexAttr < argElement.getAtts().size(); indexAttr++) {
            final BlancoXmlAttribute attr = argElement.getAtts().get(indexAttr);
            if (argQName.equals(attr.getQName())) {
                return attr.getValue();
            }
        }

        // �����ł��܂���ł����B
        return null;
    }
}
