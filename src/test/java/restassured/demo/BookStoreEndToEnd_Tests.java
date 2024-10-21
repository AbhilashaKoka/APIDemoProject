package restassured.demo;

import bddCucumber.demo.model.Request.AddListOfBooks;
import bddCucumber.demo.model.Request.AuthorizationRequest;
import bddCucumber.demo.model.Request.RemoveBookRequest;
import bddCucumber.demo.model.Response.Book;
import bddCucumber.demo.model.Response.JSONFailureResponse;
import bddCucumber.demo.model.Response.JSONSuccessResponse;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.LinkedHashMap;
import java.util.List;

import static io.restassured.RestAssured.given;


public class BookStoreEndToEnd_Tests {
         static  String baseUrl="https://bookstore.toolsqa.com";
         static  JSONObject requestParam;

            public  Response CreateUser(String UserName, String Password) {
            RestAssured.baseURI=baseUrl;
            RequestSpecification request= given();
            request.header("Content-Type", "application/json");
            requestParam = new JSONObject();
            requestParam.put("userName", UserName);
            requestParam.put("password", Password);
            return request.body(requestParam.toString()).post("/Account/v1/User");
          }


            public Response GenerateToken( String UserName, String Password) {
            RestAssured.baseURI = baseUrl;
            RequestSpecification request = given();
            AuthorizationRequest authRequest = new AuthorizationRequest(UserName, Password);
            request.header("Content-Type", "application/json");
            return request.body(authRequest).post("/Account/v1/GenerateToken");
         }

           public  Response AuthorizedUser(String UserName, String Password) {
            RestAssured.baseURI=baseUrl;
            RequestSpecification request= given();
            AuthorizationRequest UserAuth = new AuthorizationRequest(UserName, Password);
            request.header("Content-Type", "application/json");
            return request.body(UserAuth).post("/Account/v1/Authorized");
         }



          public  Response  getUser(String userId, String token) {
          RestAssured.baseURI = baseUrl;
           RequestSpecification httpRequest = given().header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json");
              return httpRequest.get("/Account/v1/User/"+userId);
    }

    public  Response GetBookByUserID(String token, String userId) throws IOException {
    // String jsonPayload = new String(Files.readAllBytes(Paths.get("src/test/resource/driver/Books.json")));
     RestAssured.baseURI=baseUrl;
     RequestSpecification request= given().header("Authorization", "Bearer " + token)
            .header("Content-Type", "application/json");
      return request.get("/Account/v1/User/" + userId);
      }

    public  Response GetBooks(String token) throws IOException {
     RestAssured.baseURI=baseUrl;
     RequestSpecification request= given().header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json");
     return request.get("/BookStore/v1/Books");
      }


      public  Response GetBookByISBN(String isbn) {
            RestAssured.baseURI=baseUrl;
            RequestSpecification request= given();
           return request.get("/BookStore/v1/Book?ISBN=" + isbn);

        }


        public Response CreateBooksListByAddingISBN( String userId, List<Object> collectionOfISBN,String token){
          // String addBookRequest = new String(Files.readAllBytes(Paths.get("src/test/resource/driver/AddListOfBooks.json")));
             RestAssured.baseURI=baseUrl;
            RequestSpecification request= given().header("Authorization", "Bearer " + token).
                    header("Content-Type", "application/json");
            AddListOfBooks addListOfBooks=new AddListOfBooks(userId,collectionOfISBN);
            return request.body(addListOfBooks).post("/BookStore/v1/Books");
        }





        public  Response UpdateBookByISBNAndUserId(String token, String userId, String isbn) {

            RestAssured.baseURI=baseUrl;
            RequestSpecification request= given().header("Authorization", "Bearer " + token).
                    header("Content-Type", "application/json");
            RemoveBookRequest removeBookRequest = new RemoveBookRequest(userId, isbn);
            return request.body(removeBookRequest).delete("/BookStore/v1/Book");

        }


        public Response DeleteBookByUserIdAndISBN(String token, String userId, String isbn) {
        RestAssured.baseURI = baseUrl;
        RequestSpecification httpRequest = given()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json");
          return httpRequest.body("{ \"isbn\": \"" + isbn + "\", \"userId\": \"" + userId + "\"}").delete("/BookStore/v1/Book");


    }


          public  void IteratingHeaders() {
           RestAssured.baseURI = baseUrl;
           RequestSpecification httpRequest = given();
           Response response = httpRequest.get("");
           Headers allHeaders = response.headers();
           for (Header header : allHeaders)
           {
               System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
           }
       }


    public  void queryParameter() {
        RestAssured.baseURI= baseUrl;
        RequestSpecification httpRequest = given();
        Response  response = httpRequest
                .queryParam("ISBN","9781449325862")
                .get("/BookStore/v1/Book");
        ResponseBody body = response.body();
        String rbdy = body.asString();
        JsonPath jpath = new JsonPath(rbdy);
        String title = jpath.getString("title");
        System.out.println("The book title is - "+title);
    }


    public  void UserRegistrationSuccessAndFailure() {
        RestAssured.baseURI = baseUrl;
        RequestSpecification request = given();
        org.json.simple.JSONObject requestParams = new org.json.simple.JSONObject();
        requestParams.put("UserName", "test_rest");
        requestParams.put("Password", "rest@123");
        request.body(requestParams.toJSONString());
        Response  response = request
                .post("/Account/v1/User");
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
            Assert.assertEquals("User already exists", responseBody);
            Assert.assertEquals("FAULT_USER_ALREADY_EXISTS", responseBody);
        } else if (response.statusCode() == 201) {
            JSONSuccessResponse responseBody = body.as(JSONSuccessResponse.class);
            Assert.assertEquals("OPERATION_SUCCESS", responseBody);
            Assert.assertEquals("Operation completed successfully", responseBody);
        }
    }

    public  void JsonPathUsage() throws MalformedURLException
    {
        RestAssured.baseURI = baseUrl;
        RequestSpecification httpRequest = given();
        Response response = httpRequest
                .get("/utilities/books/getallbooks");
        JsonPath jsonPathEvaluator = response.jsonPath();
        List<String> allBooks = jsonPathEvaluator.getList("books.title");
        for(String book : allBooks)
        {
            System.out.println("Book: " + book);
        }
        List<Book> allBooks1 = jsonPathEvaluator.getList("books", Book.class);
        for(Book book : allBooks1)
        {
            System.out.println("Book: " + book);
        }
        Book[] books = response.jsonPath().getObject("books",Book[].class );
        for(Book book : books)
        {
            System.out.println("Book title " + book);
        }
    }
public void UploadingATextFile(){
    RestAssured.baseURI = "https://api.example.com";
    File textFile = new File("path/to/your/file.txt");
    Response response = given()
            .multiPart("file", textFile)
            .when()
            .post("/upload")
            .then()
            .statusCode(200)
            .extract()
            .response();
    System.out.println("Status Code: " + response.statusCode());
    System.out.println("Response Body: " + response.asString());
}

public void uploadingAHTMLFile()
{
      RestAssured.baseURI = "https://api.example.com";
    File htmlFile = new File("path/to/your/file.html");
    Response response = given()
            .multiPart("file", htmlFile)
            .when()
            .post("/upload")
            .then()
            .statusCode(200)
            .extract()
            .response();
    System.out.println("Status Code: " + response.statusCode());
    System.out.println("Response Body: " + response.asString());

}

public void UploadImageFile(){
    RestAssured.baseURI = "https://api.example.com";
    File imageFile = new File("path/to/your/image.jpg");
    Response response = given()
            .multiPart("file", imageFile)
            .when()
            .post("/upload")
            .then()
            .statusCode(200)
            .extract()
            .response();
    System.out.println("Status Code: " + response.statusCode());
    System.out.println("Response Body: " + response.asString());

}

public void UploadPDFFile(){
    RestAssured.baseURI = "https://api.example.com";
    File pdfFile = new File("path/to/your/document.pdf");
    Response response = given()
            .multiPart("file", pdfFile)
            .when()
            .post("/upload")
            .then()
            .statusCode(200)
            .extract()
            .response();
    System.out.println("Status Code: " + response.statusCode());
    System.out.println("Response Body: " + response.asString());
}

    public void CreatePayloadUsingLinkedHashMap(){
        LinkedHashMap<String, Object> payload = new LinkedHashMap<>();
        payload.put("name", "John Doe");
        payload.put("age", 30);
        payload.put("email", "john.doe@example.com");
        System.out.println("Payload: " + payload);
        RestAssured.baseURI = "https://api.example.com";
        Response response = given()
                .contentType("application/json")
                .body(payload)
                .when()
                .post("/users")
                .then()
                .statusCode(201)
                .extract()
                .response();
        System.out.println("Status Code: " + response.statusCode());
        System.out.println("Response Body: " + response.asString());

    }

    public void JsonFileValidation()
    {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode requestBody = null;
        try {
            requestBody = mapper.readTree(new File("path/to/request.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        RestAssured.baseURI = "https://api.example.com";
        Response response = given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/users")
                .then()
                .statusCode(201)
                .extract()
                .response();
        System.out.println("Status Code: " + response.statusCode());
        System.out.println("Response Body: " + response.asString());
        JsonNode expectedResponse = null;
        try {
            expectedResponse = mapper.readTree(new File("path/to/expectedResponse.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }
          try {
            assert response.asString().equals(mapper.writeValueAsString(expectedResponse));
            System.out.println("Response validation successful!");
        } catch (Exception e) {
            System.out.println("Response validation failed: " + e.getMessage());
        }
    }
    public void sessionManagement() {
        Response loginResponse = given()
                .formParam("username", "user")
                .formParam("password", "password")
                .when()
                .post("https://api.example.com/login")
                .then()
                .extract()
                .response();
        // Extract cookies from the login response
        Cookies cookies = loginResponse.getDetailedCookies();
        // Use the session cookies in subsequent requests
        Response response = given()
                .cookies(cookies)
                .when()
                .get("https://api.example.com/user/profile")
                .then()
                .statusCode(200)
                .extract()
                .response();
        System.out.println("Response Body: " + response.asString());

    }

    public void AuthenticationManagement() {
        Response loginResponse = given()
                .auth().preemptive().basic("user", "password")
                .when()
                .post("https://api.example.com/auth/login")
                .then()
                .extract()
                .response();
        Cookies cookies = loginResponse.getDetailedCookies();
        Response response = given()
                .cookies(cookies)
                .when()
                .get("https://api.example.com/secure-data")
                .then()
                .statusCode(200)
                .extract()
                .response();
        System.out.println("Response Body: " + response.asString());
    }

    public void StateMaintainenceManamgement(){
        Response initialResponse = given()
                .when().get("https://api.example.com/start")
                .then().extract().response();
        Cookies cookies = initialResponse.getDetailedCookies();
        Response response = given()
                .cookies(cookies)
                .when()
                .get("https://api.example.com/continue")
                .then()
                .statusCode(200)
                .extract()
                .response();
        System.out.println("Response Body: " + response.asString());
    }

    public void CustomDataStorageManagement() {
        Cookie customCookie1 = new Cookie.Builder("customKey1", "customValue1").build();
        Cookie customCookie2 = new Cookie.Builder("customKey2", "customValue2").build();
        Cookies cookies = new Cookies(customCookie1, customCookie2);
        Response response = given()
                .cookies(cookies)
                .when()
                .get("https://api.example.com/use-custom-cookies")
                .then()
                .statusCode(200)
                .extract()
                .response();
        System.out.println("Response Body: " + response.asString());

    }
    public void BasicAutheticationMethod(ITestContext context){
        RestAssured.baseURI = System.getProperty("baseurl");
        PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
        authScheme.setUserName("admin");
        authScheme.setPassword("admin");
        RestAssured.authentication = authScheme;
    }

    @BeforeClass
    public void BearerAuthenticationMethod(ITestContext context){
        RestAssured.baseURI = "https://api.example.com";
        String bearerToken = "your_bearer_token_here";
        String authToken  = given()
                .header("Authorization", "Bearer " + bearerToken)
                .when()
                .get("/secure-endpoint")
                .then()
                .statusCode(200)
                .extract()
                .path("token");
        context.setAttribute("authToken", authToken);

    }


    public void OAuthAuthenticationGenerateToken(ITestContext context) {
        RestAssured.baseURI = "https://auth-server.com";
        Response tokenResponse = given()
                .auth()
                .preemptive()
                .basic("client_id", "client_secret")
                .formParam("grant_type", "password")
                .formParam("username", "user@example.com")
                .formParam("password", "password")
                .when()
                .post("/oauth/token")
                .then()
                .statusCode(200)
                .extract()
                .response();
        String accessToken = tokenResponse.jsonPath().getString("access_token");
        System.out.println("Access Token: " + accessToken);

    }
    public void UseOAuth2Token(String accessToken){
        RestAssured.baseURI = "https://api.example.com";
        Response apiResponse = given()
                .header("Authorization", "Bearer " + accessToken)
                .when()
                .get("/secure-endpoint")
                .then()
                .statusCode(200)
                .extract()
                .response();
        System.out.println("API Response: " + apiResponse.asString());
    }

    public void APIKeyQueryParamMethod(ITestContext context){
        RestAssured.baseURI = "https://api.example.com";
        String apiKey = "your_api_key_here";
        Response response = given()
                .queryParam("api_key", apiKey)
                .when()
                .get("/secure-endpoint")
                .then()
                .statusCode(200)
                .extract()
                .response();
        System.out.println("Status Code: " + response.statusCode());
        System.out.println("Response Body: " + response.asString());
    }
    }




