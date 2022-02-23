package com.tekwill.practice.management.stock.data;

import java.util.Arrays;

public class Order {
    private int id;
    private String name;
    private String customer;
    private Product[] productsList;
    private int[] qtyList;

    public Order(int id, String name, String customer, Product[] productsList, int[] qtyList) {
        this.id = id;
        this.name = name;
        this.customer = customer;
        this.productsList = productsList;
        this.qtyList = qtyList;
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

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", customer='" + customer + '\'' +
                ", productsList=" + Arrays.toString(productsList) +
                ", qtyList=" + Arrays.toString(qtyList) +
                '}';
    }
}
