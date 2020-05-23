package aut.utcluj.isp.ex2;

/**
 * @author stefan
 */
public class OnlineShop extends Shop {
    private String webAddress;
    private Shop shop;

    public OnlineShop(String name, String city, String webAddress) {
        super(name, city);
        this.webAddress = webAddress;
        this.shop = new Shop(name,city);
    }

    public String getWebAddress() {
        return webAddress;
    }

    @Override
    public String toString() {
        return "Shop: " + shop.getName() + " City: " + shop.getCity() + " Web address: " + webAddress;
    }
}
