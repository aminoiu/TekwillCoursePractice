package com.tekwill.practice.management.stock.data;

import com.tekwill.practice.management.stock.data.util.InitData;

public class ProductList {
    private Product[] products;

    public void setProducts(Product[] products) {
        this.products = products;
    }

    public Product[] getProducts() {
        return products;
    }

    public void printProducts() {
        for (Product product : this.products) {
            System.out.println(product.toString());
        }
    }

    public void insertNewProduct(Product product) {
        int length = this.products.length;
        Product[] updatedProductList = new Product[length + 1];

        for (int i = 0; i < length; i++) {
            updatedProductList[i] = products[i];
        }
        updatedProductList[length] = product;

        this.products = updatedProductList;

    }
}
