package cucumberBddTest.model.bookstoreRequest;


public class RemoveBookRequest {
    public ISBN isbn;
    public String userId;

    public RemoveBookRequest(String userId) {
        this.userId = userId;
    }

    public RemoveBookRequest(String userId, ISBN isbn) {
        this.isbn=isbn;
        this.userId=userId;
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
