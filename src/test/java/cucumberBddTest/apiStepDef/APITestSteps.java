package cucumberBddTest.apiStepDef;

import cucumberBddTest.apiTestManager.BookStoreEndPoints;
import cucumberBddTest.model.bookstoreResponse.Book;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class APITestSteps {

    List<Book> books;

    @Given("A list of books are avaliable")
    public void a_list_of_books_are_avaliable() {
        List<Book> books= BookStoreEndPoints.getBook();
        System.out.println(books);
  }


    @When("I created new User login details")
    public void iCreatedNewUserLoginDetails(DataTable dataTable) {
        List<Map<String, String>> table2=dataTable.asMaps();
        BookStoreEndPoints.createNewUser(table2.get(0).get("username"),table2.get(0).get("password"));

    }



    @When("I Authorized new User")
    public void i_authorized_new_user(DataTable dataTable) {
        List<Map<String, String>> table5 = dataTable.asMaps();
        BookStoreEndPoints.generateToken(table5.get(0).get("username"),table5.get(0).get("password"));
        BookStoreEndPoints.authorizedNewUser(table5.get(0).get("username"),table5.get(0).get("password"));
    }


    @When("I added a book to my reading list")
    public void i_added_a_book_to_my_reading_list(DataTable dataTable) {
        List<Map<String, String>> table6 = dataTable.asMaps();
        BookStoreEndPoints.addBook(table6.get(0).get("isbn"));
    }


    @Then("The book is added successfully in book List")
    public void the_book_is_added_successfully_in_book_list() {
        System.out.println("Book is successfully added");
    }


    @When("I remove a book from my reading list")
    public void i_remove_a_book_from_my_reading_list(DataTable dataTable) {
        List<Map<String, String>> table6 = dataTable.asMaps();
        BookStoreEndPoints.removeBook(table6.get(0).get("isbn"));
    }


    @Then("The book is remove successfully from book List")
    public void the_book_is_remove_successfully_from_book_list() {
        System.out.println("Book is successfully removed");
    }



    @When("I send request for books avaliable")
    public void iSendRequestForBooksAvaliable() {
     books= BookStoreEndPoints.getBook();
        System.out.println(books);
    }




    @Then("I am able to successfully verify response with List of Book and details")
    public void iAmAbleToSuccessfullyVerifyResponseWithListOfBookAndDetails(DataTable table) {
        List<Book> actual=books;
        List<Book> expected=new ArrayList<>();
      for(Map<String,String> match:table.asMaps())
      {
          Book book=new Book(match.get("isbn"),match.get("title"),match.get("subTitle"),
                  match.get("author"),match.get("publish_date"),match.get("publisher"),
                  match.get("pages"),match.get("description"),match.get("website"));
          expected.add(book);
      }
        Assert.assertEquals(actual,expected);
    }
}
