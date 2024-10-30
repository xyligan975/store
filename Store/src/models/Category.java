package models;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

public class Category implements Serializable {
    @Serial
    private static  final long serialVersionUID = 42L;

    private String name;
    private ArrayList<Product> products;

    public Category(String name, ArrayList<Product> products) {
        this.name = name;
        this.products = products;
        products.sort(Comparator.comparing(Product::getPrice));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", products=" + products.toString();
    }
}
