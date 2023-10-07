package api.social.networ.api.tests;

import api.base.BaseTestSetup;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.testng.Assert;
import org.testng.annotations.Test;
import static apisocialnetwork.Endpoints.*;
import static io.restassured.RestAssured.baseURI;
import static java.util.Objects.isNull;


public class AuthenticateUser extends BaseTestSetup {

    @BeforeAll
    public void setupAuthentication() {
        if (isNull(USER_ID)) {
            RegistrationTest registerUser = new RegistrationTest();
            registerUser.registerUser_Successful();
        }
    }
    @Test
    public void _02_authenticateAndFetchCookies() {
        baseURI = BASE_URL;

        System.out.println("Using Username: " + USERNAME);
        System.out.println("Using Password: " + PASSWORD);

        ValidatableResponse responseBody = RestAssured
                .given()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .queryParam("username", USERNAME)
                .queryParam("password", PASSWORD)
                .when()
                .post(AUTHENTICATE_ENDPOINT)
                .then()
                .assertThat()
                .statusCode(302);


        int statusCode = responseBody.extract().statusCode();
        String CookieValue = responseBody.extract().cookies().get("JSESSIONID");

        COOKIE_VALUE=CookieValue;

        Assert.assertFalse(CookieValue.isEmpty(), "Cookie value is not present");
     //   assertEquals(CookieValue.isEmpty(), );
        System.out.println("Cookie value is: " + CookieValue);
        System.out.println("Status code is: " + statusCode);

    }
}



