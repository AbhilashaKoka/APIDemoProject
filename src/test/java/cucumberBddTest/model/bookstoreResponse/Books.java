package cucumberBddTest.model.bookstoreResponse;
import java.util.List;
import java.util.Objects;


public class Books {

    public Books() {
    }

    public List<Book> books;

    public Books(List<Book> books) {
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Books books1 = (Books) o;
        return Objects.equals(books, books1.books);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(books);
    }

    @Override
    public String toString() {
        return "Books{" +
                "books=" + books +
                '}';
    }

}
