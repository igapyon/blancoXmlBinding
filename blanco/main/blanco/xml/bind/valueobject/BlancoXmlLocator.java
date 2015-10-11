/*
 * ���̃\�[�X�R�[�h�� blanco Framework�ɂ�莩����������܂����B
 */
package blanco.xml.bind.valueobject;

/**
 * SAX�C�x���g�̂��� Locator���L�����܂��B���̃N���X�� XML/�o�����[�I�u�W�F�N�g�}�b�s���O (X/O�}�b�s���O) blancoXmlBinding �̈ꕔ�ł��B
 */
public class BlancoXmlLocator {
    /**
     * �����C�x���g�̌��J���ʎq�B
     *
     * �t�B�[���h: [publicId]�B
     */
    private String fPublicId;

    /**
     * �����C�x���g�̃V�X�e�����ʎq�B
     *
     * �t�B�[���h: [systemId]�B
     */
    private String fSystemId;

    /**
     * �����C�x���g���I������s�ԍ��B
     *
     * �t�B�[���h: [lineNumber]�B
     * �f�t�H���g: [-1]�B
     */
    private int fLineNumber = -1;

    /**
     * �����C�x���g���I�������ԍ��B
     *
     * �t�B�[���h: [columnNumber]�B
     * �f�t�H���g: [-1]�B
     */
    private int fColumnNumber = -1;

    /**
     * �t�B�[���h [publicId] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [�����C�x���g�̌��J���ʎq�B]�B
     *
     * @param argPublicId �t�B�[���h[publicId]�ɐݒ肷��l�B
     */
    public void setPublicId(final String argPublicId) {
        fPublicId = argPublicId;
    }

    /**
     * �t�B�[���h [publicId] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [�����C�x���g�̌��J���ʎq�B]�B
     *
     * @return �t�B�[���h[publicId]����擾�����l�B
     */
    public String getPublicId() {
        return fPublicId;
    }

    /**
     * �t�B�[���h [systemId] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [�����C�x���g�̃V�X�e�����ʎq�B]�B
     *
     * @param argSystemId �t�B�[���h[systemId]�ɐݒ肷��l�B
     */
    public void setSystemId(final String argSystemId) {
        fSystemId = argSystemId;
    }

    /**
     * �t�B�[���h [systemId] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [�����C�x���g�̃V�X�e�����ʎq�B]�B
     *
     * @return �t�B�[���h[systemId]����擾�����l�B
     */
    public String getSystemId() {
        return fSystemId;
    }

    /**
     * �t�B�[���h [lineNumber] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [�����C�x���g���I������s�ԍ��B]�B
     *
     * @param argLineNumber �t�B�[���h[lineNumber]�ɐݒ肷��l�B
     */
    public void setLineNumber(final int argLineNumber) {
        fLineNumber = argLineNumber;
    }

    /**
     * �t�B�[���h [lineNumber] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [�����C�x���g���I������s�ԍ��B]�B
     * �f�t�H���g: [-1]�B
     *
     * @return �t�B�[���h[lineNumber]����擾�����l�B
     */
    public int getLineNumber() {
        return fLineNumber;
    }

    /**
     * �t�B�[���h [columnNumber] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [�����C�x���g���I�������ԍ��B]�B
     *
     * @param argColumnNumber �t�B�[���h[columnNumber]�ɐݒ肷��l�B
     */
    public void setColumnNumber(final int argColumnNumber) {
        fColumnNumber = argColumnNumber;
    }

    /**
     * �t�B�[���h [columnNumber] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [�����C�x���g���I�������ԍ��B]�B
     * �f�t�H���g: [-1]�B
     *
     * @return �t�B�[���h[columnNumber]����擾�����l�B
     */
    public int getColumnNumber() {
        return fColumnNumber;
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
        buf.append("blanco.xml.bind.valueobject.BlancoXmlLocator[");
        buf.append("publicId=" + fPublicId);
        buf.append(",systemId=" + fSystemId);
        buf.append(",lineNumber=" + fLineNumber);
        buf.append(",columnNumber=" + fColumnNumber);
        buf.append("]");
        return buf.toString();
    }
}
