package cucumberBddTest.model.bookstoreRequest;

import java.util.List;

public class AddListOfBooks {
    public  String userId;

    public List<ISBN> collectionOfIsbns;

    public AddListOfBooks(String userId, List<ISBN> collectionOfIsbns) {
        this.userId = userId;
        this.collectionOfIsbns = collectionOfIsbns;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<ISBN> getCollectionOfIsbns() {
        return collectionOfIsbns;
    }

    public void setCollectionOfIsbns(List<ISBN> collectionOfIsbns) {
        this.collectionOfIsbns = collectionOfIsbns;
    }
}
