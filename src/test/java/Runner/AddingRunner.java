package Runner;

import Tests.BaseTest;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "src/test/java/Features/AddingCourse.feature"
        ,glue = {"StepDefinition"}
        ,plugin = {"pretty","html:target/cucumber-html-report.html"},
        publish = true)
public class AddingRunner extends BaseTest {
}
