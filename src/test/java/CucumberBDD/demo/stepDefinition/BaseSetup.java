package CucumberBDD.demo.stepDefinition;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import selenium.demo.cucumberContext.TestContext;
import java.io.IOException;


public class BaseSetup {
    TestContext testContext;
    WebDriver driver;


    public BaseSetup(TestContext testContext) {
        this.testContext = testContext;

    }

    @Before
    public void setup(Scenario scenario) {
        System.out.println(scenario.getName());
        driver = testContext.getDriverManager().getDriver();
         driver.get("https://demoqa.com");

    }




    @After
    public void TearDownTest(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            final byte[] src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(src, "image/png", scenario.getName());
        }
    }
}