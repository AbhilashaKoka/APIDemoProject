package restassured.demo;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.testng.annotations.BeforeClass;

public class BaseSetUpAPI {

    @BeforeClass
    public static void setUp() {
        RestAssured.baseURI = "https://bookstore.toolsqa.com";
        RestAssured.requestSpecification= RestAssured.given().header("Content-Type", "application/json");
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }





}
