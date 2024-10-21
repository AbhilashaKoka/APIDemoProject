package bddCucumber.demo.model.bookstoreRequest;

import java.util.List;

public class AddListOfBooks {
    public  String userId;

    public List<Object> collectionOfIsbns;

    public AddListOfBooks(String userId, List<Object> collectionOfIsbns) {
        this.userId = userId;
        this.collectionOfIsbns = collectionOfIsbns;
    }
}
