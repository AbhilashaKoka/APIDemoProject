package restassuredTest.utilities;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class AgeValidationScenarioTest {

    // DataProvider pulls scenarios from ScenarioFactory
    @DataProvider(name = "ageScenarios")
    public Object[][] ageScenarios() {
        List<ScenarioFactory.TestScenario> scenarios =
                ScenarioFactory.generateScenarios(18, 60, 200, 400);

        // Convert List<TestScenario> to Object[][]
        Object[][] data = new Object[scenarios.size()][2];
        for (int i = 0; i < scenarios.size(); i++) {
            data[i][0] = scenarios.get(i).input;
            data[i][1] = scenarios.get(i).expectedStatus;
        }
        return data;
    }

    @Test(dataProvider = "ageScenarios")
    public void testAgeValidation(int age, int expectedStatus) {
        Response response = RestAssured.given()
                .queryParam("age", age)
                .get("/validateAge");

        Assert.assertEquals(response.getStatusCode(), expectedStatus,
                "Scenario failed for input age: " + age);
    }
}
