/*
 * ���̃\�[�X�R�[�h�� blanco Framework�ɂ�莩����������܂����B
 */
package blanco.xml.bind.valueobject;

import java.util.List;

/**
 * SAX�C�x���g�̂��� �h�L�������g���L�����܂��B���̃N���X�� XML/�o�����[�I�u�W�F�N�g�}�b�s���O (X/O�}�b�s���O) blancoXmlBinding �̈ꕔ�ł��B
 */
public class BlancoXmlDocument extends BlancoXmlNode {
    /**
     * ���̃h�L�������g�ɘA�Ȃ�q�m�[�h���i�[���܂��B�h�L�������g�͑����̏ꍇ�ЂƂ̃��[�g�G�������g���i�[���Ă��܂��B�ꍇ�ɂ�� DTD�֘A���Ȃǂ��i�[����܂��B
     *
     * �t�B�[���h: [childNodes]�B
     * �f�t�H���g: [new java.util.ArrayList<blanco.xml.bind.valueobject.BlancoXmlNode>()]�B
     */
    private List<blanco.xml.bind.valueobject.BlancoXmlNode> fChildNodes = new java.util.ArrayList<blanco.xml.bind.valueobject.BlancoXmlNode>();

    /**
     * ���P�[�V�����B
     *
     * �t�B�[���h: [locator]�B
     */
    private BlancoXmlLocator fLocator;

    /**
     * prefixMapping�̃��X�g���i�[���܂��B
     *
     * �t�B�[���h: [prefixMappings]�B
     * �f�t�H���g: [new java.util.ArrayList<blanco.xml.bind.valueobject.BlancoXmlPrefixMapping>()]�B
     */
    private List<blanco.xml.bind.valueobject.BlancoXmlPrefixMapping> fPrefixMappings = new java.util.ArrayList<blanco.xml.bind.valueobject.BlancoXmlPrefixMapping>();

    /**
     * XML �̃o�[�W�����B1.1 �Ȃǂ��w��B
     *
     * �t�B�[���h: [version]�B
     */
    private String fVersion;

    /**
     * XML �̃G���R�[�f�B���O
     *
     * �t�B�[���h: [encoding]�B
     */
    private String fEncoding;

    /**
     * �t�B�[���h [childNodes] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���̃h�L�������g�ɘA�Ȃ�q�m�[�h���i�[���܂��B�h�L�������g�͑����̏ꍇ�ЂƂ̃��[�g�G�������g���i�[���Ă��܂��B�ꍇ�ɂ�� DTD�֘A���Ȃǂ��i�[����܂��B]�B
     *
     * @param argChildNodes �t�B�[���h[childNodes]�ɐݒ肷��l�B
     */
    public void setChildNodes(final List<blanco.xml.bind.valueobject.BlancoXmlNode> argChildNodes) {
        fChildNodes = argChildNodes;
    }

    /**
     * �t�B�[���h [childNodes] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [���̃h�L�������g�ɘA�Ȃ�q�m�[�h���i�[���܂��B�h�L�������g�͑����̏ꍇ�ЂƂ̃��[�g�G�������g���i�[���Ă��܂��B�ꍇ�ɂ�� DTD�֘A���Ȃǂ��i�[����܂��B]�B
     * �f�t�H���g: [new java.util.ArrayList<blanco.xml.bind.valueobject.BlancoXmlNode>()]�B
     *
     * @return �t�B�[���h[childNodes]����擾�����l�B
     */
    public List<blanco.xml.bind.valueobject.BlancoXmlNode> getChildNodes() {
        return fChildNodes;
    }

    /**
     * �t�B�[���h [locator] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���P�[�V�����B]�B
     *
     * @param argLocator �t�B�[���h[locator]�ɐݒ肷��l�B
     */
    public void setLocator(final BlancoXmlLocator argLocator) {
        fLocator = argLocator;
    }

    /**
     * �t�B�[���h [locator] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [���P�[�V�����B]�B
     *
     * @return �t�B�[���h[locator]����擾�����l�B
     */
    public BlancoXmlLocator getLocator() {
        return fLocator;
    }

    /**
     * �t�B�[���h [prefixMappings] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [prefixMapping�̃��X�g���i�[���܂��B]�B
     *
     * @param argPrefixMappings �t�B�[���h[prefixMappings]�ɐݒ肷��l�B
     */
    public void setPrefixMappings(final List<blanco.xml.bind.valueobject.BlancoXmlPrefixMapping> argPrefixMappings) {
        fPrefixMappings = argPrefixMappings;
    }

    /**
     * �t�B�[���h [prefixMappings] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [prefixMapping�̃��X�g���i�[���܂��B]�B
     * �f�t�H���g: [new java.util.ArrayList<blanco.xml.bind.valueobject.BlancoXmlPrefixMapping>()]�B
     *
     * @return �t�B�[���h[prefixMappings]����擾�����l�B
     */
    public List<blanco.xml.bind.valueobject.BlancoXmlPrefixMapping> getPrefixMappings() {
        return fPrefixMappings;
    }

    /**
     * �t�B�[���h [version] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [XML �̃o�[�W�����B1.1 �Ȃǂ��w��B]�B
     *
     * @param argVersion �t�B�[���h[version]�ɐݒ肷��l�B
     */
    public void setVersion(final String argVersion) {
        fVersion = argVersion;
    }

    /**
     * �t�B�[���h [version] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [XML �̃o�[�W�����B1.1 �Ȃǂ��w��B]�B
     *
     * @return �t�B�[���h[version]����擾�����l�B
     */
    public String getVersion() {
        return fVersion;
    }

    /**
     * �t�B�[���h [encoding] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [XML �̃G���R�[�f�B���O]�B
     *
     * @param argEncoding �t�B�[���h[encoding]�ɐݒ肷��l�B
     */
    public void setEncoding(final String argEncoding) {
        fEncoding = argEncoding;
    }

    /**
     * �t�B�[���h [encoding] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [XML �̃G���R�[�f�B���O]�B
     *
     * @return �t�B�[���h[encoding]����擾�����l�B
     */
    public String getEncoding() {
        return fEncoding;
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
        buf.append("blanco.xml.bind.valueobject.BlancoXmlDocument[");
        buf.append("childNodes=" + fChildNodes);
        buf.append(",locator=" + fLocator);
        buf.append(",prefixMappings=" + fPrefixMappings);
        buf.append(",version=" + fVersion);
        buf.append(",encoding=" + fEncoding);
        buf.append("]");
        return buf.toString();
    }
}
