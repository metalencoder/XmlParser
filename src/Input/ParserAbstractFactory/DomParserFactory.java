package Input.ParserAbstractFactory;

import Input.DomParser.OwnDomParser;

public class DomParserFactory extends ParserFactory{
    @Override
    public Parser createParser() {
        return new OwnDomParser();
    }
}
