package pages.ios;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.common.Utils;

public class SignUpPage extends BasePage {

    Utils utils = new Utils();
    private String localCountryCode;

    public SignUpPage(IOSDriver driver) {
        super(driver);
    }

    public void clickSideMenuBtSignUp() {
        try {
            getElementByAccessId("sideMenuBtSignUp").click();
            System.out.println("click side menu sing up");
        } catch (Exception e) {
            Assert.fail(logError("clickSideMenuSignUP", e));
        }
    }

    public void insertSignUpEmail(String email) {
        try {
            WebElement element;
            element = waitUntilElementVisibilityByXpath("//XCUIElementTypeTextField[1]");
            element.sendKeys(email);
            System.out.println("insert sign up email " + email);
        } catch (Exception e) {
            Assert.fail(logError("insertSignUpEmail", e));
        }
    }

    public void insertSignUpPassword(String pass) {
        try {
            WebElement element;
            element = getElementByXpath("//XCUIElementTypeSecureTextField");
            element.sendKeys(pass);
            System.out.println("insert sign up password " + pass);
        } catch (Exception e) {
            Assert.fail(logError("insertSignUpPassword", e));

        }
    }

    public void selectMobileCountry() {
        try {
            WebElement element;
            element = getElementByXpath("//XCUIElementTypeOther[5]");
            element.click();
            WebElement country = getElementByXpath("//XCUIElementTypeOther[8]/XCUIElementTypeStaticText[@*][1]");
            WebElement countryCode = getElementByXpath("//XCUIElementTypeOther[8]/XCUIElementTypeStaticText[@*][2]");
            localCountryCode = countryCode.getAttribute("name");
            System.out.println("select mobile country " + country.getAttribute("name"));
            country.click();
        } catch (Exception e) {
            Assert.fail(logError("selectMobileCountry", e));
        }
    }

    public void insertMobileNumber() {
        try {
            WebElement element;
            element = getElementByXpath("//XCUIElementTypeTextField[2]");
            String num;
            if (localCountryCode.length() == 5) {
                num = utils.fakePhoneNumber(7);
            } else if (localCountryCode.length() == 6) {
                num = utils.fakePhoneNumber(6);
            } else {
                num = utils.fakePhoneNumber(5);
            }
            element.sendKeys(num);
            System.out.println("insert sign up mobile number " + num);
            clickKeyboardDone();
        } catch (Exception e) {
            Assert.fail(logError("insertMobileNumber", e));
        }
    }

    public void selectPlan() {
        try {
            getElementByXpath("//XCUIElementTypeOther[9]").click();
            WebElement plan;
            plan = waitUntilElementVisibilityByXpath("//XCUIElementTypeOther[11]/XCUIElementTypeStaticText[@*]");
            System.out.println("select plan " + plan.getAttribute("name"));
            plan.click();
        } catch (Exception e) {
            Assert.fail(logError("selectPlan", e));
        }
    }

    public void clickNextButton() {
        try {
            WebElement nextButton = getElementByAccessId("Next");
            waitUntilClickable(nextButton);
            nextButton.click();
            System.out.println("click next button");
        } catch (Exception e) {
            Assert.fail(logError("clickNextButton", e));
        }
    }

    public void insertFirstName(String firstName) {
        try {
            WebElement element;
            element = getElementByXpath("//XCUIElementTypeTextField[1]");
            element.sendKeys(firstName);
            System.out.println("insert first name " + firstName);
        } catch (Exception e) {
            Assert.fail(logError("insertFirstName", e));
        }
    }

    public void insertLastName(String lastName) {
        try {
            WebElement element;
            element = getElementByXpath("//XCUIElementTypeTextField[2]");
            element.sendKeys(lastName);
            System.out.println("insert last name " + lastName);
        } catch (Exception e) {
            Assert.fail(logError("insertLastName", e));
        }
    }

    public void insertFakeStreet(String street) {
        try {
            WebElement element;
            element = waitUntilElementVisibilityByXpath("//XCUIElementTypeTextField[1]");
            element.sendKeys(street);
            System.out.println("insert street " + street);
        } catch (Exception e) {
            Assert.fail(logError("insertFakeStreet", e));
        }
    }

    public void insertFakeHouseNumber(String number) {
        try {
            WebElement element;
            element = getElementByXpath("//XCUIElementTypeTextField[2]");
            element.sendKeys(number);
            System.out.println("insert house number " + number);
        } catch (Exception e) {
            Assert.fail(logError("insertFakeHouseNumber", e));
        }
    }

    public void insertFakeZipCode(String code) {
        try {
            WebElement element;
            element = waitUntilElementVisibilityByXpath("//XCUIElementTypeTextField[3]");
            element.sendKeys(code);
            System.out.println("insert zip code " + code);
        } catch (Exception e) {
            Assert.fail(logError("insertFakeZipCode", e));
        }
    }

    public void insertFakeCity(String city) {
        try {
            WebElement element;
            element = getElementByXpath("//XCUIElementTypeTextField[4]");
            element.sendKeys(city);
            System.out.println("insert city " + city);
        } catch (Exception e) {
            Assert.fail(logError("insertFakeCity", e));
        }
    }

    public void selectBirthDate() {
        try {
            WebElement selectBirthdayDate;
            selectBirthdayDate = getElementByXpath("//XCUIElementTypeOther[4]");
            selectBirthdayDate.click();
            getElementByAccessId("Show year picker").click();
            WebElement birthdayYearWheel;
            birthdayYearWheel = getElementByXpath("//XCUIElementTypePickerWheel[2]");
            WebElement birthdayMonthWheel;
            birthdayMonthWheel = getElementByXpath("//XCUIElementTypePickerWheel[1]");
            scrollElement(birthdayYearWheel, "down");
            scrollElement(birthdayMonthWheel, "up");
            clickKeyboardDone();
            selectBirthdayDate = waitUntilElementVisibilityByXpath("//XCUIElementTypeOther[4]");
            String getBirthdayText = selectBirthdayDate.getText();
            System.out.println("select birth date " + getBirthdayText);
        } catch (Exception e) {
            Assert.fail(logError("selectBirthDate", e));
        }
    }

    public void selectAcceptTermsOfUse() {
        try {
            WebElement element;
            element = getElementByXpath("(//XCUIElementTypeStaticText[contains(@name, 'I hereby accept the terms and conditions')])[2]");
            System.out.println("select " + element.getAttribute("name"));
            element.click();
        } catch (Exception e) {
            Assert.fail(logError("selectAcceptTermsOfUse", e));
        }
    }

    public void selectCountry() {
        try {
            WebElement element;
            element = getElementByXpath("//XCUIElementTypeOther[7]");
            element.click();
            WebElement country = getElementByXpath("//XCUIElementTypeOther[9]//XCUIElementTypeStaticText[@*]");
            System.out.println("select country " + country.getAttribute("name"));
            country.click();
        } catch (Exception e) {
            Assert.fail(logError("selectCountry", e));
        }
    }

}
