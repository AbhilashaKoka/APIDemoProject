package bddCucumber.demo.endToendAPITest;
import bddCucumber.demo.model.bookstoreRequest.AddBookRequest;
import bddCucumber.demo.model.bookstoreRequest.NewUser;
import bddCucumber.demo.model.bookstoreRequest.RemoveBookRequest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BookStoreEndPoints {

    private static final String BASE_URL="https://bookstore.toolsqa.com";


    public static Response authenticateUser(NewUser authRequest){
        RestAssured.baseURI=BASE_URL;
        RequestSpecification request=RestAssured.given();
        request.header("Content-Type","application/json");
        return request.body(authRequest).post(BookStoreRoute.generateToken());
    }

    public static Response getBook(){
        RestAssured.baseURI=BASE_URL;
        RequestSpecification request=RestAssured.given();
        request.header("Content-Type","application/json");
        return request.get(BookStoreRoute.books());
    }

    public static Response addBook(AddBookRequest addBookRequest, String token){
        RestAssured.baseURI=BASE_URL;
        RequestSpecification request=RestAssured.given();
        request.header("Authorization","Bearer "+token)
                .header("Content-Type","application/json");
        return request.body(addBookRequest).post(BookStoreRoute.books());
    }

    public static Response removeBook(RemoveBookRequest removeBookRequest, String token){
        RestAssured.baseURI=BASE_URL;
        RequestSpecification request=RestAssured.given();
        request.header("Authorization","Bearer "+token)
                .header("Content-Type","application/json");
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
