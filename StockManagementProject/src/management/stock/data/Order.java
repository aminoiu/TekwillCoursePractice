package com.tekwill.practice.management.stock.data;

import sun.security.util.ArrayUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Order {
    private int id;
    private String name;
    private String customer;
    private Product[] productsList;
    private int[] qtyList;


    private Map<Product, Integer> productQtyMap = new HashMap<>();

    public Order(int id, String name, String customer, Product[] productsList, int[] qtyList) {
        this.id = id;
        this.name = name;
        this.customer = customer;
        this.productsList = productsList;
        this.qtyList = qtyList;
    }

    public Order(int id, String name, String customer, Map<Product, Integer> productQtyMap) {
        this.id = id;
        this.name = name;
        this.customer = customer;
        this.productQtyMap = productQtyMap;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Product[] getProductsList() {
        return productsList;
    }

    public void setProductsList(Product[] productsList) {
        this.productsList = productsList;
    }

    public int[] getQtyList() {
        return qtyList;
    }

    public void setQtyList(int[] qtyList) {
        this.qtyList = qtyList;
    }

    public Map<Product, Integer> getProductQtyMap() {
        return productQtyMap;
    }

    public void setProductQtyMap(Map<Product, Integer> productQtyMap) {
        this.productQtyMap = productQtyMap;
    }

    public void updateQtyAfterShortage(int stockAvailableQty, Product product) {
        int productIndex = getProductsIndex(product.getId());
        this.qtyList[productIndex] = this.qtyList[productIndex] - stockAvailableQty;

        this.productQtyMap.put(product, stockAvailableQty);
    }

    private int getProductsIndex(int id) {
        int i;
        for (i = 0; i < productsList.length; i++) {
            if (productsList[i].getId() == id) {
                break;
            }
        }
        return i;
    }

    public Product[] deleteProduct(Product product) {
        deleteFromQtyList(getProductsIndex(product.getId()));

        Product[] newProductList = new Product[this.productsList.length - 1];
        for (int i = 0, j = 0; i < this.productsList.length; i++) {
            if (this.productsList[i] != product) {
                newProductList[j++] = this.productsList[i];
            }
        }
        return newProductList;
    }

    private void deleteFromQtyList(int productsIndex) {
        int[] newQtys = new int[this.qtyList.length - 1];
        for (int i = 0, j = 0; i < this.qtyList.length; i++) {
            if (i != productsIndex) {
                newQtys[j++] = this.qtyList[i];
            }
        }
        this.qtyList = newQtys;
    }

    public void updateProductsList(Product product) {
        this.productQtyMap.remove(product);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", customer='" + customer + '\'' +
                ", \nproductsList=" + productQtyMap.toString() +
                '}';
    }
}
