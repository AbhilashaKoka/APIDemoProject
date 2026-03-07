package restassuredTest.utilities;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.List;
import java.util.Map;

public class EnvAwarePostApiTest {

    @DataProvider(name = "envScenarios")
    public Object[][] envScenarios() throws Exception {
        // 🔑 Read environment variable (default to "dev")
        String env = System.getProperty("env", "dev");
        String configFile = "src/test/resource/scenarioConfig/testConfig_" + env + ".yaml";

        // Load config and generate scenarios
        ConfigDrivenScenarioFactory.Config config =
                ConfigDrivenScenarioFactory.loadConfig(configFile);

        List<MultiParamScenarioFactory.TestScenario> scenarios =
                ConfigDrivenScenarioFactory.generateFromConfig(config);

        // Convert List<TestScenario> → Object[][]
        Object[][] data = new Object[scenarios.size()][3];
        for (int i = 0; i < scenarios.size(); i++) {
            data[i][0] = scenarios.get(i).inputs;          // JSON payload
            data[i][1] = scenarios.get(i).expectedStatus;  // Expected status
            data[i][2] = config.endpoint;                  // Endpoint from config
        }
        return data;
    }

    @Test(dataProvider = "envScenarios")
    public void testPostApi(Map<String, Object> payload, int expectedStatus, String endpoint) {
        Response response = RestAssured.given()
                .contentType("application/json")
                .body(payload)   // 🔑 Send payload as JSON body
                .post(endpoint);

        Assert.assertEquals(response.getStatusCode(), expectedStatus,
                "Scenario failed for payload: " + payload);
    }
}