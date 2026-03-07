package restassuredTest.utilities;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.File;
import java.util.*;

public class ConfigDrivenScenarioFactory {

    public static class Config {
        public Map<String, Map<String, Integer>> parameters;
        public Map<String, Integer> expectedStatus;
        public String endpoint;   // <-- add this
        public String method;     // <-- optional, if you want GET/POST flexibility
    }

    public static Config loadConfig(String path) throws Exception {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        return mapper.readValue(new File(path), Config.class);
    }

    public static List<MultiParamScenarioFactory.TestScenario> generateFromConfig(Config config) {
        Map<String, int[]> ranges = new HashMap<>();
        for (Map.Entry<String, Map<String, Integer>> entry : config.parameters.entrySet()) {
            int min = entry.getValue().get("min");
            int max = entry.getValue().get("max");
            ranges.put(entry.getKey(), new int[]{min, max});
        }
        return MultiParamScenarioFactory.generateScenarios(
                ranges,
                config.expectedStatus.get("valid"),
                config.expectedStatus.get("invalid")
        );
    }


    public static void main(String[] args) throws Exception {
        Config config = loadConfig("src/test/resource/scenarioConfig/testConfig.yaml");
        List<MultiParamScenarioFactory.TestScenario> scenarios = generateFromConfig(config);
        scenarios.forEach(System.out::println);
    }
}