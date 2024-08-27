package selenium.demo.stepDefinition;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import selenium.demo.cucumberContext.TestContext;
import selenium.demo.manager.FileReaderManager;
import selenium.demo.pages.HomePage;
import selenium.demo.testData.TextBoxDetails;

import java.io.IOException;
import java.util.List;
import java.util.Map;


public class ElementStepDefs {
       WebDriver driver;
       FileReaderManager fileReaderManager;

HomePage homePage;
    public ElementStepDefs(TestContext testContext) {
        driver=testContext.getDriverManager().getDriver();
        homePage=testContext.getPageObjectManager().getHomePage();
        fileReaderManager=testContext.getFileReaderManager();
    }


    @Given("User is on Landing Page")
    public void user_is_on_landing_page() {
        System.out.println("User is Landing Page!!");
        homePage.HomeLandingPage();
    }

    @When("User enter details username, email, current address, permanent address")
    public void user_enter_details_username_email_current_address_permanent_address() throws InterruptedException {
      try{
          TextBoxDetails textBoxDetails=fileReaderManager.getJsonDataReader().getTextBoxDetailsByUserName("sita");
          homePage.SubmitDetails(textBoxDetails);
      }catch (IOException ex){
          ex.printStackTrace();
      }


    }

    @When("Click on Submit")
    public void click_on_submit() {
        System.out.println("Submitted!!");

    }
    @Then("user should able to verify the detail on output area")
    public void user_should_able_to_verify_the_detail_on_output_area() {
        System.out.println("Verfied!!");

    }

    @When("User TextBox Details {string}, {string}, {string}, {string}")
    public void user_text_box_details(String username, String email, String currAddr, String peraddr) {
        System.out.println("username:"+username);
        System.out.println("email:"+email);
        System.out.println("current Addr:"+currAddr);
        System.out.println("permanent Addr:"+peraddr);
    }



    @When("User TextBox values {string}, {string}, {string}, {string}")
    public void user_text_box_values(String username1, String email1, String currAddr1, String peraddr1) throws InterruptedException {
        System.out.println("test");
    }



    @When("User enter textBox values List of List")
    public void user_enter_text_box_values_list_of_list(DataTable dataTable) {
     List<List<String>> table=dataTable.asLists();
     table.get(0).get(0);

    }



    @When("User enter textbox values List of Map")
    public void user_enter_textbox_values_list_of_map(DataTable dataTable) {
     List<Map<String, String>> table2=dataTable.asMaps();
     table2.get(0).get("uname");
        table2.get(0).get("email");
        table2.get(0).get("curraddr");
        table2.get(0).get("permaddr");
    }



    @When("User enter details values using testdataClass")
    public void user_enter_details_values_using_testdata_class(List<TextBoxDetails> textBoxDetails) {

        for (TextBoxDetails textBoxDetails1 : textBoxDetails) {
            textBoxDetails1.getUsername();
            textBoxDetails1.getEmail();
            textBoxDetails1.getCurrentaddress();
            textBoxDetails1.getPermanentaddress();
        }
    }



}
