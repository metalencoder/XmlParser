package Mine.Entities;

import java.util.ArrayList;
import java.util.List;

//Описание мебели
public class Furniture {
    protected String type;
    protected String country;
    protected String manufacturer;
    protected String material;
    protected String color;
    //Информация о наличии в магазинах
    protected ArrayList<AvailabilityInfo> availabilityInfo;

    public ArrayList<AvailabilityInfo> getAvailabilityInfo() {
        return availabilityInfo;
    }

    public void setAvailabilityInfo(ArrayList<AvailabilityInfo> availabilityInfo) {
        this.availabilityInfo = availabilityInfo;
    }
    public Furniture() {
        type = "";
        country = "";
        manufacturer = "";
        material = "";
        color = "";
        availabilityInfo = new ArrayList<AvailabilityInfo>();
    }

    public Furniture(String type, String country, String manufacturer, String material, String color, ArrayList<AvailabilityInfo> availabilityInfos) {

        this.type = type;
        this.country = country;
        this.manufacturer = manufacturer;
        this.material = material;
        this.color = color;
        this.availabilityInfo = availabilityInfos;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        StringBuilder resStr = new StringBuilder(
                "type=" + type + '\n' +
                "country=" + country + '\n' +
                "manufacturer=" + manufacturer + '\n' +
                "material=" + material + '\n' +
                "color=" + color + '\n');
        for (var item: availabilityInfo){
            resStr.append(item).append('\n');
        }
        return resStr.toString();
    }
}
