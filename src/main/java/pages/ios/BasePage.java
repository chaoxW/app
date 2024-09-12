package pages.ios;

import io.appium.java_client.ios.IOSDriver;
//import org.testng.Assert;
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
//            Assert.fail(logError("allowLocation", e));
        }
    }

}
