package testRunner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        glue = {"stepDefinitions"},
        features = {"src/test/resources/Features/"},
        dryRun = false,
        plugin = {"pretty","html:test-output.html"},
        publish = true
)
public class TestRunner {
}
