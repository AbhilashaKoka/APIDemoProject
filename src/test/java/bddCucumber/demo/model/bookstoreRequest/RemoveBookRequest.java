package bddCucumber.demo.model.bookstoreRequest;


public class RemoveBookRequest {
    public String isbn;
    public String userId;


    public RemoveBookRequest(String userId, String isbn) {
        this.isbn=isbn;
        this.userId=userId;
    }




}
