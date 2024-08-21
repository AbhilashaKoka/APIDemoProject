package StepDefinition;
import CucumberContext.TestContext;
import PageObject.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;


public class ElementStepDefs {

    TestContext testContext;
    HomePage homePage;

    public ElementStepDefs(TestContext testContext) {
        this.testContext = testContext;
         homePage=testContext.getPageObjectManager().getHomePage();
    }

    @Given("User is on Landing Page")
    public void user_is_on_landing_page() {
        System.out.println("User is Landing Page!!");


    }
    @When("User enter details username, email, current address, permanent address")
    public void user_enter_details_username_email_current_address_permanent_address() {
        homePage.SubmitDetails();
    }

    @When("Click on Submit")
    public void click_on_submit() {
        System.out.println("Submitted!!");

    }
    @Then("user should able to verify the detail on output area")
    public void user_should_able_to_verify_the_detail_on_output_area() {
        System.out.println("Verfied!!");

    }


}
