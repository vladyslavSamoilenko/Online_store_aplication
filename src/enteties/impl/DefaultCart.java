package enteties.impl;

import enteties.Cart;
import enteties.Product;

import java.util.Arrays;

public class DefaultCart implements Cart {
    private Product [] productsInCart;
    private static final int DEFAULT_CART_CAPACITY = 5;
    private static int productLastIndex = 0;

    private int productsCount = 0;

    {
        productsInCart = new Product[DEFAULT_CART_CAPACITY];
    }

    @Override
    public boolean isEmpty() {
        if(productsCount == 0){
            return true;
        }
        return false;
    }

    @Override
    public void addProduct(Product product) {
        if(product == null){
            return;
        }
            if(productsInCart.length <= productLastIndex){
                productsInCart = Arrays.copyOf(productsInCart, productsInCart.length * 2);
            }
            productsInCart[productLastIndex++] = product;
    }

    @Override
    public Product[] getProductsInCart() {
        int nonNullProductsAmount = 0;
        for (Product product : productsInCart) {
            if (product != null) {
                nonNullProductsAmount++;
            }
        }

        Product[] nonNullProducts = new Product[nonNullProductsAmount];
        int index = 0;
        for (Product product : productsInCart) {
            if (product != null) {
                nonNullProducts[index++] = product;
            }
        }

        return nonNullProducts;
//        return productsInCart;
    }

    @Override
    public void clear() {
        productsCount = 0;
        productLastIndex = 0;
        productsInCart = new Product[DEFAULT_CART_CAPACITY];
    }

}
