package pages.android;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.common.Utils;

public class SignUpPage extends BasePage {

    Utils utils = new Utils();
    private String localCountryCode;
    private String localCountry;

    public SignUpPage(AndroidDriver driver) {
        super(driver);
    }


    public void insertSignUpEmail(String email) {
        try {
            WebElement element;
            waitUntilElementVisibilityByXpath("//android.widget.EditText[@resource-id='email']");
            element = getElementByXpath("//android.widget.EditText[@resource-id='email']");
            element.sendKeys(email);
            System.out.println("insert sign up email " + email);
        } catch (Exception exp) {
            Assert.fail("insert sign up email ERROR");
        }
    }

    public void insertSignUpPassword(String pass) {
        try {
            WebElement element;
            element = getElementByXpath("//android.widget.EditText[@resource-id='password']");
            element.sendKeys(pass);
            System.out.println("insert sign up password " + pass);
        } catch (Exception exp) {
            Assert.fail("insert sign up password ERROR");

        }
    }

    public void insertMobileNumber() {
        try {
            WebElement element;
            element = getElementByXpath("//android.widget.EditText[@resource-id='mobilePhoneInput']");
            String phoneNumber = utils.fakePhoneNumber(8);
            element.sendKeys(phoneNumber);
            System.out.println("insert sign up mobile number " + phoneNumber);
        } catch (Exception exp) {
            Assert.fail("insert sign up mobile number ERROR");
        }
    }

    public void selectMobileCountry() {
        try {
            WebElement element;
            element = getElementByXpath("//android.widget.Image[@text='wo']");
            element.click();
            String countryXpath = "//android.view.View[7]/android.view.View[9]/android.view.View/android.widget.TextView";
            waitUntilElementVisibilityByXpath("//android.view.View[7][@resource-id='wf-full-screen-selection-list-countryCode']");
            WebElement country = getElementByXpath(countryXpath + "[1]");
            WebElement countryCode = getElementByXpath(countryXpath + "[2]");
            localCountryCode = countryCode.getAttribute("text");
            localCountry = country.getAttribute("text");
            System.out.println("select mobile country " + country.getAttribute("text") + " mobile country code is " + localCountryCode);
            country.click();
        } catch (Exception exp) {
            Assert.fail("select mobile country ERROR");
        }
    }

    public void selectPlan() {
        try {
            getElementByXpath("//android.view.View[11]/android.view.View/android.view.View").click();
            waitUntilElementVisibilityByXpath("//android.view.View[12]/android.view.View[2]/android.view.View");
            WebElement plan = getElementByXpath("//android.view.View[12]/android.view.View[2]/android.view.View");
            System.out.println("select " + plan.getAttribute("text"));
            plan.click();
        } catch (Exception exp) {
            Assert.fail("select plan ERROR");
        }
    }

    public void clickNextButton() {
        try {
            getElementByXpath("//android.widget.Button[@text='Next']").click();
            System.out.println("click next button");
        } catch (Exception exp) {
            Assert.fail("click next button ERROR");
        }
    }

    public void insertFirstName(String firstName) {
        try {
            WebElement element;
            element = getElementByXpath("//android.widget.EditText[@resource-id='firstName']");
            element.sendKeys(firstName);
            System.out.println("insert first name " + firstName);
        } catch (Exception exp) {
            Assert.fail("insert firstName ERROR");
        }
    }

    public void insertLastName(String lastName) {
        try {
            WebElement element;
            element = getElementByXpath("//android.widget.EditText[@resource-id='lastName']");
            element.sendKeys(lastName);
            System.out.println("insert last name " + lastName);
        } catch (Exception exp) {
            Assert.fail("insert lastName ERROR");
        }
    }

    public void selectBirthDate() {
        try {
            WebElement selectBirthdayDate;
            selectBirthdayDate = getElementByXpath("//android.widget.Spinner[@resource-id='birthDate']");
            selectBirthdayDate.click();
            waitUntilElementVisibilityById("android:id/date_picker_header_year").click();
            scrollToElementByText("2018");
            scrollToElementByText("2013");
            scrollToElementByText("2006");
            scrollToElementByText("2000");
            getElementByXpath("//android.widget.TextView[@text='1999']").click();
            WebElement setButton;
            setButton = getElementById("android:id/button1");
            setButton.click();
            waitUntilElementVisibilityByXpath("//android.widget.Spinner[@resource-id='birthDate']");
            String getBirthdayText = getElementByXpath("//android.widget.Spinner[@resource-id='birthDate']").getText();
            System.out.println("select birth date " + getBirthdayText);
        } catch (Exception exp) {
            Assert.fail("select birth date ERROR");
            System.out.println("\nselect birth date ERROR " + exp.getCause());
            System.out.println("\nselect birth date ERROR " + exp.getMessage());
            Assert.fail("select birth date ERROR");
        }
    }

    public void selectAcceptTermsOfUse() {
        try {
            WebElement element;
            element = getElementByXpath("//android.widget.CheckBox[@resource-id='termsOfUseAccept']");
            element.click();
            System.out.println("select " + element.getAttribute("text"));
        } catch (Exception exp) {
            Assert.fail("select accept terms of use ERROR");
        }
    }

    public void insertFakeStreet(String street) {
        try {
            WebElement element;
            String streetXpath = "//android.widget.EditText[@resource-id='street']";
            waitUntilElementVisibilityByXpath(streetXpath);
            element = getElementByXpath(streetXpath);
            element.sendKeys(street);
            System.out.println("insert street " + street);
        } catch (Exception exp) {
            Assert.fail("insert street ERROR");
        }
    }

    public void insertFakeHouseNumber(String number) {
        try {
            WebElement element;
            element = getElementByXpath("//android.widget.EditText[@resource-id='houseNumber']");
            element.sendKeys(number);
            System.out.println("insert house number " + number);
        } catch (Exception exp) {
            Assert.fail("insert house number ERROR");
        }
    }

    public void insertFakeZipCode(String code) {
        try {
            WebElement element;
            element = getElementByXpath("//android.widget.EditText[@resource-id='zipCode']");
            element.sendKeys(code);
            System.out.println("insert zip code " + code);
        } catch (Exception exp) {
            Assert.fail("insert zip code ERROR");
        }
    }

    public void insertFakeCity(String city) {
        try {
            WebElement element;
            element = getElementByXpath("//android.widget.EditText[@resource-id='city']");
            element.sendKeys(city);
            System.out.println("insert city " + city);
        } catch (Exception exp) {
            Assert.fail("insert city ERROR");
        }
    }

    public void selectCountry() {
        try {
            WebElement element;
            element = getElementByXpath("//android.view.View[@resource-id='ng-select-country']");
            element.click();
            WebElement country = getElementByXpath("//android.view.View[9]/android.view.View[2]/android.view.View/android.widget.TextView");
            System.out.println("select country " + country.getAttribute("text"));
            country.click();
        } catch (Exception exp) {
            Assert.fail("select country ERROR");
        }
    }

}
