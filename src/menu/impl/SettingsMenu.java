package menu.impl;

import configs.ApplicationContext;
import menu.Menu;

import java.util.Scanner;

public class SettingsMenu implements Menu {

    private static final String SETTINGS = "1. Change Password" + System.lineSeparator()
            + "2. Change Email";

    private ApplicationContext context;

    {
        context = ApplicationContext.getInstance();
    }

    @Override
    public void start() {
        Menu menuToNavigate = null;
        while (true) {
            printMenuHeader();
            if (context.getLoggedInUser() == null) {
                System.out.println("Please, log in or create new account to change your account settings");
                menuToNavigate = new MainMenu();
                break;

            } else {
                Scanner sc = new Scanner(System.in);
                String userInput = sc.next();

                int commandInput = Integer.parseInt(userInput);
                if (commandInput == 1) {
                    menuToNavigate = new ChangePasswordMenu();
                    break;
                } else if (commandInput == 2) {
                    menuToNavigate = new ChangeEmailMenu();
                    break;
                } else {
                    System.out.println("Only 1, 2 is allowed. Try one more time");
                    continue;
                }

            }

        }
        menuToNavigate.start();
    }

    @Override
    public void printMenuHeader() {
        System.out.println("*** SETTINGS MENU ***");
        System.out.println(SETTINGS);
    }
}
