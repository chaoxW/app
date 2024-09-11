package pages.android;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage extends BasePage {

    public LoginPage(AndroidDriver driver) {
        super(driver);
    }

    public void insertEmail(String email) {
        try {
            WebElement emailInput;
            emailInput = getElementByXpath("//android.widget.EditText");
            emailInput.clear();
            emailInput.sendKeys(email);
            System.out.println("insert email " + email);
        } catch (Exception exp) {
            Assert.fail("insert email ERROR");
        }
    }

    public void insertPassword(String password) {
        try {
            WebElement passInput;
            passInput = getElementByAccessibilityId("loginPageInputFieldPassword");
            passInput.clear();
            passInput.sendKeys(password);
            System.out.println("insert password " + password);
        } catch (Exception exp) {
            Assert.fail("insert password ERROR");
        }
    }

    public void clickLoginButton() {
        try {
            WebElement loginButton;
            loginButton = getElementById("com.fleetbird.android:id/buttonLogin");
            loginButton.click();
            System.out.println("click login button");
        } catch (Exception exp) {
            Assert.fail("click login button ERROR");
        }
    }

    public void clickForgetPasswordButton() {
        try {
            WebElement forgetPassButton;
            forgetPassButton = getElementByAccessibilityId("loginPageTextViewForgotPassword");
            forgetPassButton.click();
            System.out.println("click forget password button");
        } catch (Exception exp) {
            Assert.fail("click forget password button ERROR");
        }
    }

    public void clickIntroCloseButton() {
        try {
            WebElement closeButton;
            closeButton = waitUntilElementVisibilityById("com.fleetbird.android:id/introCloseButton");
            closeButton.click();
            System.out.println("click Intro close button");
        } catch (Exception exp) {
            Assert.fail("click Intro close button ERROR");
        }
    }

    public void clickGetBackToLoginButton() {
        try {
            WebElement backButton;
            backButton = getElementByAccessibilityId("toolbar_icon_left");
            backButton.click();
            System.out.println("click get back to login button");
        } catch (Exception exp) {
            Assert.fail("click get back to login button ERROR");
        }
    }

    public void validateLogin() {
        try {
            WebElement element;
            element = waitUntilElementVisibilityById("com.fleetbird.android:id/placeholder_map_controls");
            element.isDisplayed();
            System.out.println("Login success");
        } catch (Exception exp) {
            Assert.fail("validate Login ERROR");
        }
    }

    public void validateRecoveryPasswordPage() {
        try {
            WebElement element;
            element = waitUntilElementVisibilityByXpath("//android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]");
            element.isDisplayed();
            String recoveryPageText = element.getText();
            recoveryPageText.equals("Recover Password");
            System.out.println(recoveryPageText + " is displayed");
        } catch (Exception exp) {
            Assert.fail("validate Login ERROR");
        }
    }

    public void validateLoginError() {
        try {
            String errorMsm = waitForToastByXpath("/hierarchy/android.widget.Toast[1]").getText();
            Assert.assertNotNull(errorMsm);
            System.out.println("Login page error is " + errorMsm);
        } catch (Exception exp) {
            Assert.fail("validate Login error ERROR");
        }
    }

}
