package enteties.impl;

import enteties.Product;

import java.util.Comparator;

public class CustomProductComparator implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {

        if (o1.getCategoryName().compareTo(o2.getCategoryName()) == 0){
            if (o1.getPrice() - o2.getPrice() == 0){
                return o1.getProductName().compareTo(o2.getProductName());
            }
            return (int)(o1.getPrice() - o2.getPrice());
        }
        return o1.getCategoryName().compareTo(o2.getCategoryName());
    }
}
