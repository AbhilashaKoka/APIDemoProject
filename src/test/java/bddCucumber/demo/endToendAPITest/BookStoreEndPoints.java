package bddCucumber.demo.endToendAPITest;
import bddCucumber.demo.model.bookstoreRequest.AddBookRequest;
import bddCucumber.demo.model.bookstoreRequest.AuthorizationRequest;
import bddCucumber.demo.model.bookstoreRequest.RemoveBookRequest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BookStoreEndPoints {

    private static final String BASE_URL="https://bookstore.toolsqa.com";

    public static Response authenticateUser(AuthorizationRequest authRequest){
        RestAssured.baseURI=BASE_URL;
        RequestSpecification request=RestAssured.given();
        request.header("Content-Type","application/json");
        Response response=request.body(authRequest).post(BookStoreRoute.generateToken());
        return response;
    }

    public static Response getBook(){
        RestAssured.baseURI=BASE_URL;
        RequestSpecification request=RestAssured.given();
        request.header("Content-Type","application/json");
        Response response=request.get(BookStoreRoute.books());
        return response;
    }

    public static Response addBook(AddBookRequest addBookRequest, String token){
        RestAssured.baseURI=BASE_URL;
        RequestSpecification request=RestAssured.given();
        request.header("Authorization","Bearer "+token)
                .header("Content-Type","application/json");
        Response response=request.body(addBookRequest).post(BookStoreRoute.books());
        return response;
    }

    public static Response removeBook(RemoveBookRequest removeBookRequest, String token){
        RestAssured.baseURI=BASE_URL;
        RequestSpecification request=RestAssured.given();
        request.header("Authorization","Bearer "+token)
                .header("Content-Type","application/json");
        Response response=request.delete(BookStoreRoute.book());
        return response;
    }

    public static Response getUserAccount(String userId , String token){
        RestAssured.baseURI=BASE_URL;
        RequestSpecification request=RestAssured.given();
        request.header("Authorization","Bearer "+token)
                .header("Content-Type","application/json");
        Response response=request.get(BookStoreRoute.userAccount(userId));
        return response;
    }
}
