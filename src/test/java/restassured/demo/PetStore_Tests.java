package restassured.demo;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class PetStore_Tests {

    public Response getPetById(String userId) {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        RequestSpecification httpRequest = given()
                .header("Content-Type", "application/json");
        return httpRequest.get("/pet/"+userId);
    }


}
