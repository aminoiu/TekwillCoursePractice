package com.tekwill.practice.stock.management;

import com.tekwill.practice.stock.management.data.Product;
import com.tekwill.practice.stock.management.data.Stock;
import com.tekwill.practice.stock.management.data.enums.Category;

public class StockManagementApp {

    public static void main(String[] args) {

        Product[] availableProducts;
        Stock[] productsStock;

        Product product1 = new Product(1, "Milk", Category.FOOD, "Alba", 9.5);
        Product product2 = new Product(2, "Citramon", Category.MEDICINE, "MoldovaMedicine", 40.5);
        Product product3 = new Product(3, "Watch", Category.ACCESSORIES, "Crono", 1450);

        availableProducts = new Product[]{product1, product2, product3};

        Stock stock1Product1 = new Stock(1, 1, 150, "Level1", "15.02.2022");
        Stock stock2Product1 = new Stock(2, 1, 15, "Level1", "18.02.2022");
        Stock stock1Product2 = new Stock(3, 2, 20, "Level2", "15.02.2022");
        Stock stock1Product3 = new Stock(4, 3, 5, "Level3", "15.02.2022");

        productsStock = new Stock[]{stock1Product1, stock2Product1, stock1Product2, stock1Product3};

        for (Product product : availableProducts) {
            System.out.println(product.toString());
        }

        for (Stock stock : productsStock) {
            System.out.println(stock.toString());
        }


    }
}
