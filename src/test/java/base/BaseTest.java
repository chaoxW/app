package base;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utils.services.AppiumService;

import java.net.MalformedURLException;

public class BaseTest {

    @BeforeSuite
    public static void startAppiumService() throws MalformedURLException {
        AppiumService.start();
    }

    @AfterSuite
    public static void stopAppiumService() {
        AppiumService.stop();
    }
}
