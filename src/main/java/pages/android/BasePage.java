package pages.android;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.android.AndroidUtils;

public class BasePage extends AndroidUtils {

    public BasePage(AndroidDriver driver) {
        super(driver);
    }

    public void insertEmail(String email){
        WebElement element;
        element = getElementByXpath("//android.widget.EditText");
        element.isDisplayed();
        element.sendKeys(email);
    }

    public void clickSignUp() {
        try {
            WebElement element;
            element = getElementById("com.fleetbird.android:id/button_register");
            element.click();
            System.out.println("click sign up button");
        } catch (Exception exp) {
            Assert.fail("click sign up button ERROR");
        }
    }

    public void clickTutorialLogin() {
        try {
            WebElement loginButton;
            loginButton = getElementByAccessibilityId("introPageButtonLogin");
            loginButton.click();
            System.out.println("click tutorial login button");
        } catch (Exception exp) {
            Assert.fail("click tutorial login button ERROR");
        }
    }

    public void clickMainMenuButton() {
        try {
            WebElement mainMenuButton;
            mainMenuButton = getElementByXpath("(//android.view.View[@content-desc=\"btn_icon_middle\"])[1]");
            mainMenuButton.click();
            System.out.println("click main menu button");
        } catch (Exception exp) {
            Assert.fail("click main menu button ERROR");
        }
    }

    public void clickLogoutButton() {
        try {
            scrollToElementByDescription("sideMenuMainMenuItem10");
            WebElement logoutButton;
            logoutButton =  getElementByAccessibilityId("sideMenuMainMenuItem10");
            logoutButton.click();
            System.out.println("click logout button");
        } catch (Exception exp) {
            Assert.fail("click logout button ERROR");
        }
    }

    public void validateLogout() {
        try {
            WebElement logintButton;
            logintButton = getElementByAccessibilityId("sideMenuMainMenuItem0");
            logintButton.getAttribute("text").equals("Login");
            System.out.println("validate Logout success");
        } catch (Exception exp) {
            Assert.fail("validate Logout success ERROR");
        }
    }

}
