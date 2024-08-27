package selenium.demo.stepDefinition;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import selenium.demo.cucumberContext.TestContext;
import selenium.demo.pages.WebDriverManager;
;

public class BaseSetup {

    TestContext testContext;
    WebDriver driver;

    public BaseSetup(TestContext testContext) {
        this.testContext = testContext;
        driver=testContext.getWebDriverManager().getDriver();
    }


    @Before
    public void setup(Scenario scenario)
    {
        System.out.println(scenario.getName());
        driver.get("https://demoqa.com");
    }
}
