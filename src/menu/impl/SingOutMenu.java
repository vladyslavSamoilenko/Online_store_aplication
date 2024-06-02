package menu.impl;

import configs.ApplicationContext;
import menu.Menu;

public class SingOutMenu implements Menu {
    private ApplicationContext context;

    {
        context = ApplicationContext.getInstance();
    }

    @Override
    public void start() {
        // <write your code here>
    }

    @Override
    public void printMenuHeader() {
        System.out.println("*** SIGNOUT MENU ***");
    }
}
