package menu.impl;

import configs.ApplicationContext;
import menu.Menu;
import services.OrderManagementService;
import services.impl.DefaultOrderManagementService;

import java.util.Arrays;

public class MyOrdersMenu implements Menu {
    private ApplicationContext context;
    private OrderManagementService orderManagementService;

    {
        context = ApplicationContext.getInstance();
        orderManagementService = DefaultOrderManagementService.getInstance();
    }

    @Override
    public void start() {
        Menu navigateMenu;
        if (context.getLoggedInUser() == null){
            System.out.println("Please, log in or create new account to see list of your orders");
            navigateMenu = new MainMenu();
        }else if(orderManagementService.getOrdersByUserId(context.getLoggedInUser().getId()).size() == 0){
            System.out.println("Unfortunately, you don’t have any orders yet. Navigate back to main menu to place a new order");
            navigateMenu = new MainMenu();
        } else {
            System.out.println(orderManagementService.getOrdersByUserId(context.getLoggedInUser().getId()));
            navigateMenu = new MainMenu();
        }
    }

    @Override
    public void printMenuHeader() {
        System.out.println("*** MY ORDERS MENU ***");
    }
}
