package selenium.demo.stepDefinition;

import selenium.demo.endToendAPITest.EndPoints;
import selenium.demo.model.Request.AddBookRequest;
import selenium.demo.model.Request.AuthorizationRequest;
import selenium.demo.model.Request.ISBN;
import selenium.demo.model.Request.RemoveBookRequest;
import selenium.demo.model.Response.Book;
import selenium.demo.model.Response.Books;
import selenium.demo.model.Response.Token;
import selenium.demo.model.Response.UserAccount;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

public class APITestSteps {
    private static final String USER_ID="";
    private static Response response;
    private static Token tokenResponse;
    private static Book book;
    static String UserName="Test12";
    static String Password="Test@123";

    @Given("I am an authorized user")
    public void i_am_an_authorized_user() {
        AuthorizationRequest authRequest=new AuthorizationRequest(UserName,Password);
        response= EndPoints.authenticateUser(authRequest);
        tokenResponse=response.getBody().as(Token.class);

    }
    @Given("A list of books are avaliable")
    public void a_list_of_books_are_avaliable() {
        response=EndPoints.getBook();
        System.out.println(response.toString());
        Books books=response.getBody().as(Books.class);
        book=books.books.get(0);

    }
    @When("I added a book to my reading list")
    public void i_added_a_book_to_my_reading_list() {
        ISBN isbn=new ISBN(book.isbn);
        AddBookRequest addBookRequest=new AddBookRequest(USER_ID,isbn);
        response=EndPoints.addBook(addBookRequest,tokenResponse.token);
    }
    @Then("The book is added")
    public void the_book_is_added() {
        Assert.assertEquals(201,response.getStatusCode());
        UserAccount userAccount=response.getBody().as(UserAccount.class);
        Assert.assertEquals(USER_ID,userAccount.UserID);
        Assert.assertEquals(book.isbn,userAccount.books.get(0).isbn);
    }
    @When("I remove a book from my reading list")
    public void i_remove_a_book_from_my_reading_list() {
        RemoveBookRequest removeBookRequest=new RemoveBookRequest(USER_ID,book.isbn);
        response=EndPoints.removeBook(removeBookRequest,tokenResponse.token);
    }
    @Then("The Book is removec")
    public void the_book_is_removec() {
        Assert.assertEquals(204,response.getStatusCode());
        response=EndPoints.getUserAccount(USER_ID, tokenResponse.token);
        Assert.assertEquals(200,response.getStatusCode());
        UserAccount userAccount=response.getBody().as(UserAccount.class);
        Assert.assertEquals(0,userAccount.books.size());
    }

}
