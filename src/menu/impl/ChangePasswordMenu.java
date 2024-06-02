package menu.impl;

import configs.ApplicationContext;
import menu.Menu;

public class ChangePasswordMenu implements Menu {
    private ApplicationContext context;
    {
        context = ApplicationContext.getInstance();
    }

    @Override
    public void start() {

    }

    @Override
    public void printMenuHeader() {
        System.out.println("*** CHANGE PASSWORD MENU *** ");
    }
}
