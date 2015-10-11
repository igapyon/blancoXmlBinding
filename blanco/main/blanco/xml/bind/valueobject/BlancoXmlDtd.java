/*
 * ���̃\�[�X�R�[�h�� blanco Framework�ɂ�莩����������܂����B
 */
package blanco.xml.bind.valueobject;

/**
 * SAX�C�x���g�̂��� DTD���L�����܂��B���̃N���X�� XML/�o�����[�I�u�W�F�N�g�}�b�s���O (X/O�}�b�s���O) blancoXmlBinding �̈ꕔ�ł��B
 */
public class BlancoXmlDtd extends BlancoXmlNode {
    /**
     * �\�L�@���B
     *
     * �t�B�[���h: [name]�B
     */
    private String fName;

    /**
     * �\�L�@�̌��J���ʎq�B
     *
     * �t�B�[���h: [publicId]�B
     */
    private String fPublicId;

    /**
     * �\�L�@�̃V�X�e�����ʎq�B
     *
     * �t�B�[���h: [systemId]�B
     */
    private String fSystemId;

    /**
     * �t�B�[���h [name] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [�\�L�@���B]�B
     *
     * @param argName �t�B�[���h[name]�ɐݒ肷��l�B
     */
    public void setName(final String argName) {
        fName = argName;
    }

    /**
     * �t�B�[���h [name] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [�\�L�@���B]�B
     *
     * @return �t�B�[���h[name]����擾�����l�B
     */
    public String getName() {
        return fName;
    }

    /**
     * �t�B�[���h [publicId] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [�\�L�@�̌��J���ʎq�B]�B
     *
     * @param argPublicId �t�B�[���h[publicId]�ɐݒ肷��l�B
     */
    public void setPublicId(final String argPublicId) {
        fPublicId = argPublicId;
    }

    /**
     * �t�B�[���h [publicId] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [�\�L�@�̌��J���ʎq�B]�B
     *
     * @return �t�B�[���h[publicId]����擾�����l�B
     */
    public String getPublicId() {
        return fPublicId;
    }

    /**
     * �t�B�[���h [systemId] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [�\�L�@�̃V�X�e�����ʎq�B]�B
     *
     * @param argSystemId �t�B�[���h[systemId]�ɐݒ肷��l�B
     */
    public void setSystemId(final String argSystemId) {
        fSystemId = argSystemId;
    }

    /**
     * �t�B�[���h [systemId] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [�\�L�@�̃V�X�e�����ʎq�B]�B
     *
     * @return �t�B�[���h[systemId]����擾�����l�B
     */
    public String getSystemId() {
        return fSystemId;
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
        buf.append("blanco.xml.bind.valueobject.BlancoXmlDtd[");
        buf.append("name=" + fName);
        buf.append(",publicId=" + fPublicId);
        buf.append(",systemId=" + fSystemId);
        buf.append("]");
        return buf.toString();
    }
}
