package selenium.demo.endToendAPITest;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import selenium.demo.model.Response.Book;
import selenium.demo.model.Response.JSONFailureResponse;
import selenium.demo.model.Response.JSONSuccessResponse;
import java.net.MalformedURLException;
import java.util.List;

public class RestAssuredTestNGTest {


  //  String baseUrl = "https://demoqa.com";
   // String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6InRlc3RpbmcxMjMiLCJwYXNzd29yZCI6IlBhc3N3b3JkQDEiLCJpYXQiOjE2Mjg1NjQyMjF9.lW8JJvJF7jKebbqPiHOBGtCAus8D9Nv1BK6IoIIMJQ4";
    String isbn = "9781449325865";

    static String userId;
    static String bookId;
    static String token;
    static  String baseUrl="https://bookstore.toolsqa.com";
    static String UserName="AbhilashaKoka112346";
    static String Password="Abhi@12345334446";

    RequestSpecification httpRequest = RestAssured.given().header("Authorization", "Bearer " + token).header("Content-Type", "application/json");

    @Test
    public void RegistrationSuccessful() {
        RestAssured.baseURI = "https://bookstore.toolsqa.com";
        RequestSpecification request = RestAssured.given();
        JSONObject requestParams = new JSONObject();
         requestParams.put("UserName", "TOOLSQA-Test");
        requestParams.put("Password", "Test@@123");
        request.body(requestParams.toJSONString());
        Response response = request.post("/Account/v1/User");
        Assert.assertEquals(response.getStatusCode(), 201);
        String userID = response.getBody().jsonPath().getString("userID");
    }

    @Test
    public void GetBooksDetails() {
               RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
               RequestSpecification httpRequest = RestAssured.given();
               Response response = httpRequest.request(Method.GET, "");
               System.out.println("Status received => " + response.getStatusLine());
              System.out.println("Response=>" + response.prettyPrint());
    }

    @Test
    public void updateBook() {
        RestAssured.baseURI = baseUrl;
        RequestSpecification httpRequest = RestAssured.given().header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json");
        Response res = httpRequest.body("{ \"isbn\": \"" + isbn + "\", \"userId\": \"" + userId + "\"}").put("/BookStore/v1/Book/9781449325862");
        System.out.println("The response code - " +res.getStatusCode());
        Assert.assertEquals(res.getStatusCode(),200);

    }

    @BeforeTest
    @AfterTest
    public void getUserData() {
        RestAssured.baseURI = baseUrl;
        RequestSpecification httpRequest = RestAssured.given().header("Authorization", "Bearer " + token)
                        .header("Content-Type", "application/json");

        Response res = httpRequest.get("/Account/v1/User/"+userId);
        ResponseBody body = res.body();
             String rbdy = body.asString();
        System.out.println("Data from the GET API- "+rbdy);
    }

    @Test
    public void deleteBook() {
        RestAssured.baseURI = baseUrl;
        RequestSpecification httpRequest = RestAssured.given().header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json");
        Response res = httpRequest.body("{ \"isbn\": \"" + isbn + "\", \"userId\": \"" + userId + "\"}").delete("/BookStore/v1/Book");
        System.out.println("The response code is - " +res.getStatusCode());
        Assert.assertEquals(res.getStatusCode(),204);

    }

    @Test
    public void IteratingHeaders() {
        RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("");
        Headers allHeaders = response.headers();
            for (Header header : allHeaders) {
            System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
        }
    }
    @Test
    public void queryParameter() {
        RestAssured.baseURI= "https://bookstore.toolsqa.com/BookStore/v1";
        RequestSpecification httpRequest = RestAssured.given();
        Response res = httpRequest.queryParam("ISBN","9781449325862").get("/Book");
        ResponseBody body = res.body();
        String rbdy = body.asString();
        JsonPath jpath = new JsonPath(rbdy);
         String title = jpath.getString("title");
        System.out.println("The book title is - "+title);
    }



@Test
public void UserRegistrationSuccessAndFailure() {
     RestAssured.baseURI ="https://demoqa.com";
    RequestSpecification request = RestAssured.given();
    JSONObject requestParams = new JSONObject();
    requestParams.put("UserName", "test_rest");
    requestParams.put("Password", "rest@123");
    request.body(requestParams.toJSONString());
    Response response = request.post("/Account/v1/User");
    ResponseBody body = response.getBody();
    System.out.println(response.body().asString());
    if (response.statusCode() == 200) {
        JSONFailureResponse responseBody = body.as(JSONFailureResponse.class);
        Assert.assertEquals("User already exists", responseBody.FaultId);
        Assert.assertEquals("FAULT_USER_ALREADY_EXISTS", responseBody.fault);
    }
    else if (response.statusCode() == 201){
        JSONSuccessResponse responseBody = body.as(JSONSuccessResponse.class);
        Assert.assertEquals("OPERATION_SUCCESS", responseBody.SuccessCode);
        Assert.assertEquals("Operation completed successfully", responseBody.Message);
    }
}

    @Test
    public void JsonPathUsage() throws MalformedURLException
    {
        RestAssured.baseURI = "https://restapi.demoqa.com/utilities/books/getallbooks";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("");
        JsonPath jsonPathEvaluator = response.jsonPath();
        List<String> allBooks = jsonPathEvaluator.getList("books.title");
        for(String book : allBooks)
        {
            System.out.println("Book: " + book);
        }
        List<Book> allBooks1 = jsonPathEvaluator.getList("books", Book.class);
       for(Book book : allBooks1)
        {
            System.out.println("Book: " + book.title);
        }
        Book[] books = response.jsonPath().getObject("books",Book[].class );
        for(Book book : books)
        {
            System.out.println("Book title " + book.title);
        }
    }
}
