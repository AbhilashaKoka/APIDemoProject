package cucumberBddTest.runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features ={"src/test/resource/UIFeatures"},
        glue = {"cucumberBddTest/uiStepDef", "cucumberBddTest/Hooks"},
        tags = "not @skip_scenario and @browser and @test",
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
