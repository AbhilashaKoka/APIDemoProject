package cucumberBddTest.endToendAPITest;

import cucumberBddTest.model.bookstoreRequest.AddBookRequest;
import cucumberBddTest.model.bookstoreRequest.ISBN;
import cucumberBddTest.model.bookstoreRequest.NewUser;
import cucumberBddTest.model.bookstoreRequest.RemoveBookRequest;
import cucumberBddTest.model.bookstoreResponse.Books;
import cucumberBddTest.model.bookstoreResponse.Token;
import cucumberBddTest.model.bookstoreResponse.UserCreated;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BookStoreEndPoints {

    private static final String BASE_URL="https://bookstore.toolsqa.com";


    public static UserCreated createNewUser(String username, String password){
        RestAssured.baseURI=BASE_URL;
        RequestSpecification request=RestAssured.given();
        request.header("Content-Type","application/json");
        NewUser authRequest=new NewUser(username,password);
        Response response1=request.body(authRequest).post(BookStoreRoute.createNewUser());
        return response1.getBody().as(UserCreated.class);

    }


    public static Token generateToken(String username, String password){
        RestAssured.baseURI=BASE_URL;
        RequestSpecification request=RestAssured.given();
        request.header("Content-Type","application/json");
        NewUser authRequest=new NewUser(username,password);
        Response response1=request.body(authRequest).post(BookStoreRoute.generateToken());
        return response1.getBody().as(Token.class);
    }


    public static String authorizedNewUser(String username, String password){
        RestAssured.baseURI=BASE_URL;
        RequestSpecification request=RestAssured.given();
        request.header("Content-Type","application/json");
        NewUser authRequest=new NewUser(username,password);
        Response response=request.body(authRequest).post(BookStoreRoute.authorizedUser());
        return response.getBody().asString();
    }

    public static Books getBook(){
        RestAssured.baseURI=BASE_URL;
        RequestSpecification request=RestAssured.given();
        request.header("Content-Type","application/json");
        Response response= request.get(BookStoreRoute.books());
        return response.getBody().as(Books.class);
    }

    public static Response addBook( String isbn){
        RestAssured.baseURI=BASE_URL;
        RequestSpecification request=RestAssured.given();
        Token token=new Token();
        request.header("Authorization","Bearer "+token.getToken())
                .header("Content-Type","application/json");
        UserCreated user=new UserCreated();
        AddBookRequest addBookRequest=new AddBookRequest(user.getUserID(), new ISBN(isbn));
        return request.body(addBookRequest).post(BookStoreRoute.books());
    }

    public static Response removeBook(String isbn){
        RestAssured.baseURI=BASE_URL;
        RequestSpecification request=RestAssured.given();
        Token token=new Token();
        request.header("Authorization","Bearer "+token.getToken())
                .header("Content-Type","application/json");
        UserCreated user=new UserCreated();
        RemoveBookRequest removeBookRequest=new RemoveBookRequest(user.getUserID(),new ISBN(isbn));
        return request.delete(BookStoreRoute.book());
    }

    public static Response getUserAccount(String userId , String token){
        RestAssured.baseURI=BASE_URL;
        RequestSpecification request=RestAssured.given();
        request.header("Authorization","Bearer "+token)
                .header("Content-Type","application/json");
        return request.get(BookStoreRoute.userAccount(userId));
    }
}
