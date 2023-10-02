package Mine.Entities;

//Информация о наличии товара в магазине
public class AvailabilityInfo {
    protected Shop shop;
    protected Float cost;

    public AvailabilityInfo() {
        shop = new Shop();
        cost = 0F;
    }

    public AvailabilityInfo(Shop shop, Float cost) {
        this.shop = shop;
        this.cost = cost;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "AvailabilityInfo{" +
                "shop=\n" + shop + '\n' +
                "cost=" + cost + '\n';
    }
}
