package Mine.DomParser;

import Mine.Entities.Furniture;
import Mine.Entities.AvailabilityInfo;
import Mine.Entities.Root;
import Mine.Entities.Shop;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;

public class OwnDomParser {
    private String filePath;

    private Document openFile() throws Exception {
        //Создаем билдер представлений документов
        var documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilderFactory.setNamespaceAware(true);
        documentBuilderFactory.setIgnoringComments(true);
        return documentBuilderFactory.newDocumentBuilder().parse(new File(filePath));
    }

    //Парсинг всего документа
    public Root parse(String filePath) throws Exception {

        this.filePath = filePath;
        Document document = openFile();
        var content = document.getFirstChild().getChildNodes();
        Root root = new Root();
        for (int i = 0; i < content.getLength(); i++) {

            //Получаем название тэга
            switch (content.item(i).getNodeName()) {
                case "name": {

                    //Получили имя документа
                    root.setName(content.item(i).getTextContent());
                    break;
                }

                //Если наткнулись на тэг FurnitureList
                case "FurnitureList": {

                    //Получаем все дочерние элементы (Второй уровень вложенности)
                    var furnitureNodes = content.item(i).getChildNodes();
                    var furniture = new ArrayList<Furniture>();

                    //Парсим каждый дочерний элемент отдельно
                    for (int j = 0; j < furnitureNodes.getLength(); j++) {
                        //Если узел это какой-то пробел или мусор то пропускаем
                        if (furnitureNodes.item(j).getNodeType() != Node.ELEMENT_NODE) continue;

                        //Парсим второй уровень вложенности
                        furniture.add(parseFurniture(furnitureNodes.item(j)));
                    }
                    root.setFurnitureList(furniture);
                    break;
                }
            }
        }
        return root;
    }

    //Парсинг 2-ого уровня вложенности
    private Furniture parseFurniture(Node furnitureNode) {

        //Получаем поля класса Furniture (3 уровень вложенности)
        var furnitureFields = furnitureNode.getChildNodes();

        var furniture = new Furniture();

        for (int i = 0; i < furnitureFields.getLength(); i++) {

            switch (furnitureFields.item(i).getNodeName()) {
                case "type": {
                    furniture.setType(furnitureFields.item(i).getTextContent());
                    break;
                }
                case "country": {
                    furniture.setCountry(furnitureFields.item(i).getTextContent());
                    break;
                }
                case "manufacturer": {
                    furniture.setManufacturer(furnitureFields.item(i).getTextContent());
                    break;
                }
                case "material": {
                    furniture.setMaterial(furnitureFields.item(i).getTextContent());
                    break;
                }
                case "color": {
                    furniture.setColor(furnitureFields.item(i).getTextContent());
                    break;
                }
                //Наткнули на следующий уровень вложенности
                case "PriceList": {

                    //Получаем все элементы 4-го уровня вложенности
                    var availabilityInfoFields = furnitureFields.item(i).getChildNodes();
                    var availabilityInfos = new ArrayList<AvailabilityInfo>();

                    //Парсим по отдельности
                    for (int j = 0; j < availabilityInfoFields.getLength(); j++) {

                        if (availabilityInfoFields.item(j).getNodeType() != Node.ELEMENT_NODE) continue;

                        availabilityInfos.add(parseAvailabilityInfo(availabilityInfoFields.item(j)));
                    }
                    furniture.setAvailabilityInfo(availabilityInfos);
                    break;
                }
            }
        }
        return furniture;
    }

    //Парсинг 4-ого уровня вложенности
    private AvailabilityInfo parseAvailabilityInfo(Node priceListNode) {

        //Получаем все поля четвертого уровня
        var availabilityInfoFields = priceListNode.getChildNodes();
        var availabilityInfo = new AvailabilityInfo();

        for (int i = 0; i < availabilityInfoFields.getLength(); i++) {

            //Получаем название
            switch (availabilityInfoFields.item(i).getNodeName()) {
                case "Shop": {
                    //Натыкаемся на следующий уровень вложенности
                    availabilityInfo.setShop(parseShop(availabilityInfoFields.item(i)));
                    break;
                }
                case "cost": {
                    availabilityInfo.setCost(Float.parseFloat(availabilityInfoFields.item(i).getTextContent()));
                    break;
                }
            }
        }
        return availabilityInfo;
    }

    //Парсинг 5-ого уровня вложенности
    private Shop parseShop(Node shopNode) {

        //Получаем все элементы
        var shopFields = shopNode.getChildNodes();
        var shop = new Shop();
        for (int i = 0; i < shopFields.getLength(); i++) {

            //Получаем названия
            switch (shopFields.item(i).getNodeName()) {
                case "name": {
                    shop.setName(shopFields.item(i).getTextContent());
                    break;
                }
                case "address": {
                    shop.setAddress(shopFields.item(i).getTextContent());
                    break;
                }
            }
        }
        return shop;
    }
}
