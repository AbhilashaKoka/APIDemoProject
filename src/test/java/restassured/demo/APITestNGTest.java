package restassured.demo;

import bddCucumber.demo.model.Response.Book;
import bddCucumber.demo.model.Response.Books;
import bddCucumber.demo.model.Response.Token;
import bddCucumber.demo.model.Response.UserAccount;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class APITestNGTest{

    static String bookId;
    static String username="Test12";
    static String password="Test@125687";
    static  String userId;
    static  String token;
    static  String userData;


    @Test(alwaysRun = true)
    public void VerifyCreateUser()
    {
        E2E_Tests e2ETests=new E2E_Tests();
        Response response=  e2ETests.CreateUser(username,password);
        userId = response.getBody().jsonPath().getString("userID");
         UserAccount userAccount=response.getBody().as(UserAccount.class);
         userAccount.setUserID(userId);
         userData=userAccount.toString();
        String statusLine=response.getStatusLine();
        Assert.assertEquals(statusLine,"HTTP/1.1 201 Created");
        //HTTP/1.1 406 Not Acceptable


    }
    @Test(alwaysRun = true,dependsOnMethods = "VerifyCreateUser")
    public void VerifyGenerateToken(){
        E2E_Tests e2ETests=new E2E_Tests();
        Response response=e2ETests.GenerateToken(username,password);
        token = JsonPath.from(response.asString()).get("token");
        response.getBody().as(Token.class);
        String statusLine=response.getStatusLine();
        Assert.assertEquals(statusLine,"Generate Token:HTTP/1.1 200 OK");

    }
    @Test(dependsOnMethods = "VerifyGenerateToken")
    public void VerifyUserAuthorized(){
        E2E_Tests e2ETests=new E2E_Tests();
        Response response= e2ETests.AuthorizedUser(username,password);
        String statusLine=response.getStatusLine();
        Assert.assertEquals(statusLine,"Authorized User:HTTP/1.1 200 OK");
    }



        @Test
        public void VerifygetUserData(){
        E2E_Tests e2ETests=new E2E_Tests();
        Response response= e2ETests.getUserData(userId,token);
        String body = response.body().asString();
        String statusLine=response.getStatusLine();
        Assert.assertEquals(statusLine,"HTTP/1.1 200 OK");
       }

       @Test
    public void VerifyBooksOfUser() throws IOException {
        E2E_Tests e2ETests=new E2E_Tests();
        Response response=e2ETests.BookofUser(token, userId);
        JsonPath.from(response.asString()).get("books");
        String statusLine=response.getStatusLine();
        Assert.assertEquals(statusLine,"HTTP/1.1 200 OK");
    }

    @Test
    public void VerifyGetBookDetails() throws IOException {
        E2E_Tests e2ETests=new E2E_Tests();
        Response response=e2ETests.GetBooksDetails(token);
        List<Map<String, String>> books = JsonPath.from(response.asString()).get("books");
        Books books1 = response.getBody().as(Books.class);
        Book book = books1.getBook().get(0);
        bookId = books.get(0).get("isbn");
        System.out.println(bookId);
        String statusLine=response.getStatusLine();
        Assert.assertEquals(statusLine,"Generate Token:HTTP/1.1 200 OK");
    }

    @Test
    public void VerifyGetBookByISBN()
    {
        E2E_Tests e2ETests=new E2E_Tests();
        Response response=e2ETests.GetBookDetailsbyISBNNUmber(bookId);
        List<Map<String, String>> book1 = JsonPath.from(response.asString()).get("books");
        Book[] booksdetails = response.jsonPath().getObject("book", Book[].class);
        for (Book book2 : booksdetails)
        {
            System.out.println("Book Title:" + book2.toString());
        }
        String statusLine=response.getStatusLine();
        Assert.assertEquals(statusLine,"Generate Token:HTTP/1.1 200 OK");
    }

@Test
    public void VerifyAddBookByUserIDandISBN() throws IOException {
    E2E_Tests e2ETests=new E2E_Tests();
    Response response=  e2ETests.AddBookbyUserIDandISBN( userId,  bookId,  token);
    UserAccount userAccount = response.getBody().as(UserAccount.class);
    String bookIsAdded = userAccount.getBooks().get(0).getIsbn();
    String statusLine=response.getStatusLine();
    Assert.assertEquals(statusLine,"Generate Token:HTTP/1.1 200 OK");
}

@Test
    public void VerifyRemoveBookByISBN(){
    E2E_Tests e2ETests=new E2E_Tests();
    Response response=e2ETests.RemoveBookBybookIDandUserId( token,  userId,  bookId);
     UserAccount userAccount1 = response.getBody().as(UserAccount.class);
     int bookIsRemoved = userAccount1.getBooks().size();
     String statusLine=response.getStatusLine();
     Assert.assertEquals(statusLine,"Generate Token:HTTP/1.1 200 OK");
}

@Test
    public void VerifyDeleteBook(){
    E2E_Tests e2ETests=new E2E_Tests();
    Response response= e2ETests.deleteBook( token,  userId, bookId);
    String statusLine=response.getStatusLine();
    Assert.assertEquals(statusLine,"Generate Token:HTTP/1.1 200 OK");
    }

    @Test
    public void testWithAuthToken(ITestContext context) {
        // Retrieve auth token from context
        String authToken = (String) context.getAttribute("authToken");
        given()
                .header("Authorization", "Bearer " + authToken)
                .when()
                .get("/secure-endpoint")
                .then()
                .statusCode(200);
    }
}
