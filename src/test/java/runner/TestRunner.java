package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features ="src/test/resource/Features",
        glue = {"stepDefinition"},
        tags="not @skip_scenario",
        plugin={"pretty","json:target/cucumber-reports/cucumber.json",
                         "rerun:target/rerun.txt"},
        publish=true
)
public class TestRunner extends AbstractTestNGCucumberTests {


    @DataProvider(parallel = true)
    @Override
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
