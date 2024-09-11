package net.spark.bonfire.test.steps;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import pages.android.SignInSignUpPage;
import utils.services.AppiumService;

public class BaseSteps {

    SignInSignUpPage signInSignUpPage;

    @BeforeAll
    public static void startAppiumService() {
        AppiumService.start();
    }

    @AfterAll
    public static void tearDown() {
        AppiumService.stop();
    }
}
