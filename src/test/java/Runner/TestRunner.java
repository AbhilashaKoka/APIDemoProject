package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features ="D://Users//akoka//IdeaProjects//untitled//src//test//resource//Features",
        glue = {"StepDefinition"}
)
public class TestRunner {

}
