package menu.impl;

import configs.ApplicationContext;
import menu.Menu;
import services.OrderManagementService;
import services.impl.DefaultOrderManagementService;

public class MyOrdersMenu implements Menu {
    private ApplicationContext context;
    private OrderManagementService orderManagementService;

    {
        context = ApplicationContext.getInstance();
        orderManagementService = DefaultOrderManagementService.getInstance();
    }

    @Override
    public void start() {
        // <write your code here>
    }

    @Override
    public void printMenuHeader() {
        System.out.println("*** MY ORDERS MENU ***");
    }
}
