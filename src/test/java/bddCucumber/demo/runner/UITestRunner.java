package bddCucumber.demo.runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features ={"src/test/resource/UIFeatures"},
        glue = { "bddCucumber/demo/uiStepDef","bddCucumber/demo/Hooks"},
        tags = "not @skip_scenario and @browser",
        plugin={"pretty","json:target/cucumber.json","rerun:target/failedrerun.txt"},
        publish=true
)
public class UITestRunner extends AbstractTestNGCucumberTests {
    @DataProvider(parallel = true)
    @Override
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
