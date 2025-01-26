package cucumberBddTest.model.bookstoreResponse;

import java.util.List;

public class UserCreated {

    public  String userID;

    public String username;

    public List<Object> books;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Object> getBooks() {
        return books;
    }

    public void setBooks(List<Object> books) {
        this.books = books;
    }


}
