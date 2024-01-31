package Day3;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class HeadersDemo {

        //@Test(priority = 1)
        void testCookies(){
            given()

                    .when()
                    .get("https://www.google.com")

                    .then()
                    .cookie("AEC","Ae3NU9Ni7YqrINey4mBS_HM-YjPxcmiceBESc_8dEFXjc6VkFEUB5XpYxJY")
                    // if the test is failed that means the cookie is generated sucessfully
                    .log().all();

        }

}
