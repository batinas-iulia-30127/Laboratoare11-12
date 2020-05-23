package aut.utcluj.isp.ex2;

import java.util.Objects;

/**
 * @author stefan
 */
public class Shop {
    private String name;
    private String city;

    public Shop(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public Shop(String name) {
        this.city = "";
        this.name = name;
    }

    @Override
    public String toString() {
        return "Shop: " + this.name + " City: " + this.city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shop shop = (Shop) o;
        return name.equals(shop.name) &&
                city.equals(shop.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, city);
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }
}