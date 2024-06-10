package menu.impl;

import configs.ApplicationContext;
import menu.Menu;

import java.util.Scanner;

public class ChangeEmailMenu implements Menu {
    private ApplicationContext context;

    {
        context = ApplicationContext.getInstance();
    }

    @Override
    public void start() {
        printMenuHeader();
        System.out.println("Please: enter new email");
        Scanner sc = new Scanner(System.in);
        String newEmail = sc.next();
        context.getLoggedInUser().setEmail(newEmail);
        System.out.println("Your email has been successfully changed");

    }

    @Override
    public void printMenuHeader() {
        System.out.println("*** Change Email Menu ***");
    }
}
