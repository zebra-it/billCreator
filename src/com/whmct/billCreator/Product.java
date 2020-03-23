package com.whmct.billCreator;

public class Product {
    String name;
    double price;
    int amount;

    public Product(String name, double price, int amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return
                "name ='" + name + '\'' +
                        ", price =" + price +
                        ", amount =" + amount;
    }
}
