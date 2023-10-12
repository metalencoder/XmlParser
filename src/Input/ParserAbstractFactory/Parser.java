package Input.ParserAbstractFactory;

import Entities.Root;

public interface Parser {

    Root parse(String fileName) throws Exception;
}
