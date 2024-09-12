package utils.android;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.common.Utils;

import java.time.Duration;

public class AndroidUtils extends Utils {
    private static AndroidDriver driver;
    final int maxTimeout = 15;

    public AndroidUtils(AndroidDriver driver) {
        AndroidUtils.driver = driver;
    }

    public void pressDone() {
        if (driver.isKeyboardShown()) {
            driver.pressKey(new KeyEvent(AndroidKey.ENTER));
            System.out.println("Keyboard is shown");
        } else {
            System.out.println("Keyboard is not shown");
        }
    }

    public void quitDriver() {
        driver.quit();
        System.out.println("Quit Android Emulator Driver");
    }

    public void activateApp() {
        driver.activateApp("net.spark.bdate.dev");
        System.out.println("Active App");
    }

    public void closeApp() {
        driver.close();
        System.out.println("Close App");
    }

    public void TerminateApp() {
        driver.terminateApp("net.spark.bdate.dev");
        System.out.println("Terminate App");
    }

    public WebElement getElementById(String id) {
        try {
            WebElement element;
            element = driver.findElement(AppiumBy.ByAndroidUIAutomator.id(id));
            if (element.isDisplayed()) return element;
            else System.out.println("getElementById MobileElement is not found");
        } catch (Exception e) {
            logError("getElementById", e);
        }
        return null;
    }

    public WebElement getElementByAccessibilityId(String accessID) {
        try {
            WebElement element;
            element = driver.findElement(AppiumBy.ByAndroidUIAutomator.accessibilityId(accessID));
            if (element.isDisplayed()) return element;
            else System.out.println("getElementByAccessibilityId MobileElement is not found");
        } catch (Exception e) {
            logError("getElementByAccessibilityId", e);
        }
        return null;
    }

    public WebElement getElementByXpath(String xpath) {
        try {
            WebElement element;
            element = driver.findElement(AppiumBy.ByAndroidUIAutomator.xpath(xpath));
            if (element.isDisplayed()) return element;
            else System.out.println("getElementByXpath MobileElement is not found");
        } catch (Exception e) {
            logError("getElementByXpath", e);
        }
        return null;
    }

    public WebElement getDropDownList(String xpath, Integer num) {
        try {
            Select dropdown;
            dropdown = new Select(driver.findElement(AppiumBy.ByAndroidUIAutomator.xpath(xpath)));
            dropdown.selectByIndex(num);
        } catch (Exception e) {
            logError("getDropDownList", e);
        }
        return null;
    }

    public WebElement waitForToastByXpath(String xpath) {
        try {
            WebDriverWait waitForToast = new WebDriverWait(driver, Duration.ofSeconds(maxTimeout));
            waitForToast.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.ByAndroidUIAutomator.xpath(xpath)));
            WebElement element;
            element = driver.findElement(AppiumBy.ByAndroidUIAutomator.xpath(xpath));
            return element;
        } catch (Exception e) {
            logError("waitForToastByXpath", e);
        }
        return null;
    }

    public WebElement waitUntilElementVisibilityByXpath(String locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(maxTimeout));
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.ByAndroidUIAutomator.xpath(locator)));
            WebElement element;
            element = driver.findElement(AppiumBy.ByAndroidUIAutomator.xpath(locator));
            return element;
        } catch (Exception e) {
            logError("waitUtilElementVisibilityByXpath", e);
        }
        return null;
    }

    public WebElement waitUntilElementVisibilityById(String locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(maxTimeout));
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.ByAndroidUIAutomator.id(locator)));
            WebElement element;
            element = driver.findElement(AppiumBy.ByAndroidUIAutomator.id(locator));
            return element;
        } catch (Exception e) {
            logError("waitUtilElementVisibilityByXpath", e);
        }
        return null;
    }

    public WebElement scrollToElementByDescription(String text) {
        try {
            WebElement element;
            element = driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().description(\"" + text + "\").instance(0))"));
            if (element.isDisplayed()) return element;
            else System.out.println("scroll to MobileElement failed");
        } catch (Exception e) {
            logError("scrollToElement", e);
        }
        return null;
    }

    public WebElement scrollToElementByText(String text) {
        try {
            WebElement element;
            element = driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + text + "\").instance(0))"));
            if (element.isDisplayed()) return element;
            else System.out.println("scroll to MobileElement failed");
        } catch (Exception e) {
            logError("scrollToElement", e);
        }
        return null;
    }
}
