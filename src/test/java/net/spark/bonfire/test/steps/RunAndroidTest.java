package net.spark.bonfire.test.steps;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(
        features = {"src/test/resources/features/android"},
        glue = {"net.spark.bonfire.test.steps.android"},
        plugin = {"pretty", "html:target/cucumber-android-reports.html", "json:target/cucumber-android.json"}
)

public class RunAndroidTest extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
