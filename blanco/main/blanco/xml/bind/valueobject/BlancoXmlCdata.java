/*
 * このソースコードは blanco Frameworkにより自動生成されました。
 */
package blanco.xml.bind.valueobject;

import java.util.List;

/**
 * SAXイベントのうち CDATA を記憶します。このクラスは XML/バリューオブジェクトマッピング (X/Oマッピング) blancoXmlBinding の一部です。
 */
public class BlancoXmlCdata extends BlancoXmlNode {
    /**
     * 子ノードのリスト。
     *
     * フィールド: [childNodes]。
     * デフォルト: [new java.util.ArrayList<blanco.xml.bind.valueobject.BlancoXmlNode>()]。
     */
    private List<blanco.xml.bind.valueobject.BlancoXmlNode> fChildNodes = new java.util.ArrayList<blanco.xml.bind.valueobject.BlancoXmlNode>();

    /**
     * フィールド [childNodes] の値を設定します。
     *
     * フィールドの説明: [子ノードのリスト。]。
     *
     * @param argChildNodes フィールド[childNodes]に設定する値。
     */
    public void setChildNodes(final List<blanco.xml.bind.valueobject.BlancoXmlNode> argChildNodes) {
        fChildNodes = argChildNodes;
    }

    /**
     * フィールド [childNodes] の値を取得します。
     *
     * フィールドの説明: [子ノードのリスト。]。
     * デフォルト: [new java.util.ArrayList<blanco.xml.bind.valueobject.BlancoXmlNode>()]。
     *
     * @return フィールド[childNodes]から取得した値。
     */
    public List<blanco.xml.bind.valueobject.BlancoXmlNode> getChildNodes() {
        return fChildNodes;
    }

    /**
     * このバリューオブジェクトの文字列表現を取得します。
     *
     * <P>使用上の注意</P>
     * <UL>
     * <LI>オブジェクトのシャロー範囲のみ文字列化の処理対象となります。
     * <LI>オブジェクトが循環参照している場合には、このメソッドは使わないでください。
     * </UL>
     *
     * @return バリューオブジェクトの文字列表現。
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
