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

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public String getProductName() {
        return null;
    }

    @Override
    public String toString() {
        return "enteties.impl.DefaultProduct{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", price=" + price +
                '}';
    }
}
