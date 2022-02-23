package com.tekwill.practice.management.stock.processes;

import com.tekwill.practice.management.stock.data.Product;
import com.tekwill.practice.management.stock.data.ProductList;
import com.tekwill.practice.management.stock.data.util.ProductInput;

public class ProductManagement {
    public void addProduct(ProductList productList) {
        int length = productList.getProducts().length;
        Product product = ProductInput.enterNewProduct(length+1);
        productList.insertNewProduct(product);
    }
}
