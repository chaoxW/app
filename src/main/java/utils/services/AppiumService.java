package utils.services;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;


public class AppiumService {
    static AppiumDriverLocalService server;

    private static void setInstance() {
        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder.withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                .usingDriverExecutable(new File("/usr/local/bin/node"))
                .withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
                .withLogFile(new File("Appium-log.txt"))
                .withIPAddress("127.0.0.1");
        server = AppiumDriverLocalService.buildService(builder);
    }

    private static AppiumDriverLocalService getInstance() {
        if (server == null) {
            setInstance();
        }
        return server;
    }

    public static void start() {
        getInstance().start();
        System.out.println("URL " + server.getUrl());
        System.out.println("Server is Running " + server.isRunning());
        System.out.println("Appium server started");
    }

    public static void stop() {
        if (server != null) {
            getInstance().stop();
            System.out.println("Appium server stopped");
        }
    }
}