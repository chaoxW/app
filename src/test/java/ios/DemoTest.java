package ios;

import base.BaseTest;
import io.appium.java_client.ios.IOSDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.ios.LoginPage;

import java.net.MalformedURLException;

import static drivers.Drivers.iOSDriverSetup;

public class DemoTest extends BaseTest {

    private LoginPage loginPage;

    @BeforeTest
    public void setup() throws MalformedURLException {
        IOSDriver driver = iOSDriverSetup();
        this.loginPage = new LoginPage(driver);
    }

    @AfterTest
    public void tearDown() {
        loginPage.quitDriver();
    }

    @Test
    public void iOSDemoTest() throws MalformedURLException {
        loginPage.clickCartButton();
    }
}
