package com.tekwill.practice.management.stock;


import com.tekwill.practice.management.stock.data.*;
import com.tekwill.practice.management.stock.data.util.InitData;
import com.tekwill.practice.management.stock.data.util.ValidationInput;
import com.tekwill.practice.management.stock.processes.OrderPicking;
import com.tekwill.practice.management.stock.processes.ProductManagement;
import com.tekwill.practice.management.stock.processes.StockManagement;

public class StockManagementApp {

    public static void main(String[] args) throws InterruptedException {
        ValidationInput validationInput = new ValidationInput();
        ProductsList productsList = new ProductsList();
        productsList.setProducts(InitData.initProducts());
        StockList stockList = new StockList();
        stockList.setStocks(InitData.initStock());
        ProductManagement productManagement = new ProductManagement();
        StockManagement stockManagement = new StockManagement();
        OrderList orderList = new OrderList();
        OrderPicking orderPicking = new OrderPicking();
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
            System.out.println(" 10. Add an order.");
            System.out.println(" 11. Pick an order.");
            System.out.println(" 12. Pick all orders.");
            System.out.println(" 13. Print all orders.");
            System.out.println(" 0. Exit the MAIN menu!");
            System.out.println("-----------------------------------------------------------------------------------------------");
            k = validationInput.inputInt();

            switch (k) {
                case 1:
                    productsList.printProducts();
                    break;
                case 2:
                    productManagement.addProduct(productsList);
                    break;
                case 3:
                    productManagement.editProduct(productsList);
                    break;
                case 4:
                    stockList.printStocks();
                    break;
                case 5:
                    stockManagement.printStockForProduct(stockList);
                    break;
                case 6:
                    stockManagement.addStock(stockList);
                    break;
                case 7:
                    stockManagement.editStock(stockList);
                    break;
                case 8:
                    stockManagement.deleteStock(stockList, productsList);
                    break;
                case 9:
                    stockManagement.checkAvailableStock(stockList);
                    break;
                case 10:
                    orderPicking.addOrder(orderList, productsList);
                    break;
                case 11:
                    orderPicking.pickAnOder(orderList, stockList);
                    break;
                case 12:
                    orderPicking.pickAllOrders(orderList, stockList);
                    break;
                case 13:
                    orderList.printOrders();
                    break;
                case 0:
                    validationInput.closeScanner();
                    return;
                default:
                    System.out.println("You have not entered a valid option!");
            }

            Thread.sleep(2000);
        }

    }

}
