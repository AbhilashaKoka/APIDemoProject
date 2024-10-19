package bddCucumber.demo.model.Request;


public class AddBookRequest {
    public String userId;
    public ISBN isbn;


    public AddBookRequest(String userId, ISBN isbn) {
        this.userId = userId;
        this.isbn = isbn;
    }


}