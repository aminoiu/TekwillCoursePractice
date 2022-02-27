package com.tekwill.practice.management.stock.data.util;

import com.tekwill.practice.management.stock.data.Product;
import com.tekwill.practice.management.stock.enums.ProductCategory;

public class ProductInput {

    public static Product enterNewProduct(int id) {
        ValidationInput validationInput = new ValidationInput();
        String newProductName;
        ProductCategory newProductCategory;
        String newProductMadeOf;
        double newProductPrice;

        System.out.println("Enter the product name: ");
        newProductName = validationInput.inputString();
        System.out.println("Enter the product category: ");
        newProductCategory = getInputCategory(validationInput);
        System.out.println("Enter the product manufacturer:");
        newProductMadeOf = validationInput.inputString();
        System.out.println("Enter the product price:");
        newProductPrice = validationInput.inputDouble();
        validationInput.closeScanner();
        return new Product(id, newProductName, newProductCategory, newProductMadeOf, newProductPrice);

    }

    private static ProductCategory getInputCategory(ValidationInput validationInput) {
        ProductCategory newProductCategory = null;
        boolean valid = true;
        while (valid) {
            System.out.println("Choose one of the categories id:");
            System.out.println("1. " + ProductCategory.FOOD + "\n" + "2. " + ProductCategory.MEDICINE + "\n" + "3. " + ProductCategory.ACCESSORIES);

            int newProductCategoryId = validationInput.inputInt();
            switch (newProductCategoryId) {
                case 1:
                    newProductCategory = ProductCategory.FOOD;
                    valid = false;
                    break;
                case 2:
                    newProductCategory = ProductCategory.MEDICINE;
                    valid = false;
                    break;
                case 3:
                    newProductCategory = ProductCategory.ACCESSORIES;
                    valid = false;
                    break;
                default:
                    System.out.println("You have introduced a non-existing category\n");

            }
        }
        return newProductCategory;
    }

}
