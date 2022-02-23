package com.tekwill.practice.management.stock.processes;

import com.tekwill.practice.management.stock.data.StockList;
import com.tekwill.practice.management.stock.data.util.ValidationInput;

public class StockManagement {
    public void checkAvailableStock(StockList stockList) {
        ValidationInput validationInput = new ValidationInput();
        int productId;
        boolean isAvailableStock;
        int stockId = 0;

        System.out.println("Give the product id to find stock:");
        productId = validationInput.inputInt();
        validationInput.closeScanner();
        isAvailableStock = stockList.isAvailableStockForProduct(productId);
        if (isAvailableStock) {
            stockId = stockList.getStockByProductId(productId).getId();
        }

        System.out.println(isAvailableStock ?
                ("Stock with id[" + stockId + "] found for product with id[" + productId + "]") :
                ("For product with id[" + productId + "], no stock was found."));
    }
}
