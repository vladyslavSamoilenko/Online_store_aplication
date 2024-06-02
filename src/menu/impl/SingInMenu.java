package menu.impl;

import configs.ApplicationContext;
import enteties.User;
import menu.Menu;
import services.UserManagementService;
import services.impl.DefaultUserManagementService;

import java.util.Scanner;

public class SingInMenu implements Menu {
    private ApplicationContext context;
    private UserManagementService userManagementService;

    {
        context = ApplicationContext.getInstance();
        userManagementService = DefaultUserManagementService.getInstance();
    }
    @Override
    public void start() {
        printMenuHeader();
        Scanner sc = new Scanner(System.in);

        System.out.println("Please, enter your email: ");
        String email = sc.next();
        System.out.println("Please, enter your password: ");
        String password = sc.next();

        User user = userManagementService.getUserByEmail(email);
        if(user != null && user.getPassword().equals(password)){
            context.setLoggedInUser(user);
            System.out.println("Glad to see you " + user.getFirstName() + " " + user.getLastName());

        }else {
            System.out.println("Unfortunately, such login and password doesn’t exist");
        }

//        if (email != null && password != null && !email.isEmpty() && !password.isEmpty()){
//            User [] users = DefaultUserManagementService.getInstance().getUsers();
//            User existUser = null;
//
//            for (User user : users){
//                if (user.getEmail().equals(email) && user.getPassword().equals(password)){
//                    existUser = user;
//                    break;
//                }
//            }
//            if(existUser != null){
//                context.setLoggedInUser(existUser);
//                System.out.println("Glad to see you " + existUser.getFirstName() + " " + existUser.getLastName());
//            }else {
//                System.out.println("Unfortunately, such login and password doesn’t exist");
//            }
//
//        }else {
//            System.out.println("Unfortunately, such login and password doesn’t exist");
//        }

    }

    @Override
    public void printMenuHeader() {
        System.out.println("*** SIGNIN MENU ***");
    }
}
