package api.social.networ.api.tests;

import api.base.BaseTestSetup;
import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import org.junit.jupiter.api.BeforeEach;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import static apiSocialNetwork.Constants.*;
import static apiSocialNetwork.Endpoints.*;
import static apiSocialNetwork.JSONRequests.POST_BODY;
import static io.restassured.RestAssured.baseURI;
import static java.lang.String.format;
import static java.util.Objects.isNull;
import static org.apache.http.HttpStatus.SC_OK;
import static org.testng.Assert.assertEquals;


public class CreatePost extends BaseTestSetup {
    @BeforeClass
    public void cookieSetup() {
        if (isNull(COOKIE_VALUE)) {
            AuthenticateUser auth = new AuthenticateUser();
            auth._02_authenticateAndFetchCookies();
        }
    }

    @Test
    public static void _02_createPost(){

        Response response = RestAssured
                .given()
                .header("Content-Type","application/json")
                .header("Accept","*/*")
                .cookie("JSESSIONID",COOKIE_VALUE)
                .body(POST_BODY)
                .when()
                .log()
                .all()
                .post("http://localhost:8081/api/post/auth/creator");

        int statusCode = response.getStatusCode();
        assertEquals(statusCode, SC_OK, format("Incorrect status code. Expected %s.", SC_OK));
        System.out.println("Post was created successfully!");

    }
    //GET ALL POSTS REQ
    @Test
    public void getAllPosts_Successful() {

        baseURI = BASE_URL + GET_ALL_POSTS_ENDPOINT;

        Response response = RestAssured.given()
                .queryParam("sorted", "true")
                .queryParam("unsorted", "false")
                .when()
                .get(baseURI);

        System.out.println(response.asString());

        int statusCode = response.getStatusCode();
        assertEquals(statusCode, SC_OK, format("Incorrect status code. Expected %s.", SC_OK));

        System.out.println("Successfully fetched all posts.");
    }

}


