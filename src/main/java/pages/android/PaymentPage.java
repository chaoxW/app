package pages.android;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class PaymentPage extends BasePage {

    public PaymentPage(AndroidDriver driver) {
        super(driver);
    }

    public void selectPaymentMethod(String text) {
        try {
            waitUntilElementVisibilityByXpath("//android.widget.TextView[@text='" + text + "']").click();
            System.out.println("click add credit button");
        } catch (Exception exp) {
            Assert.fail("click add credit button ERROR");
        }
    }

    public void insertCreditCardNumber(String num) {
        try {
            getElementByXpath("(//android.widget.EditText[@content-desc=\"fleetEditTextInput\"])[1]").sendKeys(num);
            System.out.println("insert credit card number " + num);
        } catch (Exception exp) {
            Assert.fail("insert credit card number ERROR");
        }
    }

    public void insertCreditCardMMYY(String mmyy) {
        try {
            getElementByXpath("(//android.widget.EditText[@content-desc=\"fleetEditTextInput\"])[2]").sendKeys(mmyy);
            System.out.println("insert credit card MMYY " + mmyy);
        } catch (Exception exp) {
            Assert.fail("insert credit card MMYY ERROR");
        }
    }

    public void insertCreditCardSecurityCode(String code) {
        try {
            getElementByXpath("(//android.widget.EditText[@content-desc=\"fleetEditTextInput\"])[3]").sendKeys(code);
            System.out.println("insert credit card code " + code);
        } catch (Exception exp) {
            Assert.fail("insert credit card code ERROR");
        }
    }

    public void clickAddCreditCardButton() {
        try {
            getElementById("com.fleetbird.android:id/addCreditCardButton").click();
            System.out.println("click add credit button");
        } catch (Exception exp) {
            Assert.fail("click add credit button ERROR");
        }
    }

    public void paymentAddedSuccessfullyValidation() {
        String text;
        try {
            WebElement element = waitUntilElementVisibilityById("com.fleetbird.android:id/bannerTitle");
            text = element.getText();
            text.equals("Payment method added successfully");
            System.out.println(text);
        } catch (Exception exp) {
            Assert.fail("Payment Added Successfully ERROR");
        }
    }

}
