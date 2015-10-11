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

import java.io.File;

import junit.framework.TestCase;
import blanco.xml.bind.valueobject.BlancoXmlAttribute;
import blanco.xml.bind.valueobject.BlancoXmlCharacters;
import blanco.xml.bind.valueobject.BlancoXmlDocument;
import blanco.xml.bind.valueobject.BlancoXmlElement;

public class BlancoXmlMarshaller3Test extends TestCase {
    /**
     * �ȒP�Ɏ������Ƃ��� Eclipse 3.1.1�̃f�t�H���g�l�� 80000�����x�����E�B<br>
     * 2006.05.03 XML�t�@�C�������ꂽ�ۂ̃T�C�Y�� 6,617,914 �o�C�g (JDK 1.4.2�x�[�X)
     */
    private static final int COUNT = 80000;

    // private static final int COUNT = 10;

    public void testParse() throws Exception {
        BlancoXmlDocument document = new BlancoXmlDocument();

        final BlancoXmlElement element = new BlancoXmlElement();
        element.setQName("RootElement");
        document.getChildNodes().add(element);

        final BlancoXmlAttribute attr = new BlancoXmlAttribute();
        element.getAtts().add(attr);
        attr.setQName("abc");
        attr.setValue("����f�[�^�̎���");
        attr.setType("CDATA");

        final BlancoXmlElement element2 = new BlancoXmlElement();
        element.getChildNodes().add(element2);
        element2.setQName("ITEMS");

        final BlancoXmlCharacters characters = new BlancoXmlCharacters();
        characters.setValue("����͒l�ł��B");

        element2.getChildNodes().add(characters);

        for (int index = 0; index < COUNT; index++) {
            final BlancoXmlElement elementChild = new BlancoXmlElement();
            element2.getChildNodes().add(elementChild);
            elementChild.setQName("ITEM");

            final BlancoXmlAttribute attrChild = new BlancoXmlAttribute();
            elementChild.getAtts().add(attrChild);
            attrChild.setQName("index");
            attrChild.setValue("" + index);

            final BlancoXmlCharacters charactersChild = new BlancoXmlCharacters();
            charactersChild.setValue("��ʃf�[�^�̂���" + index + "�Ԗڂ̃f�[�^�ł��B");
            elementChild.getChildNodes().add(charactersChild);
        }

        System.out.println("�f�[�^�\���\�z�����B");

        new File("./tmp").mkdirs();
        new BlancoXmlMarshaller().marshal(document, new File(
                "./tmp/BlancoXmlMarshaller3Test.xml"));

        System.out.println("�f�[�^�\���ۑ������B");

        // �ȑO�̏��͔j�����܂��B
        document = null;

        // �ǂݍ��݂̍ۂɂ͏ڍׂȃf�[�^���t�^����Ă���̂ŁA
        // �������݂��ł����Ƃ��Ă��ǂݍ��݂��ł��Ȃ��ꍇ������_�ɒ��ӁB

        @SuppressWarnings("unused")
        final BlancoXmlDocument documentRead = new BlancoXmlUnmarshaller()
                .unmarshal(new File("./tmp/BlancoXmlMarshaller3Test.xml"));
        // System.out.println(documentRead);

        System.out.println("�f�[�^�\���Ǎ������B");
    }
}
