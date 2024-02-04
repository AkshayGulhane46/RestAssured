package Day3;
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
public class CookiesDemo {

    //@Test(priority = 1)
    void testCookies(){
        System.out.println("Cookies Demo Started");
        given()

                .when()
                .get("https://www.google.com")

                .then()
                .cookie("AEC","Ae3NU9Ni7YqrINey4mBS_HM-YjPxcmiceBESc_8dEFXjc6VkFEUB5XpYxJY")
                // if the test is failed that means the cookie is generated sucessfully
                .log().all();

    }

    @Test(priority = 2)
    void getCookiesInfo(){

        Response res = given()
                .when()
                .get("https://www.google.com");
        // as we are having any validation we are not writin then
        // get single cookie ingo
        String cookie_value = res.getCookie("AEC");
        System.out.println("Value of cookie is **** " + cookie_value);
        // get all cookies info
        Map<String,String> cookies = res.getCookies();
        //System.out.println(cookies.keySet());

        for(String k:cookies.keySet()){
            String cookie_value_in_loop = res.getCookie(k);
            System.out.println(k+" = "+cookie_value_in_loop);
        }

    }

}
