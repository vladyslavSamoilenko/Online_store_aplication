package enteties.impl;

import enteties.Order;
import enteties.Product;

import java.util.Arrays;

public class DefaultOrder implements Order {
    private static final int AMOUNT_OF_DIGITS_IN_CREDIT_CARD_NUMBER = 16;

    private String creditCardNumber;
    private Product [] products;
    private int customerId;

    public DefaultOrder() {
    }

    @Override
    public boolean isCreditCardNumberValid(String userInput) {
        if(userInput != null || userInput.length() == AMOUNT_OF_DIGITS_IN_CREDIT_CARD_NUMBER ){
            if (userInput.matches("\\d+")){
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public void setCreditCardNumber(String userInput) {
        if(isCreditCardNumberValid(userInput)){
            this.creditCardNumber = userInput;
        }else {
            System.out.println("You entered invalid credit card number. Valid credit card should contain 16 digits. Please, try one more time.");
        }

    }

    @Override
    public void setProducts(Product[] products) {
        this.products = products;
    }

    @Override
    public void setCustomerId(int customerId) {
        this.customerId = customerId;

    }

    @Override
    public int getCustomerId() {
        return this.customerId;
    }



    @Override
    public String toString() {
        return "Order{" +
                "creditCardNumber='" + creditCardNumber + '\'' +
                ", products=" + Arrays.toString(products) +
                ", customerId=" + customerId +
                '}';
    }
}
