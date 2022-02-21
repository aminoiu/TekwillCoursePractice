package com.tekwill.practice.stock.management.data;

public class Stock {
    private int id;
    private int productId;
    private int qty;
    private String location;
    private String dateOfManufac;

    public Stock(int id, int productId, int qty, String location, String dateOfManufac) {
        this.id = id;
        this.productId = productId;
        this.qty = qty;
        this.location = location;
        this.dateOfManufac = dateOfManufac;
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

    public String getDateOfManufac() {
        return dateOfManufac;
    }

    public void setDateOfManufac(String dateOfManufac) {
        this.dateOfManufac = dateOfManufac;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", productId=" + productId +
                ", qty=" + qty +
                ", location='" + location + '\'' +
                ", dateOfManufac='" + dateOfManufac + '\'' +
                '}';
    }
}
