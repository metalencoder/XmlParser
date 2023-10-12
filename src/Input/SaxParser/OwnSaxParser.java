package Input.SaxParser;

import Entities.Root;
import Input.ParserAbstractFactory.Parser;

import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class OwnSaxParser implements Parser {

    public Root parse(String filePath) throws Exception {
        //Создаем парсер
        var saxParser = SAXParserFactory.newInstance().newSAXParser();

        //Создаем написанный нами handler
        var parsingHandler = new OwnParsingHandler();
        saxParser.parse(new File(filePath), parsingHandler);
        return parsingHandler.getRoot();
    }
}
