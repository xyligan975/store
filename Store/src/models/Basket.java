package models;

import java.io.Serial;
import java.io.Serializable;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

public class Basket  implements Serializable {
    @Serial
    private static  final long serialVersionUID = 42L;

    private ArrayList<Product> products;

    public Basket() {
        this.products = new ArrayList<>();
    }

    public Basket(ArrayList<Product> products) {
        this.products = products;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public void printBill() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss", Locale.getDefault());
        System.out.println("Дата: " + dateTimeFormatter.format(LocalDateTime.now()));
        NumberFormat currentFormat = NumberFormat.getCurrencyInstance(Locale.getDefault());
        System.out.printf("%-21s %14s\n", "Продукты", "Цена");
        System.out.println("----------------------------------");
        float total = 0.0f;
        for (Product product : products) {
            System.out.printf("%-21s %14s\n", product.getName(), currentFormat.format(product.getPrice()));
            total += product.getPrice();
        }
        System.out.println("----------------------------------");
        System.out.printf("%-21s %14s\n", "Итого:", currentFormat.format(total));
    }

    @Override
    public String toString() {
        return  "products=" + products.toString();
    }
}
