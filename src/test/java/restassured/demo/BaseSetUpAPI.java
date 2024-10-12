package restassured.demo;

import bddCucumber.demo.model.Request.AuthorizationRequest;
import bddCucumber.demo.model.Response.Token;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;

public class BaseSetUpAPI {

    @BeforeClass
    public static void setUp() {
        RestAssured.baseURI = "https://bookstore.toolsqa.com";
        RestAssured.requestSpecification= RestAssured.given()
                .header("Content-Type", "application/json");
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }





}
