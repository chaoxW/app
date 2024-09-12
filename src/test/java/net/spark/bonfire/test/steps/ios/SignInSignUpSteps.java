package net.spark.bonfire.test.steps.ios;

import io.appium.java_client.ios.IOSDriver;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import pages.ios.SignInSignUpPage;

import java.net.MalformedURLException;

import static drivers.Drivers.iOSDriverSetup;

public class SignInSignUpSteps {

    SignInSignUpPage signInSignUpPage;

    @Before("@BD-3")
    public void setup() throws MalformedURLException {
        IOSDriver driver = iOSDriverSetup();
        this.signInSignUpPage = new SignInSignUpPage(driver);
    }

    @Given("I am on sign up sign in screen of a brand")
    public void i_am_on_sign_up_sign_in_screen_of_a_brand() {
        signInSignUpPage.clickCartButton();
    }
}
