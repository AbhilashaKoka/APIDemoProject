package bddCucumber.demo.Hooks;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import selenium.demo.cucumberContext.TestContext;
import java.io.File;
import java.io.IOException;


public class BaseSetup {
    TestContext testContext;
    WebDriver driver;


    public BaseSetup(TestContext testContext) {
        this.testContext = testContext;

    }

    @Before("not @restapi")
    public void setup(Scenario scenario) {
        System.out.println(scenario.getName());
        driver = testContext.getDriverManager().getDriver();
         driver.get("https://demoqa.com");
    }


    @After
    public void TearDownTest(Scenario scenario){
        if (scenario.isFailed()) {
            final byte[] src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(src, "image/png", scenario.getName());
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
            File destFile = new File("target/screenshots/" + scenario.getName() + ".png");
            try {
                FileUtils.copyFile(srcFile, destFile);
                System.out.println("Screenshot taken for failed step: " + scenario.getName());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    }