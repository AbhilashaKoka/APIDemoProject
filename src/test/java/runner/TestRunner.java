package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features ="src/test/resource/Features",
        glue = {"stepDefinition"},
        tags="not @skip_scenario",
        plugin={"pretty","json:target/cucumber-reports/cucumber.json",
                "html:target/cucumber-reports/cucumber-report.html",
                "rerun:target/rerun.txt"},
        publish=true
)
public class TestRunner {

}
