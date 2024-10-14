package restassured.demo;
import bddCucumber.demo.model.Request.AuthorizationRequest;
import bddCucumber.demo.model.Request.RemoveBookRequest;
import bddCucumber.demo.model.Response.Book;
import bddCucumber.demo.model.Response.JSONFailureResponse;
import bddCucumber.demo.model.Response.JSONSuccessResponse;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;

import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class E2E_Tests {
         static  String baseUrl="https://bookstore.toolsqa.com";
         static  JSONObject requestParam;



            public  Response CreateUser(String UserName, String Password) {
            RestAssured.baseURI=baseUrl;
            RequestSpecification request=RestAssured.given();
            request.header("Content-Type", "application/json");
            requestParam = new JSONObject();
            requestParam.put("userName", UserName);
            requestParam.put("password", Password);
            return request.body(requestParam.toString()).post("/Account/v1/User");
          }


            public Response GenerateToken( String UserName, String Password) {
            RestAssured.baseURI = baseUrl;
            RequestSpecification request = RestAssured.given();
            AuthorizationRequest authRequest = new AuthorizationRequest(UserName, Password);
            request.header("Content-Type", "application/json");
            return request.body(authRequest).post("/Account/v1/GenerateToken");
         }

           public  Response AuthorizedUser(String UserName, String Password) {
            RestAssured.baseURI=baseUrl;
            RequestSpecification request=RestAssured.given();
            AuthorizationRequest UserAuth = new AuthorizationRequest(UserName, Password);
            request.header("Content-Type", "application/json");
            return request.body(UserAuth).post("/Account/v1/Authorized");
         }

          public  Response  getUserData(String userId, String token) {
         RestAssured.baseURI = baseUrl;
        RequestSpecification httpRequest = RestAssured.given().header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json");
              return httpRequest.get("/Account/v1/User/"+userId);


    }
    public  Response BookofUser(String token, String userId) throws IOException {
     String jsonPayload = new String(Files.readAllBytes(Paths.get("src/test/resource/driver/Books.json")));
     RestAssured.baseURI=baseUrl;
     RequestSpecification request=RestAssured.given();
     request.header("Authorization", "Bearer " + token)
            .header("Content-Type", "application/json");
      return request.get("/Account/v1/User/" + userId);
      }

    public  Response GetBooksDetails() throws IOException {
     RestAssured.baseURI=baseUrl;
     RequestSpecification request=RestAssured.given();
     return request.get("/BookStore/v1/Books");
      }


      public  Response GetBookDetailsbyISBNNUmber(String bookId) {
            RestAssured.baseURI=baseUrl;
            RequestSpecification request=RestAssured.given();
           return request.get("/BookStore/v1/Book?ISBN=" + bookId);

        }

        public  Response AddBookbyUserIDandISBN(String userId, String bookId,  String token) throws IOException {
            String addBookRequest = new String(Files.readAllBytes(Paths.get("src/test/resource/driver/Books.json")));
                RestAssured.baseURI=baseUrl;
        RequestSpecification request=RestAssured.given();
        request.header("Authorization", "Bearer " + token).header("Content-Type", "application/json");
     //   AddBookRequest addBookRequest = new AddBookRequest(userId, new ISBN(bookId));
           return request.body(addBookRequest).post("/BookStore/v1/Books");

    }


        public  Response RemoveBookBybookIDandUserId(String token, String userId, String bookId) {
            RestAssured.baseURI=baseUrl;
            RequestSpecification request=RestAssured.given();
            request.header("Authorization", "Bearer " + token).
                    header("Content-Type", "application/json");
            RemoveBookRequest removeBookRequest = new RemoveBookRequest(userId, bookId);
            return request.body(removeBookRequest).delete("/BookStore/v1/Book");

        }


        public Response deleteBook(String token, String userId, String isbn) {
        RestAssured.baseURI = baseUrl;
        RequestSpecification httpRequest = RestAssured.given().header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json");
          return httpRequest.body("{ \"isbn\": \"" + isbn + "\", \"userId\": \"" + userId + "\"}").delete("/BookStore/v1/Book");


    }


          public  void IteratingHeaders() {
           RestAssured.baseURI = baseUrl;
           RequestSpecification httpRequest = RestAssured.given();
              Response response = httpRequest.get("");
           Headers allHeaders = response.headers();
           for (Header header : allHeaders) {
               System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
           }
       }


    public  void queryParameter() {
        RestAssured.baseURI= baseUrl;
        RequestSpecification httpRequest = RestAssured.given();
        Response  response = httpRequest.queryParam("ISBN","9781449325862").get("/BookStore/v1/Book");
        ResponseBody body = response.body();
        String rbdy = body.asString();
        JsonPath jpath = new JsonPath(rbdy);
        String title = jpath.getString("title");
        System.out.println("The book title is - "+title);
    }


    public  void UserRegistrationSuccessAndFailure() {
        RestAssured.baseURI = baseUrl;
        RequestSpecification request = RestAssured.given();
        org.json.simple.JSONObject requestParams = new org.json.simple.JSONObject();
        requestParams.put("UserName", "test_rest");
        requestParams.put("Password", "rest@123");
        request.body(requestParams.toJSONString());
        Response  response = request.post("/Account/v1/User");
        ResponseBody body = response.getBody();
        String jsonReponse=response.body().asString();
        try{
            FileWriter file=new FileWriter("src/test/resource/driver/outputfile.json");
            {
           file.write(jsonReponse);
    file.flush();

        }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (response.statusCode() == 200) {
            JSONFailureResponse responseBody = body.as(JSONFailureResponse.class);
            Assert.assertEquals("User already exists", responseBody.FaultId);
            Assert.assertEquals("FAULT_USER_ALREADY_EXISTS", responseBody.fault);
        } else if (response.statusCode() == 201) {
            JSONSuccessResponse responseBody = body.as(JSONSuccessResponse.class);
            Assert.assertEquals("OPERATION_SUCCESS", responseBody.SuccessCode);
            Assert.assertEquals("Operation completed successfully", responseBody.Message);
        }
    }

    public  void JsonPathUsage() throws MalformedURLException
    {
        RestAssured.baseURI = baseUrl;
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/utilities/books/getallbooks");
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

