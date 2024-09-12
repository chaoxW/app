package net.spark.bonfire.test.steps.ios;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import utils.services.AppiumService;

public class BaseSteps {

    @BeforeAll
    public static void startAppiumService() {
        AppiumService.start();
    }

    @AfterAll
    public static void stopAppiumService() {
        AppiumService.stop();
    }
}