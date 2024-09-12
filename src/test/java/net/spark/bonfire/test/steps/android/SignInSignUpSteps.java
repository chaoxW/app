package net.spark.bonfire.test.steps.android;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.android.SignInSignUpPage;

import java.net.MalformedURLException;

import static drivers.Drivers.androidDriverSetup;

public class SignInSignUpSteps {

    SignInSignUpPage signInSignUpPage;

    @Before("@BD-3")
    public void setup() throws MalformedURLException {
        AndroidDriver androidDriver = androidDriverSetup();
        this.signInSignUpPage = new SignInSignUpPage(androidDriver);
    }

    @Given("I am on sign up sign in screen of a brand")
    public void i_am_on_sign_up_sign_in_screen_of_a_brand() {
        signInSignUpPage.isBrandShown();
    }

    @When("I click on sign in sign up with email")
    public void i_click_on_sign_in_sign_up_with_email() {
//        signInSignUpPage.clickEmail();
    }

    @Then("I can see sign in sign up with email screen")
    public void i_can_see_sign_in_sign_up_with_email_screen() {
        signInSignUpPage.signInWithEmailDisplayed();
    }

    @When("I click on continue button enabled")
    public void i_click_on_continue_button_enabled() {
        signInSignUpPage.continueButtonIsEnabled();
    }

    @And("I click on continue button")
    public void i_click_on_continue_button() {
        signInSignUpPage.pressDoneButton();
    }

    @Then("I can see that the email id field is mandatory")
    public void i_can_see_that_the_email_id_field_is_mandatory() {
        signInSignUpPage.checkEmailField();
    }

    @Then("I enter an {string}")
    public void i_enter_an(String email) {
        signInSignUpPage.insertEmail(email);
    }

    @Then("I will see the error message as per the wireframe")
    public void i_will_see_the_error_message_as_per_the_wireframe() {
        signInSignUpPage.validateInvalidEmailErrorMsm();
    }
}
