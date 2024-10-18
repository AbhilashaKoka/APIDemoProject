package bddCucumber.demo.model.Response;

import lombok.Data;

import java.util.List;

@Data
public class UserAccount {
    private String UserID;
    private String userName;
    private List<Book> books;
}
