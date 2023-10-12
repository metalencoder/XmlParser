package Output;

import Entities.AvailabilityInfo;
import Entities.Furniture;
import Entities.Root;
import Entities.Shop;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ParseToXml {

    private static void writeShop(FileWriter writer, Shop shop) throws IOException {

        writer.write("<Shop>\n");
        writer.write("<name>"+ shop.getName()+"</name>\n");
        writer.write("<address>"+shop.getAddress()+"</address>\n");
        writer.write("</Shop>\n");
    }

    private static void writeAvailabilityInfo(FileWriter writer,AvailabilityInfo availabilityInfo) throws IOException {

        writer.write("<AvailabilityInfo>\n");
        writeShop(writer, availabilityInfo.getShop());
        writer.write("<cost>" + availabilityInfo.getCost() + "</cost>\n");
        writer.write("</AvailabilityInfo>\n");
    }

    private static void writeAvailabilityInfoList(FileWriter writer, List<AvailabilityInfo> availabilityInfoList) throws IOException {
        writer.write("<PriceList>\n");
        for (var availabilityInfo: availabilityInfoList) {
            writeAvailabilityInfo(writer, availabilityInfo);
        }
        writer.write("</PriceList>\n");
    }

    private static void writeFurniture(FileWriter writer, Furniture furniture) throws IOException {

        writer.write("<Furniture>\n");
        writer.write("<type>" + furniture.getType() + "</type>\n");
        writer.write("<country>" + furniture.getCountry() + "</country>\n");
        writer.write("<manufacturer>" + furniture.getManufacturer() + "</manufacturer>\n");
        writer.write("<material>" + furniture.getMaterial() + "</material>\n");
        writer.write("<color>" + furniture.getColor() + "</color>\n");
        writeAvailabilityInfoList(writer, furniture.getAvailabilityInfo());
        writer.write("</Furniture>\n");
    }

    private static void writeFurnitureList(FileWriter writer, List<Furniture> furnitureList) throws IOException {

        writer.write("<FurnitureList>\n");
        for (var furniture : furnitureList) {
            writeFurniture(writer, furniture);
        }
        writer.write("</FurnitureList>\n");

    }

    public static void parseToXmlFile(Root root, String fileName) throws IOException {

        try (FileWriter writer = new FileWriter(fileName, StandardCharsets.UTF_16)) {

            writer.write("<?xml version=\"1.0\" encoding=\"UTF-16\"?>\n<root>\n");
            writer.write("<name>" + root.getName() + "</name>\n");
            writeFurnitureList(writer, root.getFurnitureList());
            writer.write("</root>");
        }
    }
}
