package pages.ios;

import io.appium.java_client.ios.IOSDriver;
import org.testng.Assert;

public class SignInSignUpPage extends BasePage {

    public SignInSignUpPage(IOSDriver driver) {
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
}
