package enteties.impl;

import enteties.User;

public class DefaultUser implements User {
    private static int id = 1;

    private static int userCount=0;

    private String firstName;
    private String lastName;
    private String password;
    private String email;

    public DefaultUser() {

    }

    public DefaultUser(String firstName, String lastName, String password, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        id = ++userCount;
    }
    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setPassword(String newPassword) {
        if (newPassword == null){
            return;
        }
        password = newPassword;
    }

    @Override
    public void setEmail(String newEmail) {
        if(newEmail == null){
            return;
        }
        email = newEmail;
    }

    public void clearState(){
        userCount = 0;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
