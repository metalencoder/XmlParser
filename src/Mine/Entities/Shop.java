package Mine.Entities;

//Инфа о магазине
public class Shop {
    protected String name;
    protected String address;

    public Shop() {
        name = "";
        address = "";
    }

    public Shop(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Shop{\n" +
                "name='" + name + '\n' +
                "address='" + address + '\n';
    }
}
