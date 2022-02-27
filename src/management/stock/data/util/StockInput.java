package com.tekwill.practice.management.stock.data.util;

import com.tekwill.practice.management.stock.data.Product;
import com.tekwill.practice.management.stock.data.Stock;

public class StockInput {

    public static Stock enterNewStock(int id, int productId) {
        ValidationInput validationInput = new ValidationInput();
        int newStockQty;
        String newStockLocation;
        String newStockExpirationDate;

        System.out.println("Enter the stock qty:");
        newStockQty = validationInput.inputInt();
        System.out.println("Enter the stock location: ");
        newStockLocation = validationInput.inputString();
        System.out.println("Enter the stock expiration date:");
        newStockExpirationDate = validationInput.inputString();


        return new Stock(id, productId, newStockQty, newStockLocation, newStockExpirationDate);

    }
}
