package restassuredTest.utilities;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.List;
import java.util.Map;

public class MultiParamApiTest {

    //  DataProvider pulls scenarios from MultiParamScenarioFactory
    @DataProvider(name = "multiParamScenarios")
    public Object[][] multiParamScenarios() {
        // Define ranges for parameters
        Map<String, int[]> ranges = Map.of(
                "age", new int[]{18, 60},
                "amount", new int[]{100, 1000}
        );

        List<MultiParamScenarioFactory.TestScenario> scenarios =
                MultiParamScenarioFactory.generateScenarios(ranges, 200, 400);

        // Convert List<TestScenario> → Object[][]
        Object[][] data = new Object[scenarios.size()][2];
        for (int i = 0; i < scenarios.size(); i++) {
            data[i][0] = scenarios.get(i).inputs;
            data[i][1] = scenarios.get(i).expectedStatus;
        }
        return data;
    }

    @Test(dataProvider = "multiParamScenarios")
    public void testMultiParamApi(Map<String, Object> inputs, int expectedStatus) {
        Response response = RestAssured.given()
                .queryParams(inputs)   // Dynamically inject multiple params
                .get("/validateInputs");

        Assert.assertEquals(response.getStatusCode(), expectedStatus,
                "Scenario failed for inputs: " + inputs);
    }
}