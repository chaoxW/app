package utils.common;

import com.github.javafaker.CreditCardType;
import com.github.javafaker.Faker;
import drivers.Drivers;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Utils implements Drivers {
    Faker faker = new Faker();

    public String createUsername() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return "qa+" + timestamp.getTime() + "@bdate.com";
    }

    public String randomNumber(int min, int max) {
        int random_int = (int) Math.floor(Math.random() * (max - min + 1) + min);
        return String.valueOf(random_int);
    }

    public String fakeFirstName() {
        return faker.name().firstName();
    }

    public String fakeLastName() {
        return faker.name().lastName();
    }

    public String fakeStreet() {
        return faker.address().streetName();
    }

    public String fakeHouseNumber() {
        return faker.address().streetAddressNumber();
    }

    public String fakeZipCode() {
        return faker.address().zipCode();
    }

    public String fakeCity() {
        return faker.address().city();
    }

    public String fakeCreditCard() {
        return faker.finance().creditCard(CreditCardType.MASTERCARD);
    }

    public String fakePassword() {
        return faker.internet().password(8, 15, true, true, true);
    }

    public String fakePhoneNumber(int num) {
        return "33" + faker.number().randomNumber(num, true);
    }

    public String fakeCreditCardValidUtil() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        final SimpleDateFormat yearFormatter = new SimpleDateFormat("yyyy");
        Integer futureYear = Integer.valueOf(yearFormatter.format(timestamp)) + 3;
        String randomMonthNUmber = randomNumber(1, 12);
        randomMonthNUmber = String.format("%2s", randomMonthNUmber).replace(' ', '0');
        String validMM = randomMonthNUmber;
        String validYY = String.valueOf(futureYear).substring(2, 4);
        return validMM + validYY;
    }

    public String fakeCreditCardSecurityCode() {
        return randomNumber(111, 999);
    }

    public String logError(String elementName, Exception e) {
        String errorCause = elementName + " ERROR cause is " + e.getCause();
        String errorMsm = elementName + " ERROR reason is " + e.getMessage();
        String[] errors = {errorCause, errorMsm};
        String error = String.join("\n", errors);
        System.out.println(error);
        return error;
    }
}
