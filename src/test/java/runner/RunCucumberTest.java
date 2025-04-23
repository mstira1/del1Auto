package runner;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

// Cucumber + JUnit 5 Runner
@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(
        key = "cucumber.glue",
        value = "steps"
)
@ConfigurationParameter(
        key = "cucumber.plugin",
        value = "pretty, html:target/cucumber-report.html, json:target/cucumber.json"
)

public class RunCucumberTest {
}
