package android;

import base.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.android.LoginPage;

import java.net.MalformedURLException;

import static drivers.Drivers.androidDriverSetup;


public class DemoTest extends BaseTest {

    LoginPage loginPage;

    @BeforeTest
    public void setup() throws MalformedURLException {
        AndroidDriver driver = androidDriverSetup();
        this.loginPage = new LoginPage(driver);
    }

//    @AfterTest
//    public void tearDown() {
//        loginPage.quitDriver();
//    }


    @Test
    public void androidDemoTest() {
        loginPage.insertEmail("1234@gmail.com");
        loginPage.insertEmail("qqqqqqq");
    }

}
