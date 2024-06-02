package services.impl;

import enteties.User;
import services.UserManagementService;

public class DefaultUserManagementService implements UserManagementService {
    private static final String NOT_UNIQUE_EMAIL_ERROR_MESSAGE = "This email is already used by another user. Please, use another email";
    private static final String EMPTY_EMAIL_ERROR_MESSAGE = "You have to input email to register. Please, try one more time";
    private static final String NO_ERROR_MESSAGE = "";

    private static final int DEFAULT_USERS_CAPACITY = 10;

    private static DefaultUserManagementService instance;

    private static int userIndex = 0;

    private static User[] users;

    {
        users = new User[DEFAULT_USERS_CAPACITY];
    }


    private DefaultUserManagementService() {
    }

    @Override
    public String registerUser(User user) {
        String userEmail = user.getEmail();
        if(user.getEmail().equals("")){
            return EMPTY_EMAIL_ERROR_MESSAGE;
        }else {
            boolean exist = false;
            for (User user1: users) {
            if (user.getEmail().equals(userEmail)){
                exist = true;
            }

            }
            if(!exist){
                users[userIndex++] = user;
                return NO_ERROR_MESSAGE;
            }
        }
        return NOT_UNIQUE_EMAIL_ERROR_MESSAGE;
    }

    public static UserManagementService getInstance() {
        if (instance == null) {
            instance = new DefaultUserManagementService();
        }
        return instance;
    }


    @Override
    public User[] getUsers() {
        return users;
    }

    @Override
    public User getUserByEmail(String userEmail) {
        for (User user: users) {
            if (user.getEmail().equals(userEmail)){
                return user;
            }
        }
        return null;
    }

    void clearServiceState() {
        userIndex = 0;
        users = new User[DEFAULT_USERS_CAPACITY];

    }

}
