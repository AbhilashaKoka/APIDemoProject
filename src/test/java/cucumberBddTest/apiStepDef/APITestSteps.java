package cucumberBddTest.apiStepDef;

import cucumberBddTest.endToendAPITest.BookStoreEndPoints;
import cucumberBddTest.model.bookstoreRequest.AddBookRequest;
import cucumberBddTest.model.bookstoreRequest.ISBN;
import cucumberBddTest.model.bookstoreRequest.NewUser;
import cucumberBddTest.model.bookstoreRequest.RemoveBookRequest;
import cucumberBddTest.model.bookstoreResponse.Books;
import cucumberBddTest.model.bookstoreResponse.Token;
import cucumberBddTest.model.bookstoreResponse.UserCreated;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

public class APITestSteps {
    private static final String USER_ID="";
    private static Response response1;
    private static Token tokenResponse;
    private static Object book;
    static String UserName="Test2334";
    static String Password="Test@78234";




    @Given("I am an authorized user")
    public void i_am_an_authorized_user() {
        NewUser authRequest=new NewUser(UserName,Password);
        response1 = BookStoreEndPoints.authenticateUser(authRequest);
        tokenResponse= response1.getBody().as(Token.class);

    }
    @Given("A list of books are avaliable")
    public void a_list_of_books_are_avaliable() {
        response1 = BookStoreEndPoints.getBook();
        System.out.println(response1.toString());
        Books books= response1.getBody().as(Books.class);
        System.out.println(books.books.get(0));

    }
    @When("I added a book to my reading list")
    public void i_added_a_book_to_my_reading_list() {
         ISBN isbn=new ISBN("9781449325862");
        AddBookRequest addBookRequest=new AddBookRequest(USER_ID, isbn);
        response1 = BookStoreEndPoints.addBook(addBookRequest,tokenResponse.token);
    }
    @Then("The book is added")
    public void the_book_is_added() {
        String statusLine= response1.getStatusLine();
        if(statusLine.equalsIgnoreCase("HTTP/1.1 200 OK")) {
            UserCreated userCreated = response1.getBody().as(UserCreated.class);
            Assert.assertEquals(USER_ID, userCreated.userID);
        }
        if(statusLine.equalsIgnoreCase("HTTP/1.1 504 Gateway Time-out") ){
            System.out.println(statusLine);
        }

    }
    @When("I remove a book from my reading list")
    public void i_remove_a_book_from_my_reading_list() {
        RemoveBookRequest removeBookRequest=new RemoveBookRequest(USER_ID,"9781449325862s");
        response1 = BookStoreEndPoints.removeBook(removeBookRequest,tokenResponse.token);
    }
    @Then("The Book is removec")
    public void the_book_is_removec() {
        String statusLine= response1.getStatusLine();
        System.out.println(statusLine);

        if(statusLine.equalsIgnoreCase("HTTP/1.1 200 OK"))
        {
             response1 = BookStoreEndPoints.getUserAccount(USER_ID, tokenResponse.token);
             UserCreated userCreated = response1.getBody().as(UserCreated.class);
        }

        if(statusLine.equalsIgnoreCase("HTTP/1.1 504 Gateway Time-out") )
        {
            System.out.println(statusLine);
        }

    }




}
