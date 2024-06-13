package enteties.impl;

import enteties.Cart;
import enteties.Product;

import java.util.Arrays;

public class DefaultCart implements Cart {
    private Product [] products;
    private static final int DEFAULT_CART_CAPACITY = 10;
    private int productLastIndex = 0;

    {
        products = new Product[DEFAULT_CART_CAPACITY];
    }

    @Override
    public boolean isEmpty() {
        if (products == null || products.length == 0){
            return true;
        }
        for (Product product: products){
            if (product != null){
                return false;
            }
        }
        return true;
//        if(productsCount == 0){
//            return true;
//        }
//        return false;
    }

    @Override
    public void addProduct(Product product) {
        if(product == null){
            return;
        }
            if(products.length <= productLastIndex){
                products = Arrays.copyOf(products, products.length << 1 );
            }
            products[productLastIndex++] = product;
    }

@Override
    public Product[] getProducts() {
        int nonNullProductsAmount = 0;
        for (Product product : products) {
            if (product != null) {
                nonNullProductsAmount++;
            }
        }

        Product[] nonNullProducts = new Product[nonNullProductsAmount];
        int index = 0;
        for (Product product : products) {
            if (product != null) {
                nonNullProducts[index++] = product;
            }
        }

        return nonNullProducts;
    }

    @Override
    public void clear() {
        products = new Product[DEFAULT_CART_CAPACITY];
    }

}
