package bddCucumber.demo.model.Request;

import lombok.Data;

@Data
public class ISBN {

    private String isbn;


    public ISBN(String isbn) {
        this.isbn = isbn;
    }
}
