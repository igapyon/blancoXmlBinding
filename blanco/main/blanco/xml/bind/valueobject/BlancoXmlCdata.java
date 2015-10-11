/*
 * ���̃\�[�X�R�[�h�� blanco Framework�ɂ�莩����������܂����B
 */
package blanco.xml.bind.valueobject;

import java.util.List;

/**
 * SAX�C�x���g�̂��� CDATA ���L�����܂��B���̃N���X�� XML/�o�����[�I�u�W�F�N�g�}�b�s���O (X/O�}�b�s���O) blancoXmlBinding �̈ꕔ�ł��B
 */
public class BlancoXmlCdata extends BlancoXmlNode {
    /**
     * �q�m�[�h�̃��X�g�B
     *
     * �t�B�[���h: [childNodes]�B
     * �f�t�H���g: [new java.util.ArrayList<blanco.xml.bind.valueobject.BlancoXmlNode>()]�B
     */
    private List<blanco.xml.bind.valueobject.BlancoXmlNode> fChildNodes = new java.util.ArrayList<blanco.xml.bind.valueobject.BlancoXmlNode>();

    /**
     * �t�B�[���h [childNodes] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [�q�m�[�h�̃��X�g�B]�B
     *
     * @param argChildNodes �t�B�[���h[childNodes]�ɐݒ肷��l�B
     */
    public void setChildNodes(final List<blanco.xml.bind.valueobject.BlancoXmlNode> argChildNodes) {
        fChildNodes = argChildNodes;
    }

    /**
     * �t�B�[���h [childNodes] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [�q�m�[�h�̃��X�g�B]�B
     * �f�t�H���g: [new java.util.ArrayList<blanco.xml.bind.valueobject.BlancoXmlNode>()]�B
     *
     * @return �t�B�[���h[childNodes]����擾�����l�B
     */
    public List<blanco.xml.bind.valueobject.BlancoXmlNode> getChildNodes() {
        return fChildNodes;
    }

    /**
     * ���̃o�����[�I�u�W�F�N�g�̕�����\�����擾���܂��B
     *
     * <P>�g�p��̒���</P>
     * <UL>
     * <LI>�I�u�W�F�N�g�̃V�����[�͈͂̂ݕ����񉻂̏����ΏۂƂȂ�܂��B
     * <LI>�I�u�W�F�N�g���z�Q�Ƃ��Ă���ꍇ�ɂ́A���̃��\�b�h�͎g��Ȃ��ł��������B
     * </UL>
     *
     * @return �o�����[�I�u�W�F�N�g�̕�����\���B
     */
    @Override
    public String toString() {
        final StringBuffer buf = new StringBuffer();
        buf.append("blanco.xml.bind.valueobject.BlancoXmlCdata[");
        buf.append("childNodes=" + fChildNodes);
        buf.append("]");
        return buf.toString();
    }
}
