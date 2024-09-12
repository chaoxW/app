package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {"src/test/resources/features/ios"},
        glue = {"net.spark.bonfire.test.steps.ios"},
        plugin = {"pretty", "html:target/cucumber-ios-reports.html", "json:target/cucumber-ios.json"}
)

public class RunIOSTest extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
