package com.tekwill.practice.management.stock.data;

public class ProductsList {
    private Product[] products;

    public void setProducts(Product[] products) {
        this.products = products;
    }

    public Product[] getProducts() {
        return products;
    }

    public void insertNewProduct(Product product) {
        int length = this.products.length;

        Product[] updatedProductList = new Product[length + 1];

        System.arraycopy(this.products, 0, updatedProductList, 0, length);
        updatedProductList[length] = product;

        this.products = updatedProductList;

    }

    public void printProducts() {
        for (Product product : this.products) {
            System.out.println(product.toString());
        }
    }

    public Product findById(int productId) {
        Product product = null;
        for (Product p : this.products)
            if (p.getId() == productId) {
                product = p;
            }
        return product;
    }

    public void editProductName(int productId, String newName) {
        for (Product product : products) {
            if (product.getId() == productId) {
                product.setName(newName);
            }
        }
    }

    public void editProductPrice(int productId, double newPrice) {
        for (Product product : products) {
            if (product.getId() == productId) {
                product.setPrice(newPrice);
            }
        }
    }

    public void deleteProduct(int productId) {
        Product[] newProductsList = new Product[products.length - 1];
        for (int i = 0, j = 0; i < products.length; i++) {
            if (products[i].getId() != productId) {
                newProductsList[j++] = products[i];
            }
        }
        this.products = newProductsList;
    }
}
