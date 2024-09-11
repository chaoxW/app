package pages.ios;

import io.appium.java_client.ios.IOSDriver;
import org.testng.Assert;

public class LoginPage extends BasePage {

    public LoginPage(IOSDriver driver) {
        super(driver);
    }

    public void clickCartButton() {
        try {
            getElementByAccessId("tab bar option cart").click();
            System.out.println("click tab bar option cart button");
        } catch (Exception e) {
            Assert.fail(logError("clickCartButton", e));
        }
    }

    public void clickSideMenuLogin() {
        try {
            getElementByAccessId("sideMenuBtLogin").click();
            System.out.println("click side menu login");
        } catch (Exception e) {
            Assert.fail(logError("clickSideMenuLogin", e));
        }
    }

    public void insertUsername(String username) {
        try {
            getElementByAccessId("loginTfUserName").clear();
            getElementByAccessId("loginTfUserName").sendKeys(username);
            System.out.println("insert username " + username);
        } catch (Exception e) {
            Assert.fail(logError("insertUsername", e));
        }
    }

    public void insertPassword(String pass) {
        try {
            getElementByAccessId("loginTfPassword").clear();
            getElementByAccessId("loginTfPassword").sendKeys(pass);
            System.out.println("insert password " + pass);
        } catch (Exception e) {
            Assert.fail(logError("insertPassword", e));
        }
    }

    public void clickLoginButton() {
        try {
            getElementByAccessId("loginBtLogin").click();
        } catch (Exception e) {
            Assert.fail(logError("clickLoginButton", e));
        }
    }

    public void clickTutorialLoginButton() {
        try {
            getElementByAccessId("tutorialBtLogin").click();
        } catch (Exception e) {
            Assert.fail(logError("clickTutorialLoginButton", e));
        }
    }

}
