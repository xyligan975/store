package models;

import java.io.Serial;
import java.io.Serializable;

public class Product implements Serializable {
    @Serial
    private static  final long serialVersionUID = 42L;

    private String name;
    private float price;
    private float rating;

    public Product(String name, float price, float rating) {
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "'" + name + '\'' +
                " - " + price + " бел.руб";
    }
}
