package cucumberBddTest.uiStepDef;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckBoxStepDefs {


    @When("I select {string}")
    public void iSelect(String arg0) {
    }

    @Then("I am able to select all options")
    public void iAmAbleToSelectAllOptions(DataTable table) {
    }


    @Then("I am able to select desire options {string} {string}")
    public void iAmAbleToSelectDesireOptions(String arg2, String arg3) {
    }

    @When("I select radio button {string}")
    public void iSelectRadioButton(String arg0) {
    }

    @Given("I am in CheckBox landing page")
    public void iAmInCheckBoxLandingPage() {
    }
}
