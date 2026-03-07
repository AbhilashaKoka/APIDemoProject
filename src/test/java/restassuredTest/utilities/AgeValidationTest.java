package restassuredTest.utilities;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AgeValidationTest {

    //  Equivalence Partitioning (EP)
    @DataProvider(name = "equivalencePartitions")
    public Object[][] equivalencePartitions() {
        return new Object[][] {
                {20, 200},   // Valid partition (within range)
                {15, 400},   // Invalid partition (below range)
                {65, 400}    // Invalid partition (above range)
        };
    }

    @Test(dataProvider = "equivalencePartitions")
    public void testEquivalencePartitioning(int age, int expectedStatus) {
        Response response = RestAssured.given()
                .queryParam("age", age)
                .get("/validateAge");

        Assert.assertEquals(response.getStatusCode(), expectedStatus,
                "EP failed for age: " + age);
    }

    // Boundary Value Analysis (BVA)
    @DataProvider(name = "boundaryValues")
    public Object[][] boundaryValues() {
        return new Object[][] {
                {17, 400},   // Just below lower boundary
                {18, 200},   // Lower boundary
                {19, 200},   // Just above lower boundary
                {59, 200},   // Just below upper boundary
                {60, 200},   // Upper boundary
                {61, 400}    // Just above upper boundary
        };
    }

    @Test(dataProvider = "boundaryValues")
    public void testBoundaryValueAnalysis(int age, int expectedStatus) {
        Response response = RestAssured.given()
                .queryParam("age", age)
                .get("/validateAge");

        Assert.assertEquals(response.getStatusCode(), expectedStatus,
                "BVA failed for age: " + age);
    }
}
