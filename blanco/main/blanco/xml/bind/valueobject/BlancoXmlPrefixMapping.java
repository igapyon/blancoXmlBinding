/*
 * ���̃\�[�X�R�[�h�� blanco Framework�ɂ�莩����������܂����B
 */
package blanco.xml.bind.valueobject;

/**
 * SAX�C�x���g�̂��� prefixMapping���L�����܂��B���̃N���X�� XML/�o�����[�I�u�W�F�N�g�}�b�s���O (X/O�}�b�s���O) blancoXmlBinding �̈ꕔ�ł��B
 */
public class BlancoXmlPrefixMapping {
    /**
     * ��: rdf
     *
     * �t�B�[���h: [prefix]�B
     * �f�t�H���g: [""]�B
     */
    private String fPrefix = "";

    /**
     * ��: http://www.w3.org/1999/02/22-rdf-syntax-ns#
     *
     * �t�B�[���h: [uri]�B
     */
    private String fUri;

    /**
     * �t�B�[���h [prefix] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [��: rdf]�B
     *
     * @param argPrefix �t�B�[���h[prefix]�ɐݒ肷��l�B
     */
    public void setPrefix(final String argPrefix) {
        fPrefix = argPrefix;
    }

    /**
     * �t�B�[���h [prefix] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [��: rdf]�B
     * �f�t�H���g: [""]�B
     *
     * @return �t�B�[���h[prefix]����擾�����l�B
     */
    public String getPrefix() {
        return fPrefix;
    }

    /**
     * �t�B�[���h [uri] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [��: http://www.w3.org/1999/02/22-rdf-syntax-ns#]�B
     *
     * @param argUri �t�B�[���h[uri]�ɐݒ肷��l�B
     */
    public void setUri(final String argUri) {
        fUri = argUri;
    }

    /**
     * �t�B�[���h [uri] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [��: http://www.w3.org/1999/02/22-rdf-syntax-ns#]�B
     *
     * @return �t�B�[���h[uri]����擾�����l�B
     */
    public String getUri() {
        return fUri;
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
        buf.append("blanco.xml.bind.valueobject.BlancoXmlPrefixMapping[");
        buf.append("prefix=" + fPrefix);
        buf.append(",uri=" + fUri);
        buf.append("]");
        return buf.toString();
    }
}
