package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/features",
        glue = "steps",
        tags = "@positivo",
        plugin = "pretty",
        monochrome = false
)
public class RunnerTest {
}
