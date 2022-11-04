package logic;

import java.io.Serializable;
import java.util.List;

public class Product implements Serializable {

    private String productName;
    private double productPrice;
    private List<Ingredient> productIngredients;
    private double grams;

    public Product(String productName, double productPrice, List<Ingredient> productIngredients, double grams) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productIngredients = productIngredients;
        this.grams = grams;
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public List<Ingredient> getProductIngredients() {
        return productIngredients;
    }

    public double getGrams() {
        return grams;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productIngredients=" + productIngredients +
                ", grams=" + grams +
                '}';
    }
}
