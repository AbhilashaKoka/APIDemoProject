package bddCucumber.demo.APIStepDef;

import bddCucumber.demo.endToendAPITest.EndPoints;
import bddCucumber.demo.model.Request.AddBookRequest;
import bddCucumber.demo.model.Request.AuthorizationRequest;
import bddCucumber.demo.model.Request.ISBN;
import bddCucumber.demo.model.Request.RemoveBookRequest;
import bddCucumber.demo.model.Response.Books;
import bddCucumber.demo.model.Response.Token;
import bddCucumber.demo.model.Response.UserAccount;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

public class APITestSteps {
    private static final String USER_ID="";
    private static Response response;
    private static Token tokenResponse;
    private static Object book;
    static String UserName="Test2334";
    static String Password="Test@78234";

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
        System.out.println(books.books.get(0));

    }
    @When("I added a book to my reading list")
    public void i_added_a_book_to_my_reading_list() {
       ISBN isbn=new ISBN("9781449325862");
        AddBookRequest addBookRequest=new AddBookRequest(USER_ID,isbn );
        response=EndPoints.addBook(addBookRequest,tokenResponse.token);
    }
    @Then("The book is added")
    public void the_book_is_added() {
        Assert.assertEquals(201,response.getStatusCode());
        UserAccount userAccount=response.getBody().as(UserAccount.class);
        Assert.assertEquals(USER_ID,userAccount.userID);

    }
    @When("I remove a book from my reading list")
    public void i_remove_a_book_from_my_reading_list() {
        RemoveBookRequest removeBookRequest=new RemoveBookRequest(USER_ID,"9781449325862s");
        response=EndPoints.removeBook(removeBookRequest,tokenResponse.token);
    }
    @Then("The Book is removec")
    public void the_book_is_removec() {
        Assert.assertEquals(204,response.getStatusCode());
        response=EndPoints.getUserAccount(USER_ID, tokenResponse.token);
        Assert.assertEquals(200,response.getStatusCode());
        UserAccount userAccount=response.getBody().as(UserAccount.class);

    }

}
