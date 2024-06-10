package menu.impl;

import configs.ApplicationContext;
import menu.Menu;

import java.util.Scanner;

public class ChangePasswordMenu implements Menu {
    private ApplicationContext context;
    {
        context = ApplicationContext.getInstance();
    }

    @Override
    public void start() {
        printMenuHeader();
        System.out.println("Please: enter new password");
        Scanner sc = new Scanner(System.in);
        String newPassword = sc.next();
        context.getLoggedInUser().setPassword(newPassword);
        System.out.println("Your password has been successfully changed");
    }

    @Override
    public void printMenuHeader() {
        System.out.println("*** CHANGE PASSWORD MENU *** ");

    }
}
