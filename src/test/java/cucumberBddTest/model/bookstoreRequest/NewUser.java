package cucumberBddTest.model.bookstoreRequest;


public class NewUser {
    public String userName;
    public String password;


    public NewUser(String userName, String password) {
        this.userName=userName;
        this.password=password;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}