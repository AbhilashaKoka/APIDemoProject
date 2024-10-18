package bddCucumber.demo.model.Request;

import lombok.Data;

@Data
public class RemoveBookRequest {
        private String isbn;
        private String userId;


    public RemoveBookRequest(String userId, String isbn) {
        this.isbn=isbn;
        this.userId=userId;
    }
}
