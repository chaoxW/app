package pages.ios;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class PaymentPage extends BasePage {

    public PaymentPage(IOSDriver driver) {
        super(driver);
    }

    public void selectPaymentMethod(String text) {
        try {
            WebElement element;
            element = waitUntilElementVisibilityByAccessId(text);
            element.click();
            System.out.println("click add credit button");
        } catch (Exception e) {
            Assert.fail(logError("selectPaymentMethod", e));
        }
    }

    public void insertCreditCardNumber(String num) {
        try {
            getElementByiOSClassChain("**/XCUIElementTypeTextField[`value == \"4242 4242 4242 4242\"`]").sendKeys(num);
            System.out.println("insert credit card number " + num);
        } catch (Exception e) {
            Assert.fail(logError("insertCreditCardNumber", e));
        }
    }

    public void insertCreditCardMMYY(String mmyy) {
        try {
            getElementByiOSClassChain("**/XCUIElementTypeTextField[`value == \"MM/YY\"`]").sendKeys(mmyy);
            System.out.println("insert credit card MMYY " + mmyy);
        } catch (Exception e) {
            Assert.fail(logError("insertCreditCardMMYY", e));
        }
    }

    public void insertCreditCardSecurityCode(String code) {
        try {
            getElementByiOSClassChain("**/XCUIElementTypeTextField[`value == \"CVV\"`]").sendKeys(code);
            System.out.println("insert credit card code " + code);
        } catch (Exception e) {
            Assert.fail(logError("insertCreditCardSecurityCode", e));
        }
    }

    public void clickAddCreditCardButton() {
        try {
            getElementByAccessId("addCreditCardViewBtAddCard").click();
            System.out.println("click add credit button");
        } catch (Exception e) {
            Assert.fail(logError("clickAddCreditCardButton", e));
        }
    }

    public void paymentAddedSuccessfullyValidation() {
        String text;
        WebElement notificationBanner;
        notificationBanner = waitUntilElementVisibilityByAccessId("notificationBannerLblTitle");
        try {
            if (notificationBanner.isDisplayed()) {
                text = notificationBanner.getText();
                text.equals("Payment method added successfully");
                System.out.println(text);
            }
        } catch (Exception e) {
            Assert.fail(logError("paymentAddedSuccessfullyValidation", e));
        }
    }
}
