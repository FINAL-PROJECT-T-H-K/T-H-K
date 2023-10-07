package api.base;

import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.config.EncoderConfig;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeSuite;

import java.util.Locale;

public class BaseTestSetup {
    public static String USER_ID;
    public static String COOKIE_VALUE;
    public static String USERNAME;
    public static String PASSWORD;
    public static String skillId;
    public static String uniqueName;

    @BeforeSuite
    public void setup() {
        EncoderConfig encoderConfig = RestAssured.config().getEncoderConfig()
                .appendDefaultContentCharsetToContentTypeIfUndefined(false);

        RestAssured.config = RestAssured.config().encoderConfig(encoderConfig);

        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("en-GB"), new RandomService());

        String randomUsername = fakeValuesService.bothify("Username?????");
        String randomPassword = fakeValuesService.bothify("Password?????");

        USERNAME = randomUsername;
        PASSWORD = randomPassword;

        uniqueName = RandomStringUtils.randomAlphabetic(10);
    }
//    public void authentication() {
//        PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
//        authScheme.setUserName(USERNAME);
//        authScheme.setPassword(PASSWORD);
//        RestAssured.authentication = authScheme;
//    }
}
