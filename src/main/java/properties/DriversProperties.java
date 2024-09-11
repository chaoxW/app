package properties;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class DriversProperties {


    private final Properties properties;

    public DriversProperties() {

        String configFilePath = "src/main/resources/drivers.properties";
        File ConfigFile = new File(configFilePath);

        try {
            FileInputStream configFileReader = new FileInputStream(ConfigFile);
            properties = new Properties();
            try {
                properties.load(configFileReader);
                configFileReader.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("drivers.properties not found at config file path" + configFilePath);
        }
    }


    public String getAndroidDeviceName() {
        String deviceName = properties.getProperty("androidDeviceName");
        if (deviceName != null)
            return deviceName;
        else
            throw new RuntimeException("androidDeviceName not specified in the drivers.properties file.");
    }

    public String getAndroidApp() {
        String app = properties.getProperty("androidApp");
        if (app != null)
            return app;
        else
            throw new RuntimeException("androidApp not specified in the drivers.properties file.");
    }

    public String getAndroidPlatformVersion() {
        String platformVersion = properties.getProperty("androidPlatformVersion");
        if (platformVersion != null)
            return platformVersion;
        else
            throw new RuntimeException("androidPlatformVersion not specified in the drivers.properties file.");
    }

    public String getIOSDeviceName() {
        String deviceName = properties.getProperty("iOSDeviceName");
        if (deviceName != null)
            return deviceName;
        else
            throw new RuntimeException("iOSDeviceName not specified in the drivers.properties file.");
    }

    public String getIOSApp() {
        String app = properties.getProperty("iOSApp");
        if (app != null)
            return app;
        else
            throw new RuntimeException("iOSApp not specified in the drivers.properties file.");
    }

    public String getIOSPlatformVersion() {
        String platformVersion = properties.getProperty("iOSPlatformVersion");
        if (platformVersion != null)
            return platformVersion;
        else
            throw new RuntimeException("iOSPlatformVersion not specified in the drivers.properties file.");
    }

    public String getIOSAppBundleID() {
        String platformVersion = properties.getProperty("iOSAppBundleID");
        if (platformVersion != null)
            return platformVersion;
        else
            throw new RuntimeException("iOSPlatformVersion not specified in the drivers.properties file.");
    }


}

