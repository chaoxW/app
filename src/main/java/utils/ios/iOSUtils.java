package utils.ios;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.common.Utils;

import java.time.Duration;
import java.util.HashMap;

public class iOSUtils extends Utils {
    private final IOSDriver driver;
    final int maxTimeout = 10;

    public iOSUtils(IOSDriver driver) {
        this.driver = driver;
    }

    public void CloseApp() {
        driver.close();
        System.out.println("Close App");
    }

    public void quitDriver() {
        driver.quit();
        System.out.println("Quit iOS Emulator Driver");
    }

    public void clickKeyboardDone() {
        getElementByAccessId("Done").click();
    }

    /// return the element find by xpath if it is displayed
    public WebElement getElementByXpath(String xpath) {
        try {
            WebElement element;
            element = driver.findElement(AppiumBy.xpath(xpath));
            if (element.isDisplayed()) {
                return element;
            } else {
                System.out.println("MobileElement is not found");
            }
        } catch (Exception e) {
            logError("getElementByXpath", e);
        }
        return null;
    }

    public WebElement getElementByXpath(String xpath, boolean logError) {
        try {
            WebElement element;
            element = driver.findElement(AppiumBy.xpath(xpath));
            if (element.isDisplayed()) {
                return element;
            } else {
                System.out.println("MobileElement is not found");
            }
        } catch (Exception e) {
            if (logError) {
                logError("getElementByXpath", e);
            }
        }
        return null;
    }

    /// return the element find by access id if it is displayed
    public WebElement getElementByAccessId(String id) {
        try {
            WebElement element;
            element = driver.findElement(AppiumBy.accessibilityId(id));
            if (element.isDisplayed()) {
                return element;
            } else {
                System.out.println("MobileElement is not found");
            }
        } catch (Exception e) {
            logError("getElementByAccessId", e);
        }
        return null;
    }

    /// return the element find by iOS Class Chain if it is displayed
    public WebElement getElementByiOSClassChain(String iOSClassChain) {
        try {
            WebElement element;
            element = driver.findElement(AppiumBy.iOSClassChain(iOSClassChain));
            if (element.isDisplayed()) {
                return element;
            } else {
                System.out.println("MobileElement is not found");
            }
        } catch (Exception e) {
            logError("getElementByiOSClassChain", e);
        }
        return null;
    }

    public WebElement waitUntilClickable(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(maxTimeout));
            return wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            logError("waitUntilClickable", e);
        }
        return null;
    }

    /// wait until max time out element is visible find by xpath
    public WebElement waitUntilElementVisibilityByXpath(String locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(maxTimeout));
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath(locator)));
            WebElement element;
            element = driver.findElement(AppiumBy.xpath(locator));
            return element;
        } catch (Exception e) {
            logError("waitUtilElementVisibilityByXpath", e);
        }
        return null;
    }

    /// wait until max time out element is visible find by id
    public WebElement waitUntilElementVisibilityByAccessId(String id) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(maxTimeout));
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId(id)));
            WebElement element;
            element = driver.findElement(AppiumBy.accessibilityId(id));
            return element;
        } catch (Exception e) {
            logError("waitUtilElementVisibilityById", e);
        }
        return null;
    }

    /// scroll element with nature direction
    public void scrollElement(WebElement element, String direction) {
        try {
            HashMap<String, Object> scrollObject = new HashMap();
            String elementId = ((RemoteWebElement) element).getId();
            scrollObject.put("elementId", elementId);
            scrollObject.put("direction", direction);
            driver.executeScript("mobile: swipe", scrollObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
