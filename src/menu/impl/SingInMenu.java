package menu.impl;

import configs.ApplicationContext;
import menu.Menu;
import services.UserManagementService;
import services.impl.DefaultUserManagementService;

public class SingInMenu implements Menu {
    private ApplicationContext context;
    private UserManagementService userManagementService;

    {
        context = ApplicationContext.getInstance();
        userManagementService = DefaultUserManagementService.getInstance();
    }
    @Override
    public void start() {


    }

    @Override
    public void printMenuHeader() {
        System.out.println("*** SIGNIN MENU ***");
    }
}
