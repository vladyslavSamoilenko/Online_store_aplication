package menu.impl;

import configs.ApplicationContext;
import enteties.User;
import menu.Menu;
import services.UserManagementService;
import services.impl.DefaultUserManagementService;

public class CustomerListMenu implements Menu {
    private ApplicationContext context;
    private UserManagementService userManagementService;

    {
        userManagementService = DefaultUserManagementService.getInstance();
        context = ApplicationContext.getInstance();
    }
    @Override
    public void start() {
        printMenuHeader();
        for (User user : userManagementService.getUsers()){
            System.out.println(user.getId() + ") " + user.getFirstName() + " " + user.getLastName());
        }
        Menu mainMenu = new MainMenu();
    }

    @Override
    public void printMenuHeader() {
        System.out.println("*** LIST MENU ***");
    }
}
