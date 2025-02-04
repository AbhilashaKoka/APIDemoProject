package cucumberBddTest.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features ={"src/test/resource/testFeatures"},
        glue = {"cucumberBddTest/testStepDef"},
        tags = "not @skip_scenario and not @restapi and not @browser",

        publish=true
)
public class TestRunner extends AbstractTestNGCucumberTests {

}

