package Input.SaxParser;

import Entities.AvailabilityInfo;
import Entities.Furniture;
import Entities.Root;
import Entities.Shop;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

//Класс который описывает разбор нашего документа
public class OwnParsingHandler extends DefaultHandler {

    private String currentTag = "";
    private int level = 0;
    private Root root = new Root();
    private List<Furniture> furnitureList;
    private Furniture currentFurniture;
    private ArrayList<AvailabilityInfo> availabilityInfoList;
    private AvailabilityInfo availabilityInfo;
    private Shop shop = new Shop();

    public Root getRoot() {
        return root;
    }


    @Override
    public void endDocument() throws SAXException {
        availabilityInfoList.add(availabilityInfo);
        currentFurniture.setAvailabilityInfo(availabilityInfoList);
        furnitureList.add(currentFurniture);
        root.setFurnitureList(furnitureList);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {


        level++;
        //Записываем нынешний тэг
        currentTag = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        level--;
        currentTag = "";
    }


    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

        //Здесь мы получаем данные в формате char[] и записываем их в нужные поля исходя из тэга

        switch (currentTag) {

            case "name": {

                switch (level) {
                    case 2: {
                        root.setName(new String(ch, start, length));
                        break;
                    }
                    case 7: {
                        shop.setName(new String(ch, start, length));
                        break;
                    }
                }
                break;
            }
            case "type": {

                currentFurniture.setType(new String(ch, start, length));
                break;
            }
            case "country": {

                currentFurniture.setCountry(new String(ch, start, length));
                break;
            }
            case "manufacturer": {

                currentFurniture.setManufacturer(new String(ch, start, length));
                break;
            }
            case "material": {
                currentFurniture.setMaterial(new String(ch, start, length));
                break;
            }
            case "color": {
                currentFurniture.setColor(new String(ch, start, length));
                break;
            }
            case "address": {
                shop.setAddress(new String(ch, start, length));
                availabilityInfo.setShop(shop);
                shop = new Shop();
                break;
            }
            case "cost": {
                availabilityInfo.setCost(Float.parseFloat(new String(ch, start, length)));
                break;
            }
            case "FurnitureList": {
                furnitureList = new ArrayList<>();
                break;
            }
            case "Furniture": {
                if (currentFurniture == null) {
                    currentFurniture = new Furniture();
                    break;
                }
                availabilityInfoList.add(availabilityInfo);
                availabilityInfo = null;
                currentFurniture.setAvailabilityInfo(availabilityInfoList);
                furnitureList.add(currentFurniture);
                currentFurniture = new Furniture();
                break;
            }
            case "PriceList": {
                availabilityInfoList = new ArrayList<>();
                break;
            }
            case "Shop": {
                if (shop == null) {
                    shop = new Shop();
                }
                break;
            }
            case "AvailabilityInfo": {
                if (availabilityInfo == null) {
                    availabilityInfo = new AvailabilityInfo();
                    break;
                }
                availabilityInfoList.add(availabilityInfo);
                availabilityInfo = new AvailabilityInfo();
                break;
            }
        }
    }
}

