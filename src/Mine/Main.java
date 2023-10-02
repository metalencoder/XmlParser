package Mine;

import Mine.DomParser.OwnDomParser;
import Mine.SaxParser.OwnSaxParser;

public class Main {
    public static void main(String[] args) {
        OwnSaxParser saxParser = new OwnSaxParser();
        OwnDomParser domParser = new OwnDomParser();
        try {
            var root1 = saxParser.parse("C:\\Users\\helli\\\\Desktop\\PKP\\XmlParser\\src\\Mine\\Furniture.xml");
            var root2 = domParser.parse("C:\\Users\\helli\\Desktop\\PKP\\XmlParser\\src\\Mine\\Furniture.xml");
           System.out.println( root1.toString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
