package cucumberBddTest.uiStepDef;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RadioButtonStepDefs {
    @When("I select radiobutton {string}")
    public void iSelectRadiobutton(String arg0, String arg1) {
    }

    @Then("I am able to verify the details")
    public void iAmAbleToVerifyTheDetails(DataTable table) {
    }

    @Then("I am able to verify the details {string}")
    public void iAmAbleToVerifyTheDetails( String arg1) {
    }
}
