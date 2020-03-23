package com.whmct.billCreator;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Order order = new Order(
                createProductList(), 20);
        order.getResult();


    }

    private static List<Product> createProductList() {
        List<String> listPrice = DatabaseConnector.connectAndGetInformation("select price from product");
        List<String> listName = DatabaseConnector.connectAndGetInformation("select name from product");
        List<String> listAmount = DatabaseConnector.connectAndGetInformation("select amount from product");

        List<Product> products = new LinkedList<>();

        ProductBuilder productBuilder = new ProductBuilder();
        for (int i = 0; i < listName.size(); i++) {
            productBuilder.setName(listName.get(i));
            productBuilder.setPrice(Double.parseDouble(listPrice.get(i)));
            productBuilder.setAmount(Integer.parseInt(listAmount.get(i)));
            products.add(productBuilder.getResult());
        }
        return products;
    }


}
