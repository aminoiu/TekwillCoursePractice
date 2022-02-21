package com.tekwill.practice.stock.management.data;

import com.tekwill.practice.stock.management.data.enums.Category;

public class Product {
    private int id;
    private String name;
    private Category category;
    private String madeOf;
    private double price;

    public Product(int id, String name, Category category, String madeOf, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.madeOf = madeOf;
        this.price = price;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getMadeOf() {
        return madeOf;
    }

    public void setMadeOf(String madeOf) {
        this.madeOf = madeOf;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", madeOf='" + madeOf + '\'' +
                ", price=" + price +
                '}';
    }
}
