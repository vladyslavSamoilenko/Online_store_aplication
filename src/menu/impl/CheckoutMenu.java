package menu.impl;

import configs.ApplicationContext;
import enteties.Order;
import enteties.impl.DefaultOrder;
import menu.Menu;
import services.OrderManagementService;
import services.impl.DefaultOrderManagementService;

import java.util.Scanner;

public class CheckoutMenu implements Menu {
    private ApplicationContext context;
    private OrderManagementService orderManagementService;

    {
        context = ApplicationContext.getInstance();
        orderManagementService = DefaultOrderManagementService.getInstance();
    }

    @Override
    public void start() {
        printMenuHeader();
        Menu menuToNavigate = null;
        Scanner sc = new Scanner(System.in);
        String cardNumber = sc.next();

        if (!createOrder(cardNumber)) {
            System.out.println("You entered invalid credit card number. Valid credit card should contain 16 digits. Please, try one more time.");
            start();
        }
        context.getSessionCart().clear();
        menuToNavigate = new MainMenu();
    }

    private boolean createOrder(String cardNumber) {
        Order order = new DefaultOrder();
        if (!order.isCreditCardNumberValid(cardNumber)) {
            return false;
        }
        order.setProducts(context.getSessionCart().getProducts());
        order.setCustomerId(context.getLoggedInUser().getId());
        order.setCreditCardNumber(cardNumber);
        orderManagementService.addOrder(order);
        System.out.println("Thanks a lot for your purchase. Details about order delivery are sent to your email.");
        return true;

    }

    @Override
    public void printMenuHeader() {
        System.out.println("*** CHECKOUTMENU ***");
        System.out.println("Enter your credit card number without spaces and press enter if you confirm purchase");

    }
}
