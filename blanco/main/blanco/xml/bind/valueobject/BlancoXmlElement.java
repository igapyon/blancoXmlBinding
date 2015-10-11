/*
 * ���̃\�[�X�R�[�h�� blanco Framework�ɂ�莩����������܂����B
 */
package blanco.xml.bind.valueobject;

import java.util.List;

/**
 * SAX�C�x���g�̂��� �v�f(Element)���L�����܂��B���̃N���X�� XML/�o�����[�I�u�W�F�N�g�}�b�s���O (X/O�}�b�s���O) blancoXmlBinding �̈ꕔ�ł��B
 */
public class BlancoXmlElement extends BlancoXmlNode {
    /**
     * ���O���URI�B
     *
     * �t�B�[���h: [uri]�B
     */
    private String fUri;

    /**
     * ���[�J�����B
     *
     * �t�B�[���h: [localName]�B
     */
    private String fLocalName;

    /**
     * �O�u�C���q�t���̏C�����B
     *
     * �t�B�[���h: [qName]�B
     */
    private String fQName;

    /**
     * blanco.xml.BlancoXmlAttribute�̃��X�g�B
     *
     * �t�B�[���h: [atts]�B
     * �f�t�H���g: [new java.util.ArrayList<blanco.xml.bind.valueobject.BlancoXmlAttribute>()]�B
     */
    private List<blanco.xml.bind.valueobject.BlancoXmlAttribute> fAtts = new java.util.ArrayList<blanco.xml.bind.valueobject.BlancoXmlAttribute>();

    /**
     * �q�m�[�h�̃��X�g�B
     *
     * �t�B�[���h: [childNodes]�B
     * �f�t�H���g: [new java.util.ArrayList<blanco.xml.bind.valueobject.BlancoXmlNode>()]�B
     */
    private List<blanco.xml.bind.valueobject.BlancoXmlNode> fChildNodes = new java.util.ArrayList<blanco.xml.bind.valueobject.BlancoXmlNode>();

    /**
     * �t�B�[���h [uri] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���O���URI�B]�B
     *
     * @param argUri �t�B�[���h[uri]�ɐݒ肷��l�B
     */
    public void setUri(final String argUri) {
        fUri = argUri;
    }

    /**
     * �t�B�[���h [uri] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [���O���URI�B]�B
     *
     * @return �t�B�[���h[uri]����擾�����l�B
     */
    public String getUri() {
        return fUri;
    }

    /**
     * �t�B�[���h [localName] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���[�J�����B]�B
     *
     * @param argLocalName �t�B�[���h[localName]�ɐݒ肷��l�B
     */
    public void setLocalName(final String argLocalName) {
        fLocalName = argLocalName;
    }

    /**
     * �t�B�[���h [localName] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [���[�J�����B]�B
     *
     * @return �t�B�[���h[localName]����擾�����l�B
     */
    public String getLocalName() {
        return fLocalName;
    }

    /**
     * �t�B�[���h [qName] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [�O�u�C���q�t���̏C�����B]�B
     *
     * @param argQName �t�B�[���h[qName]�ɐݒ肷��l�B
     */
    public void setQName(final String argQName) {
        fQName = argQName;
    }

    /**
     * �t�B�[���h [qName] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [�O�u�C���q�t���̏C�����B]�B
     *
     * @return �t�B�[���h[qName]����擾�����l�B
     */
    public String getQName() {
        return fQName;
    }

    /**
     * �t�B�[���h [atts] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [blanco.xml.BlancoXmlAttribute�̃��X�g�B]�B
     *
     * @param argAtts �t�B�[���h[atts]�ɐݒ肷��l�B
     */
    public void setAtts(final List<blanco.xml.bind.valueobject.BlancoXmlAttribute> argAtts) {
        fAtts = argAtts;
    }

    /**
     * �t�B�[���h [atts] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [blanco.xml.BlancoXmlAttribute�̃��X�g�B]�B
     * �f�t�H���g: [new java.util.ArrayList<blanco.xml.bind.valueobject.BlancoXmlAttribute>()]�B
     *
     * @return �t�B�[���h[atts]����擾�����l�B
     */
    public List<blanco.xml.bind.valueobject.BlancoXmlAttribute> getAtts() {
        return fAtts;
    }

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
        buf.append("blanco.xml.bind.valueobject.BlancoXmlElement[");
        buf.append("uri=" + fUri);
        buf.append(",localName=" + fLocalName);
        buf.append(",qName=" + fQName);
        buf.append(",atts=" + fAtts);
        buf.append(",childNodes=" + fChildNodes);
        buf.append("]");
        return buf.toString();
    }
}
