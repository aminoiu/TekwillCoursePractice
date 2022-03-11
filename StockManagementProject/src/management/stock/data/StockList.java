package com.tekwill.practice.management.stock.data;

public class StockList {
    private Stock[] stocks;

    public void setStocks(Stock[] stocks) {
        this.stocks = stocks;
    }

    public Stock[] getStocks() {
        return stocks;
    }

    public void insertNewStock(Stock stock) {
        int length = this.stocks.length;

        Stock[] updatedStockList = new Stock[length + 1];

        System.arraycopy(stocks, 0, updatedStockList, 0, length);
        updatedStockList[length] = stock;

        this.stocks = updatedStockList;
    }

    public boolean isAvailableStockForProduct(int productId) {
        boolean availableForProduct = false;
        for (Stock stock : stocks) {
            if (stock.getProductId() == productId) {
                availableForProduct = true;
                break;
            }
        }
        return availableForProduct;
    }

    public Stock getStockByProductId(int productId) {
        Stock foundStock = null;
        for (Stock stock : stocks) {
            if (stock.getProductId() == productId && stock.getQty() != 0) {
                foundStock = stock;
                break;
            }
        }
        return foundStock;
    }

    public void printStocks() {
        for (Stock stock : this.stocks) {
            System.out.println(stock.toString());
        }
    }

    public void printStockForProduct(int productId) {
        Stock stock = getStockByProductId(productId);
        if (stock != null) {
            System.out.println(stock);
        } else {
            System.out.println("No stock found for product id[" + productId + "].");
        }
    }

    public Stock findById(int stockToUpdateId) {
        Stock stock = null;
        for (Stock s : this.stocks)
            if (s.getId() == stockToUpdateId) {
                stock = s;
            }
        return stock;
    }

    public void editStockQty(int id, int newQty) {
        for (Stock stock : stocks) {
            if (stock.getId() == id) {
                stock.setQty(newQty);
            }
        }
    }

    public void editStockLocation(int id, String newLocation) {
        for (Stock stock : stocks) {
            if (stock.getId() == id) {
                stock.setLocation(newLocation);
            }
        }
    }

    public void deleteStock(int id) {
        Stock[] newStocksList = new Stock[stocks.length - 1];
        for (int i = 0, j = 0; i < stocks.length; i++) {
            if (stocks[i].getId() != id) {
                newStocksList[j++] = stocks[i];
            }
        }
        this.stocks = newStocksList;
    }
}