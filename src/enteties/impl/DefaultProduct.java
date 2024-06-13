package enteties.impl;

import enteties.Product;

public class DefaultProduct implements Product {
    private int id;
    private String productName;
    private String categoryName;
    private double price;

    public DefaultProduct(int id, String productName, String categoryName, double price) {
        this.id = id;
        this.productName = productName;
        this.categoryName = categoryName;
        this.price = price;
    }

    public DefaultProduct() {
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return getId() + " : " + getProductName() + " | price : " + getPrice();
    }
}
