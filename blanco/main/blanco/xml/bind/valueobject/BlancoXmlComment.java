/*
 * ���̃\�[�X�R�[�h�� blanco Framework�ɂ�莩����������܂����B
 */
package blanco.xml.bind.valueobject;

/**
 * SAX�C�x���g�̂��� �R�����g���L�����܂��B���̃N���X�� XML/�o�����[�I�u�W�F�N�g�}�b�s���O (X/O�}�b�s���O) blancoXmlBinding �̈ꕔ�ł��B
 */
public class BlancoXmlComment extends BlancoXmlNode {
    /**
     * �R�����g�f�[�^�B
     *
     * �t�B�[���h: [value]�B
     */
    private String fValue;

    /**
     * �t�B�[���h [value] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [�R�����g�f�[�^�B]�B
     *
     * @param argValue �t�B�[���h[value]�ɐݒ肷��l�B
     */
    public void setValue(final String argValue) {
        fValue = argValue;
    }

    /**
     * �t�B�[���h [value] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [�R�����g�f�[�^�B]�B
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
        buf.append("blanco.xml.bind.valueobject.BlancoXmlComment[");
        buf.append("value=" + fValue);
        buf.append("]");
        return buf.toString();
    }
}
