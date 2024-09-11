package pages.ios;

import io.appium.java_client.ios.IOSDriver;
import org.testng.Assert;
import utils.ios.iOSUtils;

public abstract class BasePage extends iOSUtils {

    public BasePage(IOSDriver driver) {
        super(driver);
    }

    public void allowLocation() {
        try {
            getElementByAccessId("Allow Once").click();
            getElementByAccessId("Allow").click();
            System.out.println("click Allow While Using App button");
        } catch (Exception e) {
            Assert.fail(logError("allowLocation", e));
        }
    }

    public void clickSideMenu() {
        try {
            getElementByAccessId("mapViewControllerBtSideMenu").click();
            System.out.println("click side menu");
        } catch (Exception e) {
            Assert.fail(logError("clickSideMenu", e));
        }
    }

    public void closeTutorialViewIsDisplayed() {
        try {
            if (getElementByXpath("//XCUIElementTypeButton[@name='tutorialBtBack']", false).isDisplayed()) {
                getElementByAccessId("tutorialBtBack").click();
                System.out.println("close tutorial view");
            }
        } catch (Exception exp) {
            System.out.println("tutorial view not displayed");
        }
    }

}
