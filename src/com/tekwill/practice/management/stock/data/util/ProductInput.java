package com.tekwill.practice.management.stock.data.util;

import com.tekwill.practice.management.stock.data.Product;
import com.tekwill.practice.management.stock.enums.ProductCategory;

public class ProductInput {

    public static Product enterNewProduct(int id) {
        Product product = null;
        String newProductName;
        ProductCategory newProductCategory;
        String newProductMadeOf;
        double newProductPrice;
        ValidationInput validationInput = new ValidationInput();

        System.out.println("Enter the product name:");
        newProductName = validationInput.inputString();

        System.out.println("Enter the product category:");
        newProductCategory = getInputCategory(validationInput);

        System.out.println("Enter the product manufacturer:");
        newProductMadeOf = validationInput.inputString();

        System.out.println("Enter the product price:");
        newProductPrice = validationInput.inputDouble();
        validationInput.closeScanner();
        product = new Product(id, newProductName, newProductCategory, newProductMadeOf, newProductPrice);
        return product;
    }

    private static ProductCategory getInputCategory(ValidationInput validationInput) {
        ProductCategory productCategory = null;
        boolean isValid = true;
        while (isValid) {
            System.out.println("Choose one of the categories id:");
            System.out.println("1." + ProductCategory.FOOD + "\n2." + ProductCategory.ACCESSORIES + "\n3." + ProductCategory.MEDICINE);
            int newProductCategoryId = validationInput.inputInt();
            switch (newProductCategoryId) {
                case 1:
                    productCategory = ProductCategory.FOOD;
                    isValid = false;
                    break;
                case 2:
                    productCategory = ProductCategory.ACCESSORIES;
                    isValid = false;
                    break;
                case 3:
                    productCategory = ProductCategory.MEDICINE;
                    isValid = false;
                    break;
                default:
                    System.out.println("You have introduced a non-existing category\n");
            }
        }
        return productCategory;
    }
}
