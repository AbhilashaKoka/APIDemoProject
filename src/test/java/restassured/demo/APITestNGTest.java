package restassured.demo;

import bddCucumber.demo.model.Response.*;
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
    static String ISBN;
    static String username="Test863";
    static String password="Test@12368";
    static  String userId;
    static  String token;
    static List<Book> books;
    String  code;
    String  message;

    @Test(enabled = true)
    public void VerifyCreateUser()
    {
         E2E_Tests e2ETests=new E2E_Tests();
         Response response= e2ETests.CreateUser(username,password);
         String body=response.getBody().asString();
          System.out.println(body);
          String statusLine=response.getStatusLine();
        if(statusLine.equalsIgnoreCase("HTTP/1.1 201 Created"))
        {
         userId = response.getBody().jsonPath().getString("userID");
         username = response.getBody().jsonPath().getString("username");
         books= response.getBody().jsonPath().getList("Books");
         UserAccount userAccount=response.getBody().as(UserAccount.class);
         System.out.println(userAccount.UserID);
        }
        if(statusLine.equalsIgnoreCase("HTTP/1.1 406 Not Acceptable"))
        {
            code = response.getBody().jsonPath().getString("code");
            message = response.getBody().jsonPath().getString("message");
            UserPresent userPresent= response.getBody().as(UserPresent.class);
            System.out.println(userPresent.code);
            System.out.println(userPresent.message);
        }



    }
    @Test(enabled  = true)
    public void VerifyGenerateToken(){
        E2E_Tests e2ETests=new E2E_Tests();
        Response response=e2ETests.GenerateToken(username,password);
        token = JsonPath.from(response.asString()).get("token");
        Token token= response.getBody().as(Token.class);
        System.out.println(token.token);
        String statusLine=response.getStatusLine();
        Assert.assertEquals(statusLine,"HTTP/1.1 200 OK");

    }
    @Test(enabled  = true)
    public void VerifyUserAuthorized(){
        E2E_Tests e2ETests=new E2E_Tests();
        Response response= e2ETests.AuthorizedUser(username,password);
        String statusLine=response.getStatusLine();
        Assert.assertEquals(statusLine,"HTTP/1.1 200 OK");
    }



        @Test(enabled  = true)
        public void VerifygetUser(){
        E2E_Tests e2ETests=new E2E_Tests();
        Response response= e2ETests.getUser(userId,token);
        UserData userData1=response.getBody().as(UserData.class);

            String statusLine=response.getStatusLine();
            Assert.assertEquals(statusLine,"HTTP/1.1 200 OK");
       }

       @Test(enabled  = true)
    public void VerifyBooksOfUser() throws IOException {
        E2E_Tests e2ETests=new E2E_Tests();
        Response response=e2ETests.GetBookByUserID(token, userId);
           UserData userData1=response.getBody().as(UserData.class);

           String statusLine=response.getStatusLine();
           Assert.assertEquals(statusLine,"HTTP/1.1 200 OK");
    }

    @Test(enabled  = true)
    public void VerifyGetBooks() throws IOException {
          E2E_Tests e2ETests=new E2E_Tests();
          Response response=e2ETests.GetBooks(token);
          Books books= response.getBody().as(Books.class);
          System.out.println(books.books);
        ISBN = books.books.get(0).isbn;
        System.out.println(ISBN);
        String statusLine=response.getStatusLine();
        Assert.assertEquals(statusLine,"Generate Token:HTTP/1.1 200 OK");
    }

    @Test(enabled = false)
    public void VerifyGetBookByISBN()
    {
        E2E_Tests e2ETests=new E2E_Tests();
        Response response=e2ETests.GetBookByISBN(ISBN);
        List<Map<String, String>> book1 = JsonPath.from(response.asString()).get("books");
        Book[] booksdetails = response.jsonPath().getObject("book", Book[].class);
        for (Book book2 : booksdetails)
        {
            System.out.println("Book Title:" + book2.toString());
        }
        String statusLine=response.getStatusLine();
        Assert.assertEquals(statusLine,"Generate Token:HTTP/1.1 200 OK");
    }

@Test(enabled = false)
    public void VerifyAddBookByUserIDandISBN() throws IOException {
    E2E_Tests e2ETests=new E2E_Tests();
    Response response=  e2ETests.AddBookByUserIDAndISBN( userId,  ISBN,  token);
    String statusLine=response.getStatusLine();
    Assert.assertEquals(statusLine,"Generate Token:HTTP/1.1 200 OK");
}

@Test(enabled = false)
    public void VerifyRemoveBookByISBN(){
    E2E_Tests e2ETests=new E2E_Tests();
    Response response=e2ETests.UpdateBookByISBNAndUserId( token,  userId,  ISBN);
     String statusLine=response.getStatusLine();
     Assert.assertEquals(statusLine,"Generate Token:HTTP/1.1 200 OK");
}

@Test(enabled = false)
    public void VerifyDeleteBook(){
    E2E_Tests e2ETests=new E2E_Tests();
    Response response= e2ETests.DeleteBookByUserIdAndISBN( token,  userId, ISBN);
    String statusLine=response.getStatusLine();
    Assert.assertEquals(statusLine,"Generate Token:HTTP/1.1 200 OK");
    }

    @Test(enabled = false)
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
