package cucumberBddTest.uiStepDef;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import seleniumUITest.cucumberContext.TestContext;
import seleniumUITest.manager.FileReaderManager;
import seleniumUITest.pages.PracticeFormPage;
import seleniumUITest.testData.PracticeFormsDetails;

import java.io.IOException;


public class PracticeFormSteps {
    WebDriver driver;
    PracticeFormPage practiceFormPage;
    FileReaderManager fileReaderManager;


    public PracticeFormSteps(TestContext testContext) {
        driver=testContext.getDriverManager().getDriver();
        practiceFormPage=testContext.getPageObjectManager().getPracticePage();
        fileReaderManager=testContext.getFileReaderManager();
    }


    @Given("I am in from landing page")
    public void i_am_in_from_landing_page() {
        System.out.println("User is in Landing Page!!!");
       practiceFormPage.PracticeFormLandingPage();
    }


    @When("I enter details firstname, lastname,gender,email,mobile,dob,subject,hobbies,currentaddr,state,city")
    public void i_enter_details_firstname_lastname_gender_email_mobile_dob_subject_hobbies_currentaddr_state_city() {
        try {
            PracticeFormsDetails practiceFormsDetails = fileReaderManager.getJsonDataReader().getPracticeFormDetailsByFirstName("Sita");
            practiceFormPage.SubmitPracticeForm(practiceFormsDetails);
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }

    @When("I fill all valid List of List and click on submit")
    public void i_fill_all_valid_list_of_list_and_click_on_submit(DataTable dataTable) {
        System.out.println("ListofList");
    }


    @When("I fill all valid List of Map details Values and click on submit")
    public void i_fill_all_valid_list_of_map_details_values_and_click_on_submit(DataTable dataTable) {
        System.out.println("listofMap");
    }



    @Then("I am able to verify form details successfully")
    public void i_am_able_to_verify_form_details_successfully(DataTable table) {
        practiceFormPage.HandlingModalBox();

    }
}
