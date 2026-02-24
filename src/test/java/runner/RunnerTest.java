package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        glue = "steps",
        tags = "",
        plugin = {"pretty"},
        monochrome = true
)
public class RunnerTest {
}
