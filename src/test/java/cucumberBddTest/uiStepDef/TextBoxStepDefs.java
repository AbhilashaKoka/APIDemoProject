package cucumberBddTest.uiStepDef;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import seleniumUITest.cucumberContext.TestContext;
import seleniumUITest.manager.FileReaderManager;
import seleniumUITest.pages.HomePage;
import seleniumUITest.testDataClass.TextBoxDetails;
import java.io.IOException;
import java.util.List;
import java.util.Map;


public class TextBoxStepDefs {
       WebDriver driver;
       FileReaderManager fileReaderManager;


HomePage homePage;
    public TextBoxStepDefs(TestContext testContext) {
        driver=testContext.getDriverManager().getDriver();
        homePage=testContext.getPageObjectManager().getHomePage();
        fileReaderManager=testContext.getFileReaderManager();
    }



    @When("User enter details username, email, current address, permanent address and Click on submit")
    public void user_enter_details_username_email_current_address_permanent_address_and_click_on_submit() throws IOException {
            TextBoxDetails textBoxDetails=fileReaderManager.getJsonDataReader().getTextBoxDetailsByUserName("sita");
            homePage.SubmitDetails(textBoxDetails);

    }

    @When("User TextBox Details {string}, {string}, {string}, {string} and Click on submit")
    public void user_text_box_details_and_click_on_submit(String username, String email, String currAddr, String peraddr) {
        System.out.println("username:"+username);
        System.out.println("email:"+email);
        System.out.println("current Addr:"+currAddr);
        System.out.println("permanent Addr:"+peraddr);
    }

    @When("User TextBox values {string}, {string}, {string}, {string} and Click on submit")
    public void user_text_box_values_and_click_on_submit(String username1, String email1, String currAddr1, String peraddr1) throws InterruptedException {
        System.out.println("test");
    }

    @When("User enter textBox values List of List and Click on submit")
    public void user_enter_text_box_values_list_of_list_and_click_on_submit(DataTable dataTable) {
        List<List<String>> table=dataTable.asLists();
        table.get(0).get(0);
    }

    @When("User enter textbox values List of Map and Click on submit")
    public void user_enter_textbox_values_list_of_map_and_click_on_submit(DataTable dataTable) {
        List<Map<String, String>> table2=dataTable.asMaps();
        table2.get(0).get("uname");
        table2.get(0).get("email");
        table2.get(0).get("curraddr");
        table2.get(0).get("permaddr");
    }

    @When("User enter details values using testdataClass and Click on submit")
    public void user_enter_details_values_using_testdata_class_and_click_on_submit(List<TextBoxDetails> textBoxDetails) {
        for (TextBoxDetails textBoxDetails1 : textBoxDetails){
            textBoxDetails1.getUsername();
            textBoxDetails1.getEmail();
            textBoxDetails1.getCurrentaddress();
            textBoxDetails1.getPermanentaddress();
        }
    }

    @Given("User is on TextBox Landing Page")
    public void userIsOnTextBoxLandingPage() {
        homePage.HomeLandingPage();
        System.out.println("User is Landing Page!");
    }


    @Then("user should able to verify the detail on output area")
    public void user_should_able_to_verify_the_detail_on_output_area() {
        homePage.VerifyOutput();
        System.out.println("Verified!");
    }


}
