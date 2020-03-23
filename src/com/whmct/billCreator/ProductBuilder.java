package com.whmct.billCreator;

public class ProductBuilder {
    String name;
    double price;
    int amount;

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product getResult(){
        return new Product(name, price, amount);
    }
}
