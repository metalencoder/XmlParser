package Input.ParserAbstractFactory;

import Input.SaxParser.OwnSaxParser;

public class SaxParserFactory extends ParserFactory{

    @Override
    public Parser createParser() {
        return new OwnSaxParser();
    }
}
