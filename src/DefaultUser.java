public class DefaultUser implements User {
    private int id;

    private String firstName;
    private String lastName;
    private String password;
    private String email;

    public DefaultUser() {

    }

    public DefaultUser(int id,String firstName, String lastName, String password, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
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
        password = newPassword;
    }

    @Override
    public void setEmail(String newEmail) {
        email = newEmail;
    }

    public void clearState(){
        this.id = 0;
        this.firstName = null;
        this.lastName = null;
        this.password = null;
        this.email = null;
    }
}
