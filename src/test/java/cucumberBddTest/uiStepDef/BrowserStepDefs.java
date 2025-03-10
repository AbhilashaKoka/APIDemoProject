package cucumberBddTest.uiStepDef;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import seleniumUITest.manager.FileReaderManager;
import seleniumUITest.pages.BrowserWindowPage;

public class BrowserStepDefs {


    WebDriver driver;
    BrowserWindowPage browserWindowPage;
    FileReaderManager fileReaderManager;

    @Given("I am in Browser landing page")
    public void iAmInBrowserLandingPage() {
        browserWindowPage.BrowserWindowLandingPage();
        System.out.println("I am in Browser Window Landing Page");
    }

    @When("I click on New Tab Button")
    public void iClickOnNewTabButton() throws InterruptedException {
        browserWindowPage.HandlingBrowserWindow();
        System.out.println("I click on New Tab Button");
    }

    @Then("I am able to launch new Tab")
    public void iAmAbleToLaunchNewTab() {
        System.out.println("i am able to Launch a New Tab");
    }

    @When("I click on Window Tab Button")
    public void iClickOnWindowTabButton() {
        System.out.println("I click on Window Tab Button");
    }

    @Then("I am able to launch new Window")
    public void iAmAbleToLaunchNewWindow() {
        System.out.println("i am able to Launch a New Window");
    }

    @When("I click on New Window Message Button")
    public void iClickOnNewWindowMessageButton() {
        System.out.println("I click on New Windwo Message Button");
    }

    @Then("I am able to launch new Window Message Window")
    public void iAmAbleToLaunchNewWindowMessageWindow() {
        System.out.println("I am able to Launch a New Window Message Window");
    }
}
