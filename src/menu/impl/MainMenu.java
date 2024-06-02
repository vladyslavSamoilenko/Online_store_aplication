package menu.impl;

import configs.ApplicationContext;
import menu.Menu;

import java.util.Scanner;

public class MainMenu implements Menu {
    public static final String MENU_COMMAND = "menu";

    private static final String MAIN_MENU_TEXT_FOR_LOGGED_OUT_USER = "Please, enter number in console to proceed." + System.lineSeparator()
            + "1. Sign Up" + System.lineSeparator() + "2. Sign In"
            + System.lineSeparator() + "3.Product Catalog" + System.lineSeparator()
            + "4. My Orders" + System.lineSeparator() + "5. Settings" + System.lineSeparator() +
            "6. Customer List";

    private static final String MAIN_MENU_TEXT_FOR_LOGGED_IN_USER = "Please, enter number in console to proceed." + System.lineSeparator()
            + "1. Sign Up" + System.lineSeparator() + "2. Sign Out"
            + System.lineSeparator() + "3. Product Catalog" + System.lineSeparator()
            + "4. My Orders" + System.lineSeparator() + "5. Settings" + System.lineSeparator() +
            "6. Customer List";;

    private ApplicationContext context;

    {
        context = ApplicationContext.getInstance();
    }

    @Override
    public void start() {
        while(true){
            if(context.getMainMenu() == null){
                context.setMainMenu(this);
            }

            Menu menuToNavigate = null;
            mainLoop : while(true){
                printMenuHeader();

                Scanner sc = new Scanner(System.in);
                System.out.print("User input: ");
                String userInput = sc.next();

                if(userInput.equalsIgnoreCase("exit")){
                    System.exit(0);
                }else {
                    int commandNumber = Integer.parseInt(userInput);
                    if (commandNumber == 1){
                        menuToNavigate = new SingUpMenu();
                        break mainLoop;

                    }else if (commandNumber == 2){

                        if (context.getLoggedInUser() == null){
                            menuToNavigate = new SingInMenu();
                        }else {
                            menuToNavigate = new SingOutMenu();
                        }
                        break mainLoop;
                    } else if (commandNumber == 3) {
                        menuToNavigate = new ProductCatalogMenu();
                        break mainLoop;
                    } else if (commandNumber == 4) {
                        menuToNavigate = new MyOrdersMenu();
                        break mainLoop;
                    } else if (commandNumber == 5) {
                        menuToNavigate = new SettingsMenu();
                        break mainLoop;
                    } else if (commandNumber == 6) {
                        menuToNavigate = new CustomerListMenu();
                        break mainLoop;
                    }else {
                        System.out.println("Only 1, 2, 3, 4, 5 is allowed. Try one more time");
                        continue;
                    }
                }
            }
            menuToNavigate.start();
        }

    }

    @Override
    public void printMenuHeader() {
        System.out.println("*** MENU ***");
        if(context.getLoggedInUser() == null){
            System.out.println(MAIN_MENU_TEXT_FOR_LOGGED_OUT_USER);
        }else {
            System.out.println(MAIN_MENU_TEXT_FOR_LOGGED_IN_USER);
        }

    }
}