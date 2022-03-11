package com.tekwill.practice.management.stock.processes;

import com.tekwill.practice.management.stock.data.Product;
import com.tekwill.practice.management.stock.data.ProductsList;
import com.tekwill.practice.management.stock.data.util.ProductInput;
import com.tekwill.practice.management.stock.data.util.ValidationInput;

public class ProductManagement {
    ValidationInput validationInput = new ValidationInput();

    public void addProduct(ProductsList productsList) {
        int length = productsList.getProducts().length;
        Product product = ProductInput.enterNewProduct(length + 1);
        productsList.insertNewProduct(product);
    }

    public void editProduct(ProductsList productsList) {
        /*You can edit this information for provided product id:
        -> Name
        -> Price
        * */
        Product productToUpdate = askForValidProduct(productsList);
        boolean valid = true;

        while (valid) {
            System.out.println("Choose what to edit:");
            System.out.println("1 -> Product name");
            System.out.println("2 -> Product price");
            int optionForUpdate = validationInput.inputInt();
            switch (optionForUpdate) {
                case 1: {
                    System.out.println("Introduce the new name:");
                    String newName = validationInput.inputString();
                    productsList.editProductName(productToUpdate.getId(), newName);
                    valid = false;
                    break;
                }
                case 2: {
                    System.out.println("Introduce the new price:");
                    double newPrice = validationInput.inputDouble();
                    productsList.editProductPrice(productToUpdate.getId(), newPrice);
                    valid = false;
                    break;
                }
                default:
                    System.out.println("You have introduced a non-existing option\n");
            }
        }
    }

    private Product askForValidProduct(ProductsList productsList) {
        boolean noProduct = true;
        int productToUpdateId;
        Product productToUpdate = null;

        while (noProduct) {
            System.out.println("Enter the product id you want to update:");
            productToUpdateId = validationInput.inputInt();
            productToUpdate = productsList.findById(productToUpdateId);
            if (productToUpdate != null) {
                noProduct = false;
            }
        }
        return productToUpdate;
    }
}
