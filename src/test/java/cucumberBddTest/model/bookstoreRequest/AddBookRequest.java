package cucumberBddTest.model.bookstoreRequest;


public class AddBookRequest {
    public String userId;
    public ISBN isbn;


    public AddBookRequest(String userId, ISBN isbn) {
        this.userId = userId;
        this.isbn = isbn;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public ISBN getIsbn() {
        return isbn;
    }

    public void setIsbn(ISBN isbn) {
        this.isbn = isbn;
    }




}