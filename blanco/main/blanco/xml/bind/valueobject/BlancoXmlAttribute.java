/*
 * ���̃\�[�X�R�[�h�� blanco Framework�ɂ�莩����������܂����B
 */
package blanco.xml.bind.valueobject;

/**
 * SAX�C�x���g�̂��� �v�f(Element)�̂Ȃ��� ����(Attribute)���L�����܂��B���̃N���X�� XML/�o�����[�I�u�W�F�N�g�}�b�s���O (X/O�}�b�s���O) blancoXmlBinding �̈ꕔ�ł��B
 */
public class BlancoXmlAttribute {
    /**
     * �����̖��O���URI�B
     *
     * �t�B�[���h: [uri]�B
     */
    private String fUri;

    /**
     * �����̃��[�J�����B
     *
     * �t�B�[���h: [localName]�B
     */
    private String fLocalName;

    /**
     * ������ XML 1.0 �C�����B
     *
     * �t�B�[���h: [qName]�B
     */
    private String fQName;

    /**
     * �����̌^�B&quot;CDATA&quot;, &quot;ID&quot;, &quot;IDREF&quot;, &quot;IDREFS&quot;, &quot;NMTOKEN&quot;, &quot;NMTOKENS&quot;, &quot;ENTITY&quot;, &quot;ENTITIES&quot;, &quot;NOTATION&quot; ���i�[����܂��B
     *
     * �t�B�[���h: [type]�B
     */
    private String fType;

    /**
     * �����̒l�B
     *
     * �t�B�[���h: [value]�B
     */
    private String fValue;

    /**
     * �t�B�[���h [uri] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [�����̖��O���URI�B]�B
     *
     * @param argUri �t�B�[���h[uri]�ɐݒ肷��l�B
     */
    public void setUri(final String argUri) {
        fUri = argUri;
    }

    /**
     * �t�B�[���h [uri] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [�����̖��O���URI�B]�B
     *
     * @return �t�B�[���h[uri]����擾�����l�B
     */
    public String getUri() {
        return fUri;
    }

    /**
     * �t�B�[���h [localName] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [�����̃��[�J�����B]�B
     *
     * @param argLocalName �t�B�[���h[localName]�ɐݒ肷��l�B
     */
    public void setLocalName(final String argLocalName) {
        fLocalName = argLocalName;
    }

    /**
     * �t�B�[���h [localName] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [�����̃��[�J�����B]�B
     *
     * @return �t�B�[���h[localName]����擾�����l�B
     */
    public String getLocalName() {
        return fLocalName;
    }

    /**
     * �t�B�[���h [qName] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [������ XML 1.0 �C�����B]�B
     *
     * @param argQName �t�B�[���h[qName]�ɐݒ肷��l�B
     */
    public void setQName(final String argQName) {
        fQName = argQName;
    }

    /**
     * �t�B�[���h [qName] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [������ XML 1.0 �C�����B]�B
     *
     * @return �t�B�[���h[qName]����擾�����l�B
     */
    public String getQName() {
        return fQName;
    }

    /**
     * �t�B�[���h [type] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [�����̌^�B"CDATA", "ID", "IDREF", "IDREFS", "NMTOKEN", "NMTOKENS", "ENTITY", "ENTITIES", "NOTATION" ���i�[����܂��B]�B
     *
     * @param argType �t�B�[���h[type]�ɐݒ肷��l�B
     */
    public void setType(final String argType) {
        fType = argType;
    }

    /**
     * �t�B�[���h [type] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [�����̌^�B"CDATA", "ID", "IDREF", "IDREFS", "NMTOKEN", "NMTOKENS", "ENTITY", "ENTITIES", "NOTATION" ���i�[����܂��B]�B
     *
     * @return �t�B�[���h[type]����擾�����l�B
     */
    public String getType() {
        return fType;
    }

    /**
     * �t�B�[���h [value] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [�����̒l�B]�B
     *
     * @param argValue �t�B�[���h[value]�ɐݒ肷��l�B
     */
    public void setValue(final String argValue) {
        fValue = argValue;
    }

    /**
     * �t�B�[���h [value] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [�����̒l�B]�B
     *
     * @return �t�B�[���h[value]����擾�����l�B
     */
    public String getValue() {
        return fValue;
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
        buf.append("blanco.xml.bind.valueobject.BlancoXmlAttribute[");
        buf.append("uri=" + fUri);
        buf.append(",localName=" + fLocalName);
        buf.append(",qName=" + fQName);
        buf.append(",type=" + fType);
        buf.append(",value=" + fValue);
        buf.append("]");
        return buf.toString();
    }
}
