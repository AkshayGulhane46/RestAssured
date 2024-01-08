package Day1;
import org.testng.annotations.Test;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

/*
GHERKIN KEYWORDS
* given()
* whenever you are sending a API requests there should be some preRequisites should be set
* contentType , cookies, add auth, add Params, set headers info etc...
*
* when()
* get, post, put, delete
*
* then()
* validate status code, extract Responce, extract Header Cookies, response body etc
* */



public class httpRequest {
    // BDD style we need to follow
    // Gherkin Language which uses keywords like Given etc
    // Rest Assured supports BDD style

    @Test
    // test method
    void getUser(){
        given()
         .when()
            .then();
    }

    private void then() {
    }


}
