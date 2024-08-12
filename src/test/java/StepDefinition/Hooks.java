package StepDefinition;


import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void BeforeSteps(){
        //starting a webdriver
        //starting a DB Connection
        //Starting a Test Data
        //Setting a browser Cookies
        //Navigating  to certain Pages
        //or anything before a test

    }

   @After
    public void AfterSteps(){
        //quite the driver
    }
}
