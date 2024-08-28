package serenitytest.tests;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import serenitytest.steps.ElementPageSteps;

@RunWith(SerenityRunner.class)
public class ElementPageTest {

    @Steps
    ElementPageSteps elementPageSteps;

    @Managed(driver="chrome")
    WebDriver driver;

    @Before
    public void setup() {
        elementPageSteps.InitialSetUp();
    }

    @Test
    public void LoginToElement()
    {
     elementPageSteps.LandingPage();
     elementPageSteps.LoginToElement();
    }
}
