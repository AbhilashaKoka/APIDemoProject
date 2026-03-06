package utilityDemoTest.dataDrivenTest.endToendTest.configDrivenLocator;
import org.openqa.selenium.By;
import java.util.Map;

public class LocatorFactory {
    private static Map<String, Map<String, String>> locators;

    static {
        String env = System.getProperty("env", "qa"); // default to QA
        // Load JSON/YAML once at startup
        locators = LocatorLoader.load(env);
    }

    public static By get(String page, String element) {
        String locator = locators.get(page).get(element);
        String[] parts = locator.split(":", 2);

        switch (parts[0]) {
            case "id": return By.id(parts[1]);
            case "css": return By.cssSelector(parts[1]);
            case "xpath": return By.xpath(parts[1]);
            case "name": return By.name(parts[1]);
            default: throw new IllegalArgumentException("Unknown locator type: " + parts[0]);
        }
    }
}