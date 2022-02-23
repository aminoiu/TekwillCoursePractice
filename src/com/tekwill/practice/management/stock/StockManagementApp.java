package com.tekwill.practice.management.stock;


import com.tekwill.practice.management.stock.data.ProductList;
import com.tekwill.practice.management.stock.data.StockList;
import com.tekwill.practice.management.stock.data.util.InitData;
import com.tekwill.practice.management.stock.data.Product;
import com.tekwill.practice.management.stock.data.Stock;
import com.tekwill.practice.management.stock.data.util.ValidationInput;
import com.tekwill.practice.management.stock.processes.ProductManagement;
import com.tekwill.practice.management.stock.processes.StockManagement;

import java.util.Scanner;

public class StockManagementApp {

    public static void main(String[] args) {
        ValidationInput validationInput = new ValidationInput();
        ProductList productList = new ProductList();
        productList.setProducts(InitData.initProducts());
        StockList stockList = new StockList();
        stockList.setStocks(InitData.initStock());
        ProductManagement productManagement = new ProductManagement();
        StockManagement stockManagement = new StockManagement();
        while (true) {
            int k;
            System.out.println("-----------------------------------------------------------------------------------------------");
            System.out.println("Stock management app. " +
                    "\nPlease enter the corresponding number of the action you want to run!");
            System.out.println(" 1. Visualise available products.");
            System.out.println(" 2. Add new product.");
            System.out.println(" 3. Edit an existing product.");
            System.out.println(" 4. Visualise available stock.");
            System.out.println(" 5. Visualise available stock for a product.");
            System.out.println(" 6. Add stock for a product.");
            System.out.println(" 7. Edit an existing stock.");
            System.out.println(" 8. Delete stock.");
            System.out.println(" 9. Check available stock.");
            System.out.println(" 10. Pick an order.");
            System.out.println(" 0. Exit the MAIN menu!");
            System.out.println("-----------------------------------------------------------------------------------------------");
            k = validationInput.inputInt();

            switch (k) {
                case 1:
                    productList.printProducts();
                    break;
                case 2:
                    productManagement.addProduct(productList);
                    break;
                case 3:
                case 4:
                    stockList.printStocks();
                    break;
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    stockManagement.checkAvailableStock(stockList);
                    break;
                case 10:
                case 0:
                    validationInput.closeScanner();
                    return;
                default:
                    System.out.println("You have not entered a valid option!");
            }
        }

    }

}
