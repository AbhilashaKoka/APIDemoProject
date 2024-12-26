package bddCucumber.demo.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


    @CucumberOptions(
            features ={"src/test/resource/APIFeatures"},
            glue = {"bddCucumber/demo/apiStepDef","bddCucumber/demo/BookStoreEndToEndSteps"},
            tags = "not @skip_scenario and @restapi",
            plugin={"pretty","json:target/cucumber.json","rerun:target/failedrerun.txt"},
            publish=true
    )
    public class  APITestRunner extends AbstractTestNGCucumberTests {
        @DataProvider(parallel = true)
        @Override
        public Object[][] scenarios() {
            return super.scenarios();
        }
    }

