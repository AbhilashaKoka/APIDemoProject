package restassured.demo;
import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.response.Response;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import static io.restassured.RestAssured.given;


public class AuthenticationMethod {


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


    public void OAuthAuthenticationMethod(ITestContext context){
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

