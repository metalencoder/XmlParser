package Mine.SaxParser;

import Mine.Entities.Root;

import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class OwnSaxParser {

    public Root parse(String filePath) throws Exception {

        var saxParser = SAXParserFactory.newInstance().newSAXParser();

        var parsingHandler = new OwnParsingHandler();
        saxParser.parse(new File(filePath), parsingHandler);
        return parsingHandler.getRoot();
    }
}
