package com.whmct.billCreator;

import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        List<String> listPrice = DatabaseConnector.connectAndGetInformation("select price from product");
        List<String> listName = DatabaseConnector.connectAndGetInformation("select name from product");
        listPrice.forEach(System.out::println);
        listName.forEach(System.out::println);

    }

}
