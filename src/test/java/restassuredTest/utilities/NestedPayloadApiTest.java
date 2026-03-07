package restassuredTest.utilities;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.List;
import java.util.Map;

public class NestedPayloadApiTest {

    @DataProvider(name = "nestedScenarios")
    public Object[][] nestedScenarios() throws Exception {
        // 🔑 Load environment-specific config
        String env = System.getProperty("env", "dev");
        String configFile = "testConfig-" + env + ".yaml";

        ConfigDrivenScenarioFactory.Config config =
                ConfigDrivenScenarioFactory.loadConfig(configFile);

        // Generate nested scenarios
        List<NestedScenarioFactory.TestScenario> scenarios =
                NestedScenarioFactory.generateNestedScenarios(
                        convertRanges(config.parameters),
                        config.expectedStatus.get("valid"),
                        config.expectedStatus.get("invalid")
                );

        // Convert List<TestScenario> → Object[][]
        Object[][] data = new Object[scenarios.size()][3];
        for (int i = 0; i < scenarios.size(); i++) {
            data[i][0] = scenarios.get(i).payload;         // Nested JSON payload
            data[i][1] = scenarios.get(i).expectedStatus;  // Expected status
            data[i][2] = config.endpoint;                  // Endpoint from config
        }
        return data;
    }

    @Test(dataProvider = "nestedScenarios")
    public void testNestedPayloadApi(Map<String, Object> payload, int expectedStatus, String endpoint) {
        Response response = RestAssured.given()
                .contentType("application/json")
                .body(payload)   // 🔑 Send nested payload as JSON body
                .post(endpoint);

        Assert.assertEquals(response.getStatusCode(), expectedStatus,
                "Scenario failed for payload: " + payload);
    }

    // Helper: convert YAML parameters into ranges
    private Map<String, int[]> convertRanges(Map<String, Map<String, Integer>> parameters) {
        Map<String, int[]> ranges = new java.util.HashMap<>();
        for (Map.Entry<String, Map<String, Integer>> entry : parameters.entrySet()) {
            int min = entry.getValue().get("min");
            int max = entry.getValue().get("max");
            ranges.put(entry.getKey(), new int[]{min, max});
        }
        return ranges;
    }
}
