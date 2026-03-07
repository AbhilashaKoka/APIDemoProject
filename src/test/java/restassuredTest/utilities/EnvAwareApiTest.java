package restassuredTest.utilities;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.List;
import java.util.Map;

public class EnvAwareApiTest {

    @DataProvider(name = "envScenarios")
    public Object[][] envScenarios() throws Exception {
        //  Read environment variable (default to "dev")
        String env = System.getProperty("env", "dev");
        String configFile = "src/test/resource/scenarioConfig/testConfig-" + env + ".yaml";

        // Load config and generate scenarios
        ConfigDrivenScenarioFactory.Config config =
                ConfigDrivenScenarioFactory.loadConfig(configFile);

        List<MultiParamScenarioFactory.TestScenario> scenarios =
                ConfigDrivenScenarioFactory.generateFromConfig(config);

        // Convert List<TestScenario> → Object[][]
        Object[][] data = new Object[scenarios.size()][2];
        for (int i = 0; i < scenarios.size(); i++) {
            data[i][0] = scenarios.get(i).inputs;
            data[i][1] = scenarios.get(i).expectedStatus;
        }
        return data;
    }

    @Test(dataProvider = "envScenarios")
    public void testApiAcrossEnvironments(Map<String, Object> inputs, int expectedStatus) {
        Response response = RestAssured.given()
                .queryParams(inputs)
                .get("/validateInputs");

        Assert.assertEquals(response.getStatusCode(), expectedStatus,
                "Scenario failed for inputs: " + inputs);
    }
}
