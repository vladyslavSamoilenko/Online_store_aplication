package enteties.impl;

import enteties.Order;
import enteties.Product;

import java.util.Arrays;

public class DefaultOrder implements Order {
    private static final int AMOUNT_OF_DIGITS_IN_CREDIT_CARD_NUMBER = 16;

    private String creditCardNumber;
    private Product [] products;
    private int customerId;

    @Override
    public boolean isCreditCardNumberValid(String userInput) {
        return false;
    }

    @Override
    public void setCreditCardNumber(String userInput) {

    }

    @Override
    public void setProducts(Product[] products) {

    }

    @Override
    public void setCustomerId(int customerId) {

    }

    @Override
    public int getCustomerId() {
        return this.customerId;
    }

    @Override
    public String toString() {
        return "enteties.impl.DefaultOrder{" +
                "creditCardNumber='" + creditCardNumber + '\'' +
                ", products=" + Arrays.toString(products) +
                ", customerId=" + customerId +
                '}';
    }
}
