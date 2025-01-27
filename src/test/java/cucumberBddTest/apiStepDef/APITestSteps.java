package cucumberBddTest.apiStepDef;

import cucumberBddTest.endToendAPITest.BookStoreEndPoints;
import cucumberBddTest.model.bookstoreResponse.Books;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;


public class APITestSteps {

    @Given("A list of books are avaliable")
    public void a_list_of_books_are_avaliable() {
        Books books= BookStoreEndPoints.getBook();
        System.out.println(books);
  }


    @When("I enter valid credential to login")
    public void i_enter_valid_credential_to_login(DataTable dataTable) {
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





}
