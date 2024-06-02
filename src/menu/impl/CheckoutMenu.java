package menu.impl;

import configs.ApplicationContext;
import menu.Menu;
import services.OrderManagementService;
import services.impl.DefaultOrderManagementService;

public class CheckoutMenu implements Menu {
    private ApplicationContext context;
    private OrderManagementService orderManagementService;

    {
        context = ApplicationContext.getInstance();
        orderManagementService = DefaultOrderManagementService.getInstance();
    }
    @Override
    public void start() {

    }

    @Override
    public void printMenuHeader() {
        System.out.println("*** CHECKOUTMENU ***");

    }
}
