package bddCucumber.demo.runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features ={"src/test/resource/UIFeatures","src/test/resource/APIFeatures"},
        glue = {"bddCucumber/demo/APIStepDef","bddCucumber/demo/UIStepDef","bddCucumber/demo/Hooks"},
        tags = "not @skip_scenario and (@browser or @restapi)",
        plugin={"pretty","json:target/cucumber.json","rerun:target/failedrerun.txt"},
        publish=true
)
public class TestRunner extends AbstractTestNGCucumberTests {


    @DataProvider(parallel = true)
    @Override
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
