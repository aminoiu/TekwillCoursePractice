package com.tekwill.practice.management.stock.processes;

import com.tekwill.practice.management.stock.data.ProductsList;
import com.tekwill.practice.management.stock.data.Stock;
import com.tekwill.practice.management.stock.data.StockList;
import com.tekwill.practice.management.stock.data.util.StockInput;
import com.tekwill.practice.management.stock.data.util.ValidationInput;

public class StockManagement {
    ValidationInput validationInput = new ValidationInput();

    public void addStock(StockList stockList) {
        int productId;

        int length = stockList.getStocks().length;

        System.out.println("Give the product id for the new stock:");
        productId = validationInput.inputInt();
        Stock stock = StockInput.enterNewStock(length + 1, productId);
        stockList.insertNewStock(stock);
    }

    public void checkAvailableStock(StockList stockList) {
        int productId;
        int stockId = 0;
        boolean isAvailableStock;

        System.out.println("Give the product id to find stock:");
        productId = validationInput.inputInt();

        isAvailableStock = stockList.isAvailableStockForProduct(productId);
        if (isAvailableStock) {
            stockId = stockList.getStockByProductId(productId).getId();
        }

        System.out.println(isAvailableStock ?
                ("Stock with id[" + stockId + "] found for product with id[" + productId + "]") :
                ("For product with id[" + productId + "], no stock was found."));
    }

    public void printStockForProduct(StockList stockList) {
        System.out.println("Give the product id to find stock:");
        int productId = validationInput.inputInt();
        stockList.printStockForProduct(productId);
    }

    public void editStock(StockList stockList) {
         /*You can edit this information for provided product id:
        -> Qty
        -> Location
        * */
        Stock stockToUpdate = askForAValidStock(stockList);
        boolean valid = true;

        while (valid) {
            System.out.println("Choose what to edit:");
            System.out.println("1 -> Stock quantity");
            System.out.println("2 -> Stock location");
            int newProductCategoryId = validationInput.inputInt();
            switch (newProductCategoryId) {
                case 1: {
                    System.out.println("Introduce the new quantity:");
                    int newQty = validationInput.inputInt();
                    stockList.editStockQty(stockToUpdate.getId(), newQty);
                    valid = false;
                    break;
                }
                case 2: {
                    System.out.println("Introduce the new location:");
                    String newLocation = validationInput.inputString();
                    stockList.editStockLocation(stockToUpdate.getId(), newLocation);
                    valid = false;
                    break;
                }
                default:
                    System.out.println("You have introduced a non-existing option\n");
            }
        }
    }

    private Stock askForAValidStock(StockList stockList) {
        boolean noStock = true;
        int stockToUpdateId;
        Stock stockToUpdate = null;

        while (noStock) {
            System.out.println("Enter the stock id:");
            stockToUpdateId = validationInput.inputInt();
            stockToUpdate = stockList.findById(stockToUpdateId);
            if (stockToUpdate != null) {
                noStock = false;
            }
        }
        return stockToUpdate;
    }

    public void deleteStock(StockList stockList, ProductsList productsList) {
        Stock stockToDelete = askForAValidStock(stockList);
        boolean deleteProduct = askToDeleteProduct(stockToDelete.getProductId());
        stockList.deleteStock(stockToDelete.getId());
        if (deleteProduct) {
            productsList.deleteProduct(stockToDelete.getProductId());
        }
    }

    private boolean askToDeleteProduct(int productId) {
        boolean responseToDelete = false;
        boolean notValidResponse = true;
        while (notValidResponse) {
            System.out.println("Do you want to delete the product with id[" + productId + "] too? Answer with Y (for Yes) or N (for No):");
            String response = validationInput.inputString();
            if (response.equalsIgnoreCase("Y")) {
                responseToDelete = true;
                notValidResponse = false;
            } else if (response.equalsIgnoreCase("N")) {
                notValidResponse = false;
            } else {
                System.out.println("You have entered a non valid response. Expected Y or N. Entered:" + response);
            }
        }
        return responseToDelete;
    }
}
