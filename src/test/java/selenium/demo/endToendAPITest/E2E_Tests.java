package selenium.demo.endToendAPITest;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import selenium.demo.model.Request.AddBookRequest;
import selenium.demo.model.Request.AuthorizationRequest;
import selenium.demo.model.Request.ISBN;
import selenium.demo.model.Request.RemoveBookRequest;
import selenium.demo.model.Response.*;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;
import io.restassured.path.json.JsonPath;
import org.json.JSONObject;


public class E2E_Tests{
      static  String baseUrl="https://bookstore.toolsqa.com";
       static   JSONObject requestParam;



            public  String CreateUser(String UserName, String Password) {
            RestAssured.baseURI=baseUrl;
            RequestSpecification request=RestAssured.given();
            Response response;
            request.header("Content-Type", "application/json");
            requestParam = new JSONObject();
            requestParam.put("userName", UserName);
            requestParam.put("password", Password);
            response = request.body(requestParam.toString()).post("/Account/v1/User");
            String userId = response.getBody().jsonPath().getString("userID");
            System.out.println(response.getStatusLine());
            return userId;

        }


            public  String GenerateToken( String UserName, String Password) {
            RestAssured.baseURI = baseUrl;
            RequestSpecification request = RestAssured.given();
            AuthorizationRequest authRequest = new AuthorizationRequest(UserName, Password);
            request.header("Content-Type", "application/json");
            Response response = request.body(authRequest).post("/Account/v1/GenerateToken");
            String  token = JsonPath.from(response.asString()).get("token");
            response.getBody().as(Token.class);
            System.out.println(token);
            System.out.println("Generate Token:" + response.getStatusLine());
            return token;
        }

           public  void AUthorizedUser(String UserName, String Password) {
            RestAssured.baseURI=baseUrl;
            RequestSpecification request=RestAssured.given();
            Response response;
            AuthorizationRequest UserAuth = new AuthorizationRequest(UserName, Password);
            request.header("Content-Type", "application/json");
            response = request.body(UserAuth).post("/Account/v1/Authorized");
            System.out.println("Authorized User:" + response.getStatusLine());
        }

          public  void getUserData(String userId, String token) {
         RestAssured.baseURI = baseUrl;
        RequestSpecification httpRequest = RestAssured.given().header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json");
        Response res = httpRequest.get("/Account/v1/User/"+userId);
        ResponseBody body = res.body();
        String rbdy = body.asString();
        System.out.println("Data from the GET API- "+rbdy);
    }

            public  void BookofUser(String token, String userId) {
              RestAssured.baseURI=baseUrl;
             RequestSpecification request=RestAssured.given();
             Response response;
             request.header("Authorization", "Bearer " + token)
                     .header("Content-Type", "application/json");
             response = request.get("/Account/v1/User/" + userId);
             List<Map<String, String>> booksOfUser = JsonPath.from(response.asString()).get("books");
             System.out.println("User  Details:" + response.getStatusLine());
         }

            public  String GetBooksDetails() {
             RestAssured.baseURI=baseUrl;
            RequestSpecification request=RestAssured.given();
            Response response;
            response = request.get("/BookStore/v1/Books");
            System.out.println("Books Details:" + response.getStatusLine());
            List<Map<String, String>> books = JsonPath.from(response.asString()).get("books");
            Books books1 = response.getBody().as(Books.class);
            Book book = books1.books.get(0);
            String   bookId = books.get(0).get("isbn");
            System.out.println(bookId);
            System.out.println("Books  Details:" + response.getStatusLine());
            return bookId;
        }


            public  Book[] GetBookDetailsbyISBNNUmber(String bookId) {
            RestAssured.baseURI=baseUrl;
            RequestSpecification request=RestAssured.given();
            Response response;
            response = request.get("https://demoqa.com/BookStore/v1/Book?ISBN=" + bookId + "");
            System.out.println("Books Details:" + response.getStatusLine());
            List<Map<String, String>> book1 = JsonPath.from(response.asString()).get("books");
            Book[] booksdetails = response.jsonPath().getObject("book", Book[].class);
            for (Book book2 : booksdetails)
            {
                System.out.println("Book Title:" + book2.toString());
            }
            System.out.println("Books  Details:" + response.getStatusLine());

            return booksdetails;
        }

        public  void AddBookbyUserIDandISBN(String userId, String bookId, String token) {
        RestAssured.baseURI=baseUrl;
        RequestSpecification request=RestAssured.given();
        Response response;
        request.header("Authorization", "Bearer " + token).
                header("Content-Type", "application/json");
        AddBookRequest addBookRequest = new AddBookRequest(userId, new ISBN(bookId));
        response = request.body(addBookRequest).post("/BookStore/v1/Books");
        System.out.println(" Add Books By User ID:" + response.getStatusLine());
        UserAccount userAccount = response.getBody().as(UserAccount.class);
        String bookIsAdded = userAccount.books.get(0).isbn;
    }


        public  void RemoveBookBybookIDandUserId(String token, String userId, String bookId) {
            RestAssured.baseURI=baseUrl;
            RequestSpecification request=RestAssured.given();
            Response response;
            request.header("Authorization", "Bearer " + token).
                    header("Content-Type", "application/json");
            RemoveBookRequest removeBookRequest = new RemoveBookRequest(userId, bookId);
            response = request.body(removeBookRequest).delete("/BookStore/v1/Book");
            System.out.println(" Remove Books is removed User ID:" + response.getStatusLine());
            UserAccount userAccount1 = response.getBody().as(UserAccount.class);
            int bookIsRemoved = userAccount1.books.size();
        }


        public  void deleteBook(String token, String userId, String isbn) {
        RestAssured.baseURI = baseUrl;
        RequestSpecification httpRequest = RestAssured.given().header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json");
        Response res = httpRequest.body("{ \"isbn\": \"" + isbn + "\", \"userId\": \"" + userId + "\"}").delete("/BookStore/v1/Book");
        System.out.println("The response code is - " +res.getStatusCode());
        Assert.assertEquals(res.getStatusCode(),204);

    }


          public  void IteratingHeaders() {
           RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
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
        Response res = httpRequest.queryParam("ISBN","9781449325862").get("/BookStore/v1/Book");
        ResponseBody body = res.body();
        String rbdy = body.asString();
        JsonPath jpath = new JsonPath(rbdy);
        String title = jpath.getString("title");
        System.out.println("The book title is - "+title);
    }


    public   void UserRegistrationSuccessAndFailure() {
        RestAssured.baseURI = "https://demoqa.com";
        RequestSpecification request = RestAssured.given();
        org.json.simple.JSONObject requestParams = new org.json.simple.JSONObject();
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
        } else if (response.statusCode() == 201) {
            JSONSuccessResponse responseBody = body.as(JSONSuccessResponse.class);
            Assert.assertEquals("OPERATION_SUCCESS", responseBody.SuccessCode);
            Assert.assertEquals("Operation completed successfully", responseBody.Message);
        }
    }

    public  void JsonPathUsage() throws MalformedURLException
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

