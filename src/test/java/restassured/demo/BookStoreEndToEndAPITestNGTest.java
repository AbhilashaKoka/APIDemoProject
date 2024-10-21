package restassured.demo;
import bddCucumber.demo.model.bookstoreResponse.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookStoreEndToEndAPITestNGTest {
    static String ISBN;
    static String username="Test980";
    static String password="Test@1236";
    static  String userId;
    static  String token;
    static List<Book> books;
    String  code;
    String  message;




    @Test(enabled = true)
    public void VerifyCreateUser()
    {
         BookStoreEndToEnd_Tests e2ETests=new BookStoreEndToEnd_Tests();
         Response response= e2ETests.CreateUser(username,password);
         String body=response.getBody().asString();
          System.out.println(body);
          String statusLine=response.getStatusLine();
        if(statusLine.equalsIgnoreCase("HTTP/1.1 201 Created"))
        {
         userId = response.getBody().jsonPath().getString("userID");
         username = response.getBody().jsonPath().getString("username");
         books= response.getBody().jsonPath().getList("books");
         UserAccount userAccount=response.getBody().as(UserAccount.class);
         System.out.println(userAccount.userID);
            System.out.println(userAccount.username);
            System.out.println(userAccount.books);
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
        BookStoreEndToEnd_Tests e2ETests=new BookStoreEndToEnd_Tests();
        Response response=e2ETests.GenerateToken(username,password);
        String body=response.getBody().asString();
        System.out.println(body);
        token = JsonPath.from(response.asString()).get("token");
        Token token= response.getBody().as(Token.class);
        System.out.println(token.token);
        String statusLine=response.getStatusLine();
        Assert.assertEquals(statusLine,"HTTP/1.1 200 OK");

    }
    @Test(enabled  = true)
    public void VerifyUserAuthorized(){
        BookStoreEndToEnd_Tests e2ETests=new BookStoreEndToEnd_Tests();
        Response response= e2ETests.AuthorizedUser(username,password);
        String body=response.getBody().asString();
        System.out.println(body);
        if(body.equalsIgnoreCase("false")){
            Assert.fail("User is not authorized");
        }

        String statusLine=response.getStatusLine();
        Assert.assertEquals(statusLine,"HTTP/1.1 200 OK");
    }



        @Test(enabled  = true)
        public void VerifygetUser(){
        BookStoreEndToEnd_Tests e2ETests=new BookStoreEndToEnd_Tests();
        Response response= e2ETests.getUser(userId,token);
        String body=response.getBody().asString();
        System.out.println(body);
        String statusLine=response.getStatusLine();
            if(statusLine.equalsIgnoreCase("HTTP/1.1 200 OK")) {
                UserData userData1 = response.getBody().as(UserData.class);
                System.out.println(userData1.userID);
                System.out.println(userData1.username);
                System.out.println(userData1.books);
            }
            if(statusLine.equalsIgnoreCase(" HTTP/1.1 401 Unauthorized"))
            {
                BookOfUserNotPresent bookOfUserNotPresent=response.getBody().as(BookOfUserNotPresent.class);
                System.out.println(bookOfUserNotPresent.toString());
                System.out.println(bookOfUserNotPresent.code);
                System.out.println(bookOfUserNotPresent.message);

            }

       }

       @Test(enabled  = true)
    public void VerifyBooksOfUser() throws IOException {
        BookStoreEndToEnd_Tests e2ETests=new BookStoreEndToEnd_Tests();
        Response response=e2ETests.GetBookByUserID(token, userId);
           String body=response.getBody().asString();
           System.out.println(body);
           String statusLine=response.getStatusLine();
           System.out.println(statusLine);
           if(statusLine.equalsIgnoreCase("HTTP/1.1 200 OK"))
           {
           UserData userData2=response.getBody().as(UserData.class);
           System.out.println( userData2.userID);
           System.out.println(userData2.username);
           System.out.println(userData2.books);

           }
           if(statusLine.equalsIgnoreCase(" HTTP/1.1 401 Unauthorized"))
           {
               BookOfUserNotPresent bookOfUserNotPresent=response.getBody().as(BookOfUserNotPresent.class);
               System.out.println(bookOfUserNotPresent.toString());
               System.out.println(bookOfUserNotPresent.code);
               System.out.println(bookOfUserNotPresent.message);

           }
    }

    @Test(enabled  = true)
    public void VerifyGetBooks() throws IOException {
        BookStoreEndToEnd_Tests e2ETests = new BookStoreEndToEnd_Tests();
        Response response = e2ETests.GetBooks(token);
        String body = response.getBody().asString();
        System.out.println(body);
        String statusLine = response.getStatusLine();
        if (statusLine.equalsIgnoreCase("HTTP/1.1 200 OK")) {
            Books books = response.getBody().as(Books.class);
            System.out.println(books.books.get(0));
            System.out.println(books.books.get(1));
            System.out.println(books.books.get(2));
        } else
        {
            System.out.println(statusLine);
        }
    }

    @Test(enabled = true)
    public void VerifyGetBookByISBN()
    {
        BookStoreEndToEnd_Tests e2ETests=new BookStoreEndToEnd_Tests();
        Response response=e2ETests.GetBookByISBN(ISBN);
        String body=response.getBody().asString();
        System.out.println(body);
        String statusLine = response.getStatusLine();
        if (statusLine.equalsIgnoreCase("HTTP/1.1 200 OK")) {
            List<Map<String, String>> book1 = JsonPath.from(response.asString()).get("books");
            Book[] booksdetails = response.jsonPath().getObject("book", Book[].class);
            for (Book book2 : booksdetails) {
                System.out.println("Book Title:" + book2.toString());
            }
        }
        if (statusLine.equalsIgnoreCase("HTTP/1.1 400 Bad bookstoreRequest")){

            BookOfUserNotPresent bookOfUserNotPresent=response.getBody().as(BookOfUserNotPresent.class);
            System.out.println(bookOfUserNotPresent.toString());
            System.out.println(bookOfUserNotPresent.code);
            System.out.println(bookOfUserNotPresent.message);
            }

    }

    @Test(enabled = true)
    public void VerifyCreateListOfBooksByISBN() throws IOException {
        BookStoreEndToEnd_Tests e2ETests=new BookStoreEndToEnd_Tests();
        List<Object> collectionOfISBN=new ArrayList<>();
        collectionOfISBN.add(ISBN);
        Response response=e2ETests.CreateBooksListByAddingISBN( userId,  collectionOfISBN,  token);
        String body=response.getBody().asString();
        System.out.println(body);
        String statusLine=response.getStatusLine();
        System.out.println(statusLine);
        if(statusLine.equalsIgnoreCase("HTTP/1.1 200 OK"))
        {
            UserData userData3 = response.getBody().as(UserData.class);
            System.out.println(userData3.userID);
            System.out.println(userData3.username);
            System.out.println(userData3.books);

        }
        if(statusLine.equalsIgnoreCase(" HTTP/1.1 401 Unauthorized"))
        {
            BookOfUserNotPresent bookOfUserNotPresent=response.getBody().as(BookOfUserNotPresent.class);
            System.out.println(bookOfUserNotPresent.toString());
            System.out.println(bookOfUserNotPresent.code);
            System.out.println(bookOfUserNotPresent.message);
        }

    }

    @Test(enabled = true)
    public void VerifyUpdateBookByUserIDandISBN() throws IOException {
        BookStoreEndToEnd_Tests e2ETests=new BookStoreEndToEnd_Tests();
        Response response=  e2ETests.UpdateBookByISBNAndUserId( userId,  ISBN,  token);
        String body=response.getBody().asString();
        System.out.println(body);
        String statusLine=response.getStatusLine();
        System.out.println(statusLine);
        if(statusLine.equalsIgnoreCase("HTTP/1.1 200 OK"))
        {
            UserData userData3 = response.getBody().as(UserData.class);
            System.out.println(userData3.userID);
            System.out.println(userData3.username);
            System.out.println(userData3.books);

        }
        if(statusLine.equalsIgnoreCase(" HTTP/1.1 401 Unauthorized"))
        {
            BookOfUserNotPresent bookOfUserNotPresent=response.getBody().as(BookOfUserNotPresent.class);
            System.out.println(bookOfUserNotPresent.toString());
            System.out.println(bookOfUserNotPresent.code);
            System.out.println(bookOfUserNotPresent.message);
        }
    }


@Test(enabled = true)
    public void VerifyDeleteBook() {
    BookStoreEndToEnd_Tests e2ETests = new BookStoreEndToEnd_Tests();
    Response response = e2ETests.DeleteBookByUserIdAndISBN(token, userId, ISBN);
    String body = response.getBody().asString();
    System.out.println(body);
    String statusLine = response.getStatusLine();
    if (statusLine.equalsIgnoreCase("HTTP/1.1 200 OK")) {
        UserData userData3 = response.getBody().as(UserData.class);
        System.out.println(userData3.userID);
        System.out.println(userData3.username);
        System.out.println(userData3.books);

    }
    if (statusLine.equalsIgnoreCase(" HTTP/1.1 401 Unauthorized")) {
        BookOfUserNotPresent bookOfUserNotPresent = response.getBody().as(BookOfUserNotPresent.class);
        System.out.println(bookOfUserNotPresent.toString());
        System.out.println(bookOfUserNotPresent.code);
        System.out.println(bookOfUserNotPresent.message);
    }
}
}
