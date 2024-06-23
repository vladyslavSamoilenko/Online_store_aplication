package enteties.impl;

import enteties.Cart;
import enteties.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DefaultCart implements Cart {
    private List<Product> products;

    {
        products = new ArrayList<>();
    }

    @Override
    public boolean isEmpty() {
        if (products == null || products.size() == 0){
            return true;
        }
        for (Product product: products){
            if (product != null){
                return false;
            }
        }
        return true;
    }

    @Override
    public void addProduct(Product product) {
        if(product == null){
            return;
        }
        products.add(product);
    }

@Override
    public List <Product> getProducts() {
        List <Product> newList = new ArrayList<>();
        for (Product product : products) {
            if (product != null) {
                newList.add(product);
            }
        }

        return newList;
    }

    @Override
    public void clear() {
        products.clear();
    }

}
