package pages.android;

import io.appium.java_client.android.AndroidDriver;
import utils.android.AndroidUtils;

public class BasePage extends AndroidUtils {

    public BasePage(AndroidDriver driver) {
        super(driver);
    }

//    public void insertEmail(String email){
//        WebElement element;
//        element = getElementByXpath("//android.widget.EditText");
//        element.isDisplayed();
//        element.sendKeys(email);
//    }

}
