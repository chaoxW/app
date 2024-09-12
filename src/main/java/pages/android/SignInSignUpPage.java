package pages.android;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class SignInSignUpPage extends BasePage {

    public SignInSignUpPage(AndroidDriver driver) {
        super(driver);
    }

    public void isBrandShown() {
        try {
            WebElement brandImage;
            brandImage = getElementByAccessibilityId("text Bonfire");
            brandImage.isDisplayed();
            System.out.println("Brand is shown");
        } catch (Exception exp) {
            Assert.fail("Brand is shown ERROR");
        }
    }

    public void insertEmail(String email) {
        try {
            WebElement emailInput;
            emailInput = waitUntilElementVisibilityByXpath("//android.widget.EditText");
            emailInput.clear();
            emailInput.click();
            emailInput.sendKeys(email);
            System.out.println("insert email " + email);
        } catch (Exception exp) {
            Assert.fail("insert email ERROR");
        }
    }

    public void pressDoneButton() {
        try {
            pressDone();
            System.out.println("Press done");
        } catch (Exception exp) {
            Assert.fail("Press done ERROR");
        }
    }

    public void checkEmailField() {
        try {
            WebElement emailInput;
            emailInput = getElementByXpath("//android.widget.EditText");
            emailInput.isDisplayed();
            System.out.println("Check email test field OK");
        } catch (Exception exp) {
            Assert.fail("Check email test field ERROR");
        }
    }

    public void signInWithEmailDisplayed() {
        try {
            WebElement emailSignIn;
            emailSignIn = waitUntilElementVisibilityByXpath("//android.widget.TextView[@text=\"Continue with your email\"]");
            emailSignIn.isDisplayed();
            System.out.println("Sign in with Email is displayed");
        } catch (Exception exp) {
            Assert.fail("Sign in with Email is displayed ERROR");
        }
    }

    public void continueButtonIsEnabled() {
        try {
            WebElement continueButton;
            continueButton = getElementByXpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.Button");
            continueButton.isDisplayed();
            System.out.println("continue button is enabled is " + continueButton.isEnabled());
            if (continueButton.isEnabled()) {
                System.out.println("Continue button is enabled");
            }
        } catch (Exception exp) {
            Assert.fail("Continue button is enabled ERROR");
        }
    }

    public void validateInvalidEmailErrorMsm() {
        try {
            WebElement errorMsm;
            errorMsm = waitUntilElementVisibilityByXpath("//android.widget.TextView[@text=\"Enter a valid email address\"]");
            Assert.assertTrue(errorMsm.isDisplayed());
            System.out.println("Invalid email error msm is shown: \"Enter a valid email address\"");
        } catch (Exception exp) {
            Assert.fail("Invalid email error msm is shown ERROR");
        }
    }

}
