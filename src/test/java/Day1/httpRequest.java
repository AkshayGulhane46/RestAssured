package Day1;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

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
    int id;
    @Test
    // test method
    void getUser(){
        // currently as we dont have any prequisites given () is optionsal
        given()
        .when()
            .get("https://reqres.in/api/users?page=2")
                .then()
                    .statusCode(200)
                    .body("page",equalTo(2))
                    .log().all();
    }
    @Test(priority = 1)
    void createUser(){
        HashMap data = new HashMap();
        data.put("name","Akshhay");
        data.put("Job","QA");

        id = given()
                .contentType("application/json")
                .body(data)

                .when()
                .post("https://reqres.in/api/users")
//                .then()
//                .statusCode(201)
//                .log().all()
                .jsonPath().getInt("id");
        // we are getting ID of the created record

    }

    @Test(priority = 2)
    public void updateUser(){
        given()
                .when()
                .then();

    }



}
