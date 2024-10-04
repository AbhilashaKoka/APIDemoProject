package selenium.demo.endToendAPITest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import selenium.demo.model.Request.AddBookRequest;
import selenium.demo.model.Request.AuthorizationRequest;
import selenium.demo.model.Request.ISBN;
import selenium.demo.model.Request.RemoveBookRequest;
import selenium.demo.model.Response.Book;
import selenium.demo.model.Response.Books;
import selenium.demo.model.Response.Token;
import selenium.demo.model.Response.UserAccount;
import java.util.List;
import java.util.Map;
import io.restassured.path.json.JsonPath;
import org.json.JSONObject;


public class E2E_Tests{
    static String userId;
    static String bookId;
     static String token;
     static  String baseUrl="https://bookstore.toolsqa.com";
     static String UserName="AbhilashaKoka112346";
     static String Password="Abhi@12345334446";

      static   JSONObject requestParam;



        public static void CreateUser() {
            RestAssured.baseURI=baseUrl;
            RequestSpecification request=RestAssured.given();
            Response response;
            request.header("Content-Type", "application/json");
            requestParam = new JSONObject();
            requestParam.put("userName", UserName);
            requestParam.put("password", Password);
            response = request.body(requestParam.toString()).post("/Account/v1/User");
            userId = response.getBody().jsonPath().getString("userID");
            System.out.println(response.getStatusLine());

        }

        public static void GenerateToken() {
            RestAssured.baseURI = baseUrl;
            RequestSpecification request = RestAssured.given();
            Response response;
            AuthorizationRequest authRequest = new AuthorizationRequest(UserName, Password);
            request.header("Content-Type", "application/json");
//        Response response=request.body("{\n" +
//                "   \"userName\": \""+UserName+"\",\n" +
//                "  \"password\": \""+Password+"\"\n" +
//                "}").post("/Account/v1/GenerateToken");
            response = request.body(authRequest).post("/Account/v1/GenerateToken");
            token = JsonPath.from(response.asString()).get("token");
            //deseralized response to Token class
            response.getBody().as(Token.class);
            System.out.println(token);
            System.out.println("Generate Token:" + response.getStatusLine());
        }

        public static void AUthorizedUser() {
            RestAssured.baseURI=baseUrl;
            RequestSpecification request=RestAssured.given();
            Response response;
            AuthorizationRequest UserAuth = new AuthorizationRequest(UserName, Password);
            request.header("Content-Type", "application/json");
            response = request.body(UserAuth).post("/Account/v1/Authorized");
            System.out.println("Authorized User:" + response.getStatusLine());
        }

         public static void BookofUser() {
             RestAssured.baseURI=baseUrl;
             RequestSpecification request=RestAssured.given();
             Response response;
             request.header("Authorization", "Bearer " + token)
                     .header("Content-Type", "application/json");
             response = request.get("/Account/v1/User/" + userId);
             List<Map<String, String>> booksOfUser = JsonPath.from(response.asString()).get("books");
             System.out.println("User  Details:" + response.getStatusLine());
         }

        public static void GetBooksDetails() {
            RestAssured.baseURI=baseUrl;
            RequestSpecification request=RestAssured.given();
            Response response;
            response = request.get("/BookStore/v1/Books");
            System.out.println("Books Details:" + response.getStatusLine());
            List<Map<String, String>> books = JsonPath.from(response.asString()).get("books");
            Books books1 = response.getBody().as(Books.class);
            Book book = books1.books.get(0);
            bookId = books.get(0).get("isbn");
            System.out.println(bookId);
            System.out.println("Books  Details:" + response.getStatusLine());
        }


        public static void GetBookDetailsbyISBNNUmber() {
            RestAssured.baseURI=baseUrl;
            RequestSpecification request=RestAssured.given();
            Response response;
            response = request.get("https://demoqa.com/BookStore/v1/Book?ISBN=" + bookId + "");
            System.out.println("Books Details:" + response.getStatusLine());
            List<Map<String, String>> book1 = JsonPath.from(response.asString()).get("books");
            Book[] booksdetails = response.jsonPath().getObject("book", Book[].class);
            for (Book book2 : booksdetails) {
                System.out.println("Book Title:" + book2.toString());
            }
            System.out.println("Books  Details:" + response.getStatusLine());
        }

        public static void AddBookbyUserIDandISBN() {
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


        public static void RemoveBookBybookIDandUserId() {
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
    }

