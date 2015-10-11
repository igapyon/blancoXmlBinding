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

import java.util.Stack;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.DTDHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.ext.LexicalHandler;

import blanco.xml.bind.valueobject.BlancoXmlAttribute;
import blanco.xml.bind.valueobject.BlancoXmlCdata;
import blanco.xml.bind.valueobject.BlancoXmlCharacters;
import blanco.xml.bind.valueobject.BlancoXmlComment;
import blanco.xml.bind.valueobject.BlancoXmlDocument;
import blanco.xml.bind.valueobject.BlancoXmlDtd;
import blanco.xml.bind.valueobject.BlancoXmlElement;
import blanco.xml.bind.valueobject.BlancoXmlIgnorableWhitespace;
import blanco.xml.bind.valueobject.BlancoXmlLocator;
import blanco.xml.bind.valueobject.BlancoXmlNode;
import blanco.xml.bind.valueobject.BlancoXmlPrefixMapping;

/**
 * XML ���� blancoXmlBinding �̃o�����[�I�u�W�F�N�g�\���𐶐����邽�߂̃R���e���c�n���h�������ł��B
 * 
 * ���̃N���X�� XML/�o�����[�I�u�W�F�N�g�}�b�s���O (X/O�}�b�s���O) blancoXmlBinding �̈ꕔ�ł��B
 * 
 * javax.xml.transform.sax.TransformerHandler �̗��Ԃ��ɂȂ�܂��B
 * 
 * @author IGA Tosiki
 */
public class BlancoXmlUnmarshallerContentHandler implements ContentHandler,
        LexicalHandler, DTDHandler {
    /**
     * �����������̂��߂Ȃǂɕ�����̃L���b�V���Ȃǂ��������܂������A�ނ��눫�����܂����B<br>
     * �����_�ł͏��׍H�͂����ɁA�����̉��P�ɒ��͂��邱�ƂƂ��܂��B
     * 
     * ���ʂ̂Ȃ����������́A�ȉ��̂悤�� Map���������� �����񋤗L���B // private Map<String, String>
     * fStringMap = new HashMap<String, String>();
     */

    /**
     * ���[�g�h�L�������g���L�����܂��B
     */
    protected final BlancoXmlDocument fDocument = new BlancoXmlDocument();

    /**
     * ���ݏ������̃|�C���g���L�����܂��B
     */
    protected final Stack<BlancoXmlNode> fDocumentElementStack = new Stack<BlancoXmlNode>();

    /**
     * �R���e���g�n���h���I�u�W�F�N�g��V�K�쐬���܂��B
     */
    public BlancoXmlUnmarshallerContentHandler() {
        fDocumentElementStack.push(fDocument);
    }

    /**
     * ���[�g�h�L�������g���擾���܂��B
     * 
     * @return XML �h�L�������g�B
     */
    public BlancoXmlDocument getDocument() {
        return fDocument;
    }

    // ------------------------------------------------
    // ��������� ContentHandler �̂��߂̃��\�b�h�B
    // ------------------------------------------------

    /**
     * ContentHandler �̃h�L�������g�J�n�C�x���g�B
     */
    public void startDocument() throws SAXException {
        // ����push�ς݂ł��B
    }

    /**
     * ContentHandler �̃h�L�������g�I���C�x���g�B
     */
    public void endDocument() throws SAXException {
        fDocumentElementStack.pop();
    }

    /**
     * ContentHandler �̃��P�[�^�C�x���g�B
     * 
     * @param argLocator
     *            SAX �h�L�������g�C�x���g�̈ʒu�B
     */
    public void setDocumentLocator(final Locator argLocator) {
        final BlancoXmlLocator locator = new BlancoXmlLocator();

        // ���ݏ������̃I�u�W�F�N�g���擾���܂��B
        final BlancoXmlNode objCurrent = fDocumentElementStack.peek();
        if (objCurrent instanceof BlancoXmlDocument == false) {
            throw new IllegalArgumentException(
                    "BlancoXmlUnmarshallerContentHandler: Document�ł͂Ȃ����̂ɑ΂��� Locator���Z�b�g���悤�Ƃ��܂����B");
        }

        ((BlancoXmlDocument) objCurrent).setLocator(locator);

        locator.setPublicId(argLocator.getPublicId());
        locator.setSystemId(argLocator.getSystemId());
        locator.setLineNumber(argLocator.getLineNumber());
        locator.setColumnNumber(argLocator.getColumnNumber());
    }

    /**
     * ContentHandler �� PrefixMapping �J�n�C�x���g�B
     * 
     * @param prefix
     *            ���O��ԃv���t�B�b�N�X�B
     * @param uri
     *            �v���t�B�b�N�X���}�b�v���ꂽ���O��� URI�B
     */
    public void startPrefixMapping(final String prefix, final String uri)
            throws SAXException {
        final BlancoXmlPrefixMapping prefixMapping = new BlancoXmlPrefixMapping();
        prefixMapping.setPrefix(prefix);
        prefixMapping.setUri(uri);

        // ���ݏ������̃I�u�W�F�N�g���擾���܂��B
        final BlancoXmlNode objCurrent = fDocumentElementStack.peek();
        if (objCurrent instanceof BlancoXmlDocument) {
            ((BlancoXmlDocument) objCurrent).getPrefixMappings().add(
                    prefixMapping);
        } else if (objCurrent instanceof BlancoXmlElement) {
            // �v�f�̏ꍇ�� startPrefixMapping �͖������܂��B
        } else {
            throw new IllegalArgumentException(
                    "BlancoXmlUnmarshallerContentHandler: Document �ł� Element �ł��Ȃ����̂ɑ΂��� prefixMapping ���Z�b�g���悤�Ƃ��܂����B");
        }
    }

    /**
     * ContentHandler �� PrefixMapping �I���C�x���g�B
     * 
     * @param prefix
     *            ���O��ԃv���t�B�b�N�X�B
     */
    public void endPrefixMapping(final String prefix) throws SAXException {
    }

    /**
     * ContentHandler �̗v�f�J�n�C�x���g�B
     * 
     * @param uri
     *            �v���t�B�b�N�X���}�b�v���ꂽ���O��� URI�B
     * @param localName
     *            ���[�J�����B
     * @param qName
     *            �v���t�B�b�N�X�t���C�����B
     * @param atts
     *            �A�g���r���[�g�ꗗ�B
     */
    public void startElement(final String uri, final String localName,
            final String qName, final Attributes atts) throws SAXException {
        final BlancoXmlElement element = new BlancoXmlElement();

        // ���ݏ������̃I�u�W�F�N�g���擾���܂��B
        final BlancoXmlNode objCurrent = fDocumentElementStack.peek();
        if (objCurrent instanceof BlancoXmlElement) {
            final BlancoXmlElement elementParent = ((BlancoXmlElement) objCurrent);
            elementParent.getChildNodes().add(element);
        } else if (objCurrent instanceof BlancoXmlDocument) {
            ((BlancoXmlDocument) objCurrent).getChildNodes().add(element);
        } else {
            throw new IllegalArgumentException(
                    "BlancoXmlUnmarshallerContentHandler: �z�肳��Ȃ��^["
                            + objCurrent.getClass().getName()
                            + "]�ɑ΂��� Element��ǉ����悤�Ƃ��܂����B");
        }

        // �G�������g���R�s�[���܂��B
        element.setUri(uri);
        element.setLocalName(localName);
        element.setQName(qName);

        // �A�g���r���[�g�̃R�s�[���s���܂��B
        copyAttributes(atts, element);

        fDocumentElementStack.push(element);
    }

    /**
     * �A�g���r���[�g�̃R�s�[���s���܂��B
     * 
     * @param atts
     *            �A�g���r���[�g�ꗗ�B
     * @param element
     *            ���ʐ�̃G�������g�B
     */
    protected void copyAttributes(final Attributes atts,
            final BlancoXmlElement element) {
        final int attrLength = atts.getLength();
        for (int index = 0; index < attrLength; index++) {
            final BlancoXmlAttribute attribute = new BlancoXmlAttribute();
            element.getAtts().add(attribute);

            attribute.setUri(atts.getURI(index));
            attribute.setLocalName(atts.getLocalName(index));
            attribute.setQName(atts.getQName(index));
            attribute.setType(atts.getType(index));
            attribute.setValue(atts.getValue(index));
        }
    }

    /**
     * ContentHandler �̗v�f�I���C�x���g�B
     * 
     * @param uri
     *            �v���t�B�b�N�X���}�b�v���ꂽ���O��� URI�B
     * @param localName
     *            ���[�J�����B
     * @param qName
     *            �v���t�B�b�N�X�t���C�����B
     */
    public void endElement(final String uri, final String localName,
            final String qName) throws SAXException {
        fDocumentElementStack.pop();
    }

    /**
     * ContentHandler �̕����C�x���g�B
     * 
     * @param ch
     * @param start
     * @param length
     */
    public void characters(final char[] ch, final int start, final int length)
            throws SAXException {
        final BlancoXmlCharacters characters = new BlancoXmlCharacters();

        // ���ݏ������̃I�u�W�F�N�g���擾���܂��B
        final BlancoXmlNode objCurrent = fDocumentElementStack.peek();
        if (objCurrent instanceof BlancoXmlElement) {
            ((BlancoXmlElement) objCurrent).getChildNodes().add(characters);
        } else if (objCurrent instanceof BlancoXmlCdata) {
            ((BlancoXmlCdata) objCurrent).getChildNodes().add(characters);
        } else if (objCurrent instanceof BlancoXmlDocument) {
            ((BlancoXmlDocument) objCurrent).getChildNodes().add(characters);
        } else {
            throw new IllegalArgumentException(
                    "BlancoXmlUnmarshallerContentHandler: �z�肳��Ȃ��^["
                            + objCurrent.getClass().getName()
                            + "]�ɑ΂��� Characters��ǉ����悤�Ƃ��܂����B");
        }

        characters.setValue(new String(ch, start, length));
    }

    /**
     * ContentHandler �̖����\�����C�x���g�B
     * 
     * @param ch
     * @param start
     * @param length
     */
    public void ignorableWhitespace(final char[] ch, final int start,
            final int length) throws SAXException {
        final BlancoXmlIgnorableWhitespace ignorableWhitespace = new BlancoXmlIgnorableWhitespace();

        // ���ݏ������̃I�u�W�F�N�g���擾���܂��B
        final BlancoXmlNode objCurrent = fDocumentElementStack.peek();
        if (objCurrent instanceof BlancoXmlElement) {
            ((BlancoXmlElement) objCurrent).getChildNodes().add(
                    ignorableWhitespace);
        } else if (objCurrent instanceof BlancoXmlCdata) {
            ((BlancoXmlDocument) objCurrent).getChildNodes().add(
                    ignorableWhitespace);
        } else if (objCurrent instanceof BlancoXmlDocument) {
            ((BlancoXmlDocument) objCurrent).getChildNodes().add(
                    ignorableWhitespace);
        } else {
            throw new IllegalArgumentException(
                    "BlancoXmlUnmarshallerContentHandler: �z�肳��Ȃ��^["
                            + objCurrent.getClass().getName()
                            + "]�ɑ΂��� BlancoXmlIgnorableWhitespace��ǉ����悤�Ƃ��܂����B");
        }

        ignorableWhitespace.setValue(new String(ch, start, length));
    }

    /**
     * ContentHandler �� processingInstruction �C�x���g�B
     * 
     * @param target
     * @param data
     */
    public void processingInstruction(final String target, final String data)
            throws SAXException {
        // ���̃C�x���g�͌����_�ł̎d�l�ł͖������܂��B
    }

    /**
     * ContentHandler �� skippedEntity �C�x���g�B
     * 
     * @param name
     */
    public void skippedEntity(final String name) throws SAXException {
        // ���̃C�x���g�͌����_�ł̎d�l�ł͖������܂��B
    }

    // ------------------------------------------------
    // ��������� LexicalHandler �̂��߂̃��\�b�h�B
    // ------------------------------------------------

    /**
     * LexicalHandler �� DTD �J�n�C�x���g�B
     * 
     * @param name
     * @param publicId
     * @param systemId
     */
    public void startDTD(final String name, final String publicId,
            final String systemId) throws SAXException {
        final BlancoXmlDtd dtd = new BlancoXmlDtd();

        // ���ݏ������̃I�u�W�F�N�g���擾���܂��B
        final BlancoXmlNode objCurrent = fDocumentElementStack.peek();
        if (objCurrent instanceof BlancoXmlDocument) {
            ((BlancoXmlDocument) objCurrent).getChildNodes().add(dtd);
        } else {
            throw new IllegalArgumentException(
                    "BlancoXmlUnmarshallerContentHandler: �z�肳��Ȃ��^["
                            + objCurrent.getClass().getName()
                            + "]�ɑ΂��� BlancoXmlDtd��ǉ����悤�Ƃ��܂����B");
        }
    }

    /**
     * LexicalHandler �� DTD �I���C�x���g�B
     */
    public void endDTD() throws SAXException {
    }

    /**
     * LexicalHandler �� Entity �J�n�C�x���g�B
     * 
     * @param name
     *            �G���e�B�e�B���B
     */
    public void startEntity(final String name) throws SAXException {
        // ���݂̎d�l�ł́A�T�|�[�g�O�ł��B
    }

    /**
     * LexicalHandler �� Entity �I���C�x���g�B
     * 
     * @param name
     *            �G���e�B�e�B���B
     */
    public void endEntity(final String name) throws SAXException {
        // ���݂̎d�l�ł́A�T�|�[�g�O�ł��B
    }

    /**
     * LexicalHandler �� CDATA �J�n�C�x���g�B
     */
    public void startCDATA() throws SAXException {
        final BlancoXmlCdata cdata = new BlancoXmlCdata();

        // ���ݏ������̃I�u�W�F�N�g���擾���܂��B
        final BlancoXmlNode objCurrent = fDocumentElementStack.peek();
        if (objCurrent instanceof BlancoXmlElement) {
            final BlancoXmlElement elementParent = ((BlancoXmlElement) objCurrent);
            elementParent.getChildNodes().add(cdata);
        } else if (objCurrent instanceof BlancoXmlDocument) {
            ((BlancoXmlDocument) objCurrent).getChildNodes().add(cdata);
        } else {
            throw new IllegalArgumentException(
                    "BlancoXmlUnmarshallerContentHandler: �z�肳��Ȃ��^["
                            + objCurrent.getClass().getName()
                            + "]�ɑ΂��� CDATA��ǉ����悤�Ƃ��܂����B");
        }

        fDocumentElementStack.push(cdata);
    }

    /**
     * LexicalHandler �� CDATA �I���C�x���g�B
     */
    public void endCDATA() throws SAXException {
        fDocumentElementStack.pop();
    }

    /**
     * LexicalHandler �� �R�����g�C�x���g�B
     * 
     * @param ch
     * @param start
     * @param length
     */
    public void comment(final char[] ch, final int start, final int length)
            throws SAXException {
        final BlancoXmlComment comment = new BlancoXmlComment();

        // ���ݏ������̃I�u�W�F�N�g���擾���܂��B
        final BlancoXmlNode objCurrent = fDocumentElementStack.peek();
        if (objCurrent instanceof BlancoXmlElement) {
            ((BlancoXmlElement) objCurrent).getChildNodes().add(comment);
        } else if (objCurrent instanceof BlancoXmlDocument) {
            ((BlancoXmlDocument) objCurrent).getChildNodes().add(comment);
        } else {
            throw new IllegalArgumentException(
                    "BlancoXmlUnmarshallerContentHandler: �z�肳��Ȃ��^["
                            + objCurrent.getClass().getName()
                            + "]�ɑ΂��� BlancoXmlComment��ǉ����悤�Ƃ��܂����B");
        }

        comment.setValue(new String(ch, start, length));
    }

    // ------------------------------------------------
    // ��������� DTDHandler �̂��߂̃��\�b�h�B
    // ------------------------------------------------

    public void notationDecl(final String name, final String publicId,
            final String systemId) throws SAXException {
        // TODO �������B
    }

    public void unparsedEntityDecl(final String name, final String publicId,
            final String systemId, final String notationName)
            throws SAXException {
        // TODO �������B
    }
}
