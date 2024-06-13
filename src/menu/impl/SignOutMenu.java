package menu.impl;

import configs.ApplicationContext;
import menu.Menu;

public class SignOutMenu implements Menu {
    private ApplicationContext context;

    {
        context = ApplicationContext.getInstance();
    }

    public SignOutMenu() {
    }

    @Override
    public void start() {
        printMenuHeader();
        context.setLoggedInUser(null);
        System.out.println("Have a nice day! Look forward to welcoming back");
    }

    @Override
    public void printMenuHeader() {
        System.out.println("*** SIGNOUT MENU ***");
    }
}
