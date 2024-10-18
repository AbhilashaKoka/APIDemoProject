package bddCucumber.demo.model.Request;

import lombok.Data;
@Data
public class AddBookRequest {
    private String userId;
    private ISBN isbn;


    public AddBookRequest(String userId, ISBN isbn) {
        this.userId = userId;
        this.isbn = isbn;
    }
}