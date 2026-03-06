package utilityDemoTest.dataDrivenTest.endToendTest.configDrivenLocator;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class LocatorLoader{

    public static Map<String, Map<String, String>> load(String env){
        String filePath = "locators_" + env + ".json";

        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(new File(filePath),
                    mapper.getTypeFactory().constructMapType(Map.class, String.class, Map.class));
        } catch (IOException e){
            throw new RuntimeException("Failed to load locators file: " + filePath, e);
        }
    }
}
