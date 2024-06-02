package menu.impl;

import configs.ApplicationContext;
import enteties.User;
import enteties.impl.DefaultUser;
import menu.Menu;
import services.UserManagementService;
import services.impl.DefaultUserManagementService;

import java.util.Scanner;

public class SingUpMenu implements Menu {
    private UserManagementService userManagementService;
    private ApplicationContext context;

    {
        userManagementService = DefaultUserManagementService.getInstance();
        context = ApplicationContext.getInstance();
    }
    @Override
    public void start() {
        printMenuHeader();

        Scanner sc = new Scanner(System.in);
        System.out.println("Please, enter your first name");
        String firstName = sc.next();
        System.out.println("Please, enter your last name");
        String lastName = sc.next();
        System.out.println("Please , enter your password");
        String password = sc.next();
        System.out.println("Please, enter your email");
        String userEmail = sc.nextLine();

        User user = new DefaultUser(firstName, lastName, password, userEmail);

        String errorMessage = userManagementService.registerUser(user);
        if (errorMessage == null || errorMessage.isEmpty()){
            context.getLoggedInUser(user);
            System.out.println("New user is created");
        }else {
            System.out.println(errorMessage);
        }

    }

    @Override
    public void printMenuHeader() {
        System.out.println("*** SIGN UP MENU ***");
    }
}
