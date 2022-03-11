package com.tekwill.practice.management.stock.data;

public class Stock {
    private int id;
    private int productId;
    private int qty;
    private String location;
    private String expirationDate;

    public Stock(int id, int productId, int qty, String location, String expirationDate) {
        this.id = id;
        this.productId = productId;
        this.qty = qty;
        this.location = location;
        this.expirationDate = expirationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", productId=" + productId +
                ", qty=" + qty +
                ", location='" + location + '\'' +
                ", dateOfManufac='" + expirationDate + '\'' +
                '}';
    }
}
