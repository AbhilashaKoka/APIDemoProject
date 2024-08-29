package serenity.demo.tests;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import serenity.demo.steps.UploadPageSteps;


@RunWith(SerenityRunner.class)
public class UploadPageTest {

    @Steps
    UploadPageSteps uploadPageSteps;


    @Managed(driver="chrome")
    WebDriver driver;

    @Before
    public void setup() {
        uploadPageSteps.InitialSetUp();
    }


    @Test
    public void UploadAndDownloadTest() throws InterruptedException {
        uploadPageSteps.uploadAndDownloadMethod();
    }
}
