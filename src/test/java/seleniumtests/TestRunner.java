package seleniumtests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/functionalTests",
    glue = "seleniumtests.steps",
    tags = "@test")
public class TestRunner {}
