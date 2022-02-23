package com.tekwill.practice.management.stock;


import com.tekwill.practice.management.stock.data.util.InitData;
import com.tekwill.practice.management.stock.data.Product;
import com.tekwill.practice.management.stock.data.Stock;

public class StockManagementApp {

    public static void main(String[] args) {
        Product[] warehouseProducts = InitData.initProducts();
        Stock[] warehouseStock = InitData.initStock();


        for (Product product : warehouseProducts) {
            System.out.println(product.toString());
        }

        for (Stock stock : warehouseStock) {
            System.out.println(stock.toString());
        }


    }
}
