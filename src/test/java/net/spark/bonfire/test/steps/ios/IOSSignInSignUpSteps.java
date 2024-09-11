package net.spark.bonfire.test.steps.ios;

import io.appium.java_client.ios.IOSDriver;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import pages.ios.SignInSignUpPage;

import java.net.MalformedURLException;

import static drivers.Drivers.iOSDriverSetup;

public class IOSSignInSignUpSteps {

    SignInSignUpPage signInSignUpPage;

    @Before("@iOS")
    public void setup() throws MalformedURLException {
        IOSDriver driver = iOSDriverSetup();
        this.signInSignUpPage = new SignInSignUpPage(driver);
    }

    @Given("I click cart button")
    public void i_click_cart_button() {
        signInSignUpPage.clickCartButton();
    }
}
