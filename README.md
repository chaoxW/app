# Appium2-Cucumber

This project is an automation framework using Appium, Cucumber, and Java. It supports both Android and iOS platforms and follows the Page Object Model (POM) design pattern. The project is configured to run UI automation tests for mobile applications.

---

## Project Structure

The following is the breakdown of the project structure:

```
appium2-cucumber
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── drivers
│   │   │   │   └── Drivers.java  # Contains driver setup for Android and iOS
│   │   │   ├── pages
│   │   │   │   ├── android       # Page Object Model classes for Android
│   │   │   │   └── ios           # Page Object Model classes for iOS
│   │   │   ├── properties
│   │   │   │   └── DriversProperties.java # Handles driver properties
│   │   │   └── utils             # Utility classes used across the framework
│   ├── resources
│   │   ├── app                   # Additional resources like APK or app files
│   │   └── drivers.properties    # Properties file for driver configurations
│   ├── test
│   │   ├── java
│   │   │   └── net.spark.bonfire.test.steps # Step definitions for Cucumber tests
│   │   │       ├── android
│   │   │       │   ├── BaseSteps.java       # Base class for Android step definitions
│   │   │       │   ├── SignInSignUpSteps.java # Steps for sign in/up tests (Android)
│   │   │       ├── ios
│   │   │       │   ├── BaseSteps.java       # Base class for iOS step definitions
│   │   │       │   ├── SignInSignUpSteps.java # Steps for sign in/up tests (iOS)
│   │   │       └── runner                   # General test runner setup
│   │   │           ├── RunIOSTest.java      # Test runner for iOS
│   │   │           ├── RunAndroidTest.java  # Test runner for Android
│   ├── resources
│   │   └── features
│   │       ├── android
│   │       │   └── android_sign_in_sign_up.feature # Feature file for Android sign in/up tests
│   │       ├── ios
│   │       │   └── ios_sign_in_sign_up.feature     # Feature file for iOS sign in/up tests
├── pom.xml                      # Maven configuration and project dependencies
```

---

## How to Run the Tests

The project uses Maven as the build tool. Below are the commands to run specific tests:

### Run iOS Tests

To run the iOS-specific tests, use the following Maven command:

```bash
mvn clean test -Dtest=RunIOSTest
```

### Run Android Tests

To run the Android-specific tests, use the following Maven command:

```bash
mvn clean test -Dtest=RunAndroidTest
```

### Run All Tests

To execute both iOS and Android tests together, you can run:

```bash
mvn clean test
```

---

## Dependencies and Configuration

This project relies on the following tools and dependencies, managed via the `pom.xml` file:

- **Appium**: For mobile automation on Android and iOS.
- **Cucumber**: BDD (Behavior-Driven Development) framework.
- **Java**: Core programming language used in the project.
- **Maven**: Build automation tool to manage dependencies and run tests.
- **JUnit/TestNG**: Testing framework for running unit and integration tests.
- **Selenium WebDriver**: Provides a language binding for driving browsers.

Ensure that the following tools are properly installed and configured:

- **Appium**: Install Appium globally or locally.
- **Node.js and npm**: Required for Appium installation.
- **Xcode** (for iOS): Ensure Xcode is installed and configured correctly for iOS tests.
- **Android SDK**: Install and configure the Android SDK for Android tests.

---

## Additional Information

- **Driver Configuration**: The `drivers.properties` file contains platform-specific configurations for the Appium server, device capabilities, and other settings. Ensure this file is updated to match your test environment.
  
- **Page Object Model (POM)**: The project uses POM to maintain test readability and reusability by separating test logic from the page UI representation.
