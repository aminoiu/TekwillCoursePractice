package com.tekwill.practice.management.stock.data.util;


import com.tekwill.practice.management.stock.data.Product;
import com.tekwill.practice.management.stock.data.Stock;
import com.tekwill.practice.management.stock.enums.ProductCategory;

public class InitData {

    public static Product[] initProducts() {

        Product product1 = new Product(1, "Milk", ProductCategory.FOOD, "Alba", 9.5);
        Product product2 = new Product(2, "Citramon", ProductCategory.MEDICINE, "MoldovaMedicine", 40.5);
        Product product3 = new Product(3, "Watch", ProductCategory.ACCESSORIES, "Crono", 1450);
        Product product4 = new Product(4, "Bread", ProductCategory.FOOD, "Franzeluta", 10);
        Product product5 = new Product(5, "Valeriana", ProductCategory.MEDICINE, "MoldovaMedicine", 50);
        Product product6 = new Product(6, "Mezim", ProductCategory.MEDICINE, "MoldovaMedicine", 60);
        Product product7 = new Product(7, "Cheese 90%", ProductCategory.FOOD, "Latti", 115.5);
        return new Product[]{product1, product2, product3, product4, product5, product6, product7};
    }

    public static Stock[] initStock() {

        Stock stock1Product1 = new Stock(1, 1, 150, "Level1", "28.02.2022");
        Stock stock2Product1 = new Stock(2, 1, 15, "Level1", "26.02.2022");
        Stock stock1Product2 = new Stock(3, 2, 20, "Level2", "26.02.2023");
        Stock stock1Product3 = new Stock(4, 3, 15, "Level3", "---");
        Stock stock1Product4 = new Stock(5, 4, 20, "Level3", "28.02.2022");
        Stock stock1Product5 = new Stock(6, 5, 25, "Level3", "15.02.2023");
        Stock stock1Product6 = new Stock(7, 6, 1000, "Level3", "15.02.2023");
        Stock stock1Product7 = new Stock(8, 7, 10, "Level3", "15.04.2022");
        Stock stock2Product7 = new Stock(9, 7, 20, "Level3", "15.05.2022");

        return new Stock[]{stock1Product1, stock2Product1, stock1Product2, stock1Product3, stock1Product4, stock1Product5, stock1Product6, stock1Product7, stock2Product7};
    }
}
