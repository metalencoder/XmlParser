import Entities.Prototype.RootCopier;
import Input.DomParser.OwnDomParser;
import Input.ParserAbstractFactory.DomParserFactory;
import Input.ParserAbstractFactory.ParserFactory;
import Input.ParserAbstractFactory.SaxParserFactory;
import Input.SaxParser.OwnSaxParser;
import Output.ParseToXml;

public class Main {
    public static void main(String[] args) throws Exception {

        ParserFactory factory = new DomParserFactory();
        var parser = factory.createParser();
        var root = parser.parse("C:\\Users\\helli\\Desktop\\PKP\\XmlParser\\src\\Furniture.xml");
        var furniture = new RootCopier(root).cloneRoot().getFurnitureList();

        long amountOfBelarussianItems = furniture.stream().filter((item)->item.getCountry().equals("Беларусь")).count();
        long amountOfBeds = furniture.stream().filter((item)->item.getType().equals("Кровать")).count();
        long amountOfWoodenFurniture = furniture.stream().filter((item)->item.getMaterial().equals("Дерево")).count();
        long amountOfRedFurniture = furniture.stream().filter((item)->item.getColor().equals("Коричневый")).count();

        System.out.println( "Amount of Belorussian items: " +  amountOfBelarussianItems);
        System.out.println( "Amount of beds: " +  amountOfBeds);
        System.out.println( "Amount of wooden furniture: " +  amountOfWoodenFurniture);
        System.out.println( "Amount of red furniture: " +  amountOfRedFurniture);
    }
}
