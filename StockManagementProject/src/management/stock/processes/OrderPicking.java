package com.tekwill.practice.management.stock.processes;

import com.tekwill.practice.management.stock.data.*;
import com.tekwill.practice.management.stock.data.util.ValidationInput;

public class OrderPicking {
    ValidationInput validationInput = new ValidationInput();

    public void addOrder(OrderList orderList, ProductsList productsList) {
        Order order;
        String name;
        String customer;
        Product[] productList;
        int[] qtyList;
        int productsNr;

        System.out.println("Enter command name:");
        name = validationInput.inputString();

        System.out.println("Enter customer name:");
        customer = validationInput.inputString();

        System.out.println("Enter how many products you have in order:");
        productsNr = validationInput.inputInt();

        productList = inputProductsFromOrder(productsNr, productsList);
        qtyList = inputQtys(productList);

        order = new Order(orderList.getOrders() != null ? orderList.getOrders().length + 1 : 1, name, customer, productList, qtyList);
        if (orderList.getOrders() != null && orderList.getOrders().length > 0) {
            orderList.insertAnOrder(order);
        } else orderList.setOrders(new Order[]{order});
        System.out.println("New order was added!\n");
    }

    private int[] inputQtys(Product[] products) {
        int[] qtys = new int[products.length];
        for (int i = 0; i < products.length; i++) {
            System.out.println("Give the quantity for product with id[" + products[i].getId() + "]:");
            qtys[i] = validationInput.inputInt();
        }
        return qtys;
    }

    private Product[] inputProductsFromOrder(int productsNr, ProductsList productsList) {
        Product[] products = new Product[productsNr];
        for (int i = 0; i < productsNr; i++) {
            int productId;
            boolean existsProduct = true;
            Product product = null;
            while (existsProduct) {
                System.out.println("Product id:");
                productId = validationInput.inputInt();
                product = productsList.findById(productId);
                if (product == null) {
                    System.out.println("A product with introduced id wasn't found! Give another id:");
                } else {
                    existsProduct = false;
                }
            }
            products[i] = product;
        }
        return products;
    }

    public void pickAnOder(OrderList orderList, StockList stockList) {
        int orderId;
        Order order;

        System.out.println("Give the id of order to be picked:");
        orderId = validationInput.inputInt();
        order = orderList.getOrderById(orderId);
        pickOrder(order, orderList, stockList);
    }

    private void pickOrder(Order orderToPick, OrderList orderList, StockList stockList) {
        Stock stock;

        if (orderToPick != null) {
            int i = 0;
            Product[] orderProductsList = orderToPick.getProductsList();
            int[] orderProductsQtys = orderToPick.getQtyList();
            for (Product product : orderProductsList) {
                int necessaryQty = orderProductsQtys[i];
                stock = stockList.getStockByProductId(product.getId());
                if (stock != null) {
                    if (stock.getQty() < necessaryQty) {
                        System.out.println("For order[" + orderToPick.getId() + "], and stock[" + stock.getId() + "], not all qty is available. Only " + stock.getQty() + " was picked.");
                        orderToPick.updateQtyAfterShortage(stock.getQty(), product);
                        stock.setQty(0);
                    } else {
                        System.out.println("Order[" + orderToPick.getId() + "], and stock[" + stock.getId() + "], picked.");
                        stock.setQty(stock.getQty() - necessaryQty);
                        orderList.deletePickedProductFromOrder(orderToPick, product);
                    }
                } else {
                    System.out.println("No stock found for order with id[" + orderToPick.getId() + "]. You can pick it later when stock will be present.");
                }
                i++;
            }
            if (orderToPick.getProductsList().length < 1) {
                orderList.deleteOrder(orderToPick.getId());
            }
        }
    }

    public void pickAllOrders(OrderList orderList, StockList stockList) {
        for (Order order : orderList.getOrders()) {
            pickOrder(order, orderList, stockList);
        }
    }
}
