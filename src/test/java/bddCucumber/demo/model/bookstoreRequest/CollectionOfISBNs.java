package bddCucumber.demo.model.bookstoreRequest;

import java.util.List;

public class CollectionOfISBNs {
    private List<Object> collectionOfIsbns;

    public CollectionOfISBNs(List<Object> collectionOfIsbns) {
        this.collectionOfIsbns = collectionOfIsbns;
    }

    public List<Object> getCollectionOfIsbns() {
        return collectionOfIsbns;
    }

    public void setCollectionOfIsbns(List<Object> collectionOfIsbns) {
        this.collectionOfIsbns = collectionOfIsbns;
    }
}
