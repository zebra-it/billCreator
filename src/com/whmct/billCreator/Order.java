package com.whmct.billCreator;

import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/*
 * Order
 * Заказ #100500
 *  товар   кол-во  цена($)
 *  ручка   2       1
 */
public class Order {
    private List<Product> products;
    private int amountProduct;
    private double currentRate = Rate.Rate;
    private double vat;
    private String number;
    private static int num = 0;

    public Order(List<Product> products, double vat) {
        this.number = num + getRandomString(5);
        this.products = products;
        this.amountProduct = amountProduct;
        this.vat = vat;
        num++;
    }

    public List<Double> getRublesPriceWithoutVat(List<Product> products) {
        List<Double> price = new LinkedList<>();
        for (Product product : products) {
            price.add(product.price * currentRate);
        }
        return price;
    }

    public List<Double> getRublesPriceWithVat(List<Product> products) {
        List<Double> price = new LinkedList<>();
        List<Double> rublesPriceWithoutVat = getRublesPriceWithoutVat(products);
        for (Double aDouble : rublesPriceWithoutVat) {
            price.add(aDouble + (aDouble * vat / 100));
        }
        return price;
    }

    public void getResult() {
        String str = String.format(
                "Ваш заказ #%s\n",
                number
                );
        System.out.println(str);
        products.forEach(product -> {
            System.out.println(
                    product.name + "\t" + product.amount + "шт\t" + product.price );
        });
    }

    static String getRandomString(int n) {

        // length is bounded by 256 Character
        byte[] array = new byte[256];
        new Random().nextBytes(array);

        String randomString
                = new String(array, Charset.forName("UTF-8"));

        // Create a StringBuffer to store the result
        StringBuffer r = new StringBuffer();

        // Append first 20 alphanumeric characters
        // from the generated random String into the result
        for (int k = 0; k < randomString.length(); k++) {

            char ch = randomString.charAt(k);

            if (((ch >= 'a' && ch <= 'z')
                    || (ch >= 'A' && ch <= 'Z')
                    || (ch >= '0' && ch <= '9'))
                    && (n > 0)) {

                r.append(ch);
                n--;
            }
        }

        // return the resultant string
        return r.toString();
    }
}
