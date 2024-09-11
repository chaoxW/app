package drivers;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobilePlatform;
import properties.DriversProperties;

import java.net.MalformedURLException;
import java.net.URL;

public interface Drivers {
    DriversProperties driversProperties = new DriversProperties();

    static AndroidDriver androidDriverSetup() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName(MobilePlatform.ANDROID)
                .setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2)
                .setDeviceName(driversProperties.getAndroidDeviceName())
                .setPlatformVersion(driversProperties.getAndroidPlatformVersion())
                .setApp(System.getProperty("user.dir") + driversProperties.getAndroidApp());
        return new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
    }

    static IOSDriver iOSDriverSetup() throws MalformedURLException {
        XCUITestOptions options = new XCUITestOptions();
        options.setPlatformName(MobilePlatform.IOS)
                .setAutomationName(AutomationName.IOS_XCUI_TEST)
                .setDeviceName(driversProperties.getIOSDeviceName())
                .setBundleId(driversProperties.getIOSAppBundleID())
                .setApp(System.getProperty("user.dir") + driversProperties.getIOSApp())
                .setPlatformVersion(driversProperties.getIOSPlatformVersion());
        return new IOSDriver(new URL("http://127.0.0.1:4723"), options);
    }
}
