package restassuredTest;
import cucumberBddTest.model.bookstoreRequest.NewUser;
import cucumberBddTest.model.bookstoreRequest.ISBN;
import cucumberBddTest.model.bookstoreResponse.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import static DemoTest.programInJavaTest.StringOperation.generatePassword;
import static restassuredTest.BookStoreEndToEnd_Tests.generateISBNList;
import static restassuredTest.BookStoreEndToEnd_Tests.generateRandomName;

public class BookStoreEndToEndAPITestNGTest {
    static ISBN ISBN;
    String userId;
    static  String token;
    static List<Book> books;
    String  code;
    String message;
    String username ;
    String password;
    NewUser authorizationRequest;
    List<ISBN> isbnList;
    Response response;

    @Test(description= "Verify Create User")
    public void VerifyCreateUser() throws IOException {
          BookStoreEndToEnd_Tests e2ETests=new BookStoreEndToEnd_Tests();
          username = generateRandomName(10);
          password=generatePassword();
          authorizationRequest=new NewUser(username, password);
          authorizationRequest.setUserName(username);
          authorizationRequest.setPassword(password);
          response= e2ETests.CreateUser(username,password);
          String body=response.getBody().asString();
          System.out.println(body);
          String statusLine=response.getStatusLine();

          if(statusLine.equalsIgnoreCase("HTTP/1.1 201 Created"))
          {
            userId = response.getBody().jsonPath().getString("userID");
            books= response.getBody().jsonPath().getList("books");
             UserCreated userCreated =response.getBody().as(UserCreated.class);
             System.out.println(userCreated.userID);
             System.out.println(userCreated.username);
             System.out.println(userCreated.books);
        }
        else if(statusLine.equalsIgnoreCase("HTTP/1.1 406 Not Acceptable"))
        {
            code = response.getBody().jsonPath().getString("code");
            message = response.getBody().jsonPath().getString("message");
            UserPresent userPresent= response.getBody().as(UserPresent.class);
            System.out.println(userPresent.code);
            System.out.println(userPresent.message);
        }
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(VerifyGenerateToken(),"User Successfully Authorized!!");
        softAssert.assertTrue(VerifyUserAuthorized(),"Authorized Verify Successfully!!");
        softAssert.assertTrue(VerifyCreateListOfBooksByISBN(),"Create List Of Books By ISBN Successfully!!");
        softAssert.assertTrue(VerifyBooksOfUser(),"Books of User Successfully!!");
        softAssert.assertAll();
    }


    public boolean VerifyGenerateToken(){
        boolean bool=false;
        try {
            BookStoreEndToEnd_Tests e2ETests = new BookStoreEndToEnd_Tests();
            response = e2ETests.GenerateToken(username, password);
            String body = response.getBody().asString();
            System.out.println(body);
            token = JsonPath.from(response.asString()).get("token");
            Token token = response.getBody().as(Token.class);
            System.out.println(token.token);
            String statusLine = response.getStatusLine();
            System.out.println(statusLine);
            Assert.assertEquals(statusLine, "HTTP/1.1 200 OK", "User is Authorized");
            bool = true;
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return bool;
    }


    public boolean VerifyUserAuthorized(){
        boolean bool=false;
        try {
        BookStoreEndToEnd_Tests e2ETests=new BookStoreEndToEnd_Tests();
         response= e2ETests.AuthorizedUser(username,password);
        String body=response.getBody().asString();
        System.out.println(body);
        if(body.equalsIgnoreCase("false")){
            Assert.fail("User is not authorized");
        }
        String statusLine=response.getStatusLine();
        Assert.assertEquals(statusLine,"HTTP/1.1 200 OK","User is Authorized Checked Successfully");
            bool = true;
        }
        catch(Exception ex){
            ex.printStackTrace();
        }

        return bool;
    }


    public boolean VerifyCreateListOfBooksByISBN() throws IOException {
        boolean bool=false;
        try {
            BookStoreEndToEnd_Tests e2ETests = new BookStoreEndToEnd_Tests();

            isbnList = generateISBNList();
            System.out.println(isbnList);
            response = e2ETests.CreateBooksListByAddingISBN(userId, isbnList, token);
            String body = response.getBody().asString();
            System.out.println(body);
            String statusLine = response.getStatusLine();
            System.out.println(statusLine);
            if (statusLine.equalsIgnoreCase("HTTP/1.1 200 OK")) {
                System.out.println(statusLine);
                BookOfUserNotPresent bookOfUserNotPresent = response.getBody().as(BookOfUserNotPresent.class);
                System.out.println(bookOfUserNotPresent.toString());
                System.out.println(bookOfUserNotPresent.code);
                System.out.println(bookOfUserNotPresent.message);
                BookStoreEndToEnd_Tests e2ETests4 = new BookStoreEndToEnd_Tests();
                response = e2ETests4.GetBookByUserID(token, userId);
                String body4 = response.getBody().asString();
                System.out.println(body4);
            } else if (statusLine.equalsIgnoreCase(" HTTP/1.1 201 Created")) {
                UserData userData3 = response.getBody().as(UserData.class);
                System.out.println(userData3.userId);
                System.out.println(userData3.username);
                System.out.println(userData3.books);
                BookStoreEndToEnd_Tests e2ETests4 = new BookStoreEndToEnd_Tests();
                response = e2ETests4.GetBookByUserID(token, userId);
                String body4 = response.getBody().asString();
                System.out.println(body4);

            } else if (statusLine.equalsIgnoreCase(" HTTP/1.1 401 Unauthorized")) {
                BookOfUserNotPresent bookOfUserNotPresent = response.getBody().as(BookOfUserNotPresent.class);
                System.out.println(bookOfUserNotPresent.toString());
                System.out.println(bookOfUserNotPresent.code);
                System.out.println(bookOfUserNotPresent.message);
                BookStoreEndToEnd_Tests e2ETests4 = new BookStoreEndToEnd_Tests();
                response = e2ETests4.GetBookByUserID(token, userId);
                String body4 = response.getBody().asString();
                System.out.println(body4);
            }
            bool = true;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return bool;

    }


    public boolean VerifyBooksOfUser() throws IOException {
        boolean bol=false;
        try {
            BookStoreEndToEnd_Tests e2ETests = new BookStoreEndToEnd_Tests();
            response = e2ETests.GetBookByUserID(token, userId);
            String body = response.getBody().asString();
            System.out.println(body);
            String statusLine = response.getStatusLine();
            System.out.println(statusLine);
            if (statusLine.equalsIgnoreCase("HTTP/1.1 200 OK")) {
                UserData userData2 = response.getBody().as(UserData.class);
                System.out.println(userData2.userId);
                System.out.println(userData2.username);
                System.out.println(userData2.books);

            } else if (statusLine.equalsIgnoreCase(" HTTP/1.1 401 Unauthorized")) {
                BookOfUserNotPresent bookOfUserNotPresent = response.getBody().as(BookOfUserNotPresent.class);
                System.out.println(bookOfUserNotPresent.toString());
                System.out.println(bookOfUserNotPresent.code);
                System.out.println(bookOfUserNotPresent.message);

            }
            bol=true;
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return bol;
    }



        @Test(description = "Verify get User",enabled  = false,dependsOnMethods = {"VerifyCreateUser"})
        public void VerifygetUser(){
        BookStoreEndToEnd_Tests e2ETests=new BookStoreEndToEnd_Tests();
         response= e2ETests.getUser(userId,token);
        String body=response.getBody().asString();
        System.out.println(body);
        String statusLine=response.getStatusLine();
            if(statusLine.equalsIgnoreCase("HTTP/1.1 200 OK")) {
                UserData userData1 = response.getBody().as(UserData.class);
                System.out.println(userData1.userId);
                System.out.println(userData1.username);
                System.out.println(userData1.books);
            }
          else if(statusLine.equalsIgnoreCase(" HTTP/1.1 401 Unauthorized"))
            {
                BookOfUserNotPresent bookOfUserNotPresent=response.getBody().as(BookOfUserNotPresent.class);
                System.out.println(bookOfUserNotPresent.toString());
                System.out.println(bookOfUserNotPresent.code);
                System.out.println(bookOfUserNotPresent.message);

            }

       }



    @Test(description = "Verify get Books", dependsOnMethods = {"VerifyCreateUser"})
    public void VerifyGetBooks() throws IOException {
        BookStoreEndToEnd_Tests e2ETests = new BookStoreEndToEnd_Tests();
          response = e2ETests.GetBooks(token);
        String body = response.getBody().asString();
        System.out.println(body);
        String statusLine = response.getStatusLine();
        if (statusLine.equalsIgnoreCase("HTTP/1.1 200 OK")) {
            Books books = response.getBody().as(Books.class);
            System.out.println(books.books.get(0));
            System.out.println(books.books.get(1));
            System.out.println(books.books.get(2));
        }
        else
        {
            System.out.println(statusLine);
        }
    }

    @Test(description = "Verify Get book by ISBN")
    public void VerifyGetBookByISBN()
    {
        BookStoreEndToEnd_Tests e2ETests=new BookStoreEndToEnd_Tests();
         response=e2ETests.GetBookByISBN(ISBN);
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
        else if (statusLine.equalsIgnoreCase("HTTP/1.1 400 Bad bookstoreRequest")){

            BookOfUserNotPresent bookOfUserNotPresent=response.getBody().as(BookOfUserNotPresent.class);
            System.out.println(bookOfUserNotPresent.toString());
            System.out.println(bookOfUserNotPresent.code);
            System.out.println(bookOfUserNotPresent.message);
            }

    }



   @Test(description = "Verify update books by  UserID and ISBN")
    public void VerifyUpdateBookByUserIDandISBN() throws IOException {
        BookStoreEndToEnd_Tests e2ETests=new BookStoreEndToEnd_Tests();
        System.out.println(userId);
         response=  e2ETests.UpdateBookByISBNAndUserId(token, userId,  ISBN);
        String body=response.getBody().asString();
        System.out.println(body);
        String statusLine=response.getStatusLine();
        System.out.println(statusLine);
        if(statusLine.equalsIgnoreCase("HTTP/1.1 200 OK"))
        {
            UserData userData3 = response.getBody().as(UserData.class);
            System.out.println(userData3.userId);
            System.out.println(userData3.username);
            System.out.println(userData3.books);

        }
      else if(statusLine.equalsIgnoreCase(" HTTP/1.1 401 Unauthorized"))
        {
            BookOfUserNotPresent bookOfUserNotPresent=response.getBody().as(BookOfUserNotPresent.class);
            System.out.println(bookOfUserNotPresent.toString());
            System.out.println(bookOfUserNotPresent.code);
            System.out.println(bookOfUserNotPresent.message);
        }
    }


@Test(description = "Verify Delete Book")
    public void VerifyDeleteBook() {
    BookStoreEndToEnd_Tests e2ETests = new BookStoreEndToEnd_Tests();
    response = e2ETests.DeleteBookByUserIdAndISBN(token, userId, ISBN);
    String body = response.getBody().asString();
    System.out.println(body);
    String statusLine = response.getStatusLine();
    if (statusLine.equalsIgnoreCase("HTTP/1.1 200 OK")) {
        UserData userData3 = response.getBody().as(UserData.class);
        System.out.println(userData3.userId);
        System.out.println(userData3.username);
        System.out.println(userData3.books);
    }

   else if (statusLine.equalsIgnoreCase(" HTTP/1.1 401 Unauthorized")) {
        BookOfUserNotPresent bookOfUserNotPresent = response.getBody().as(BookOfUserNotPresent.class);
        System.out.println(bookOfUserNotPresent.toString());
        System.out.println(bookOfUserNotPresent.code);
        System.out.println(bookOfUserNotPresent.message);
    }
}
}
