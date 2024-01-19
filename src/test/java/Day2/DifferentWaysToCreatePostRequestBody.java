package Day2;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;
public class DifferentWaysToCreatePostRequestBody {

    // Post Request body usign HashMap
    @Test(priority = 1)
    public void testPostUsingHashMap(){
        HashMap data = new HashMap();
        data.put("name","Akshay");
        data.put("gender","male");
        data.put("Physics",34);

        String optSubjects[] = {"C","C++"};

        data.put("optSubjects",optSubjects);

        given()
                .contentType("application/json")
                .body(data)
                .when()
                .post("http://localhost:8080/students")
                .then()
                .statusCode(201)
                .body("name",equalTo("Akshay"))
                .body("gender",equalTo("male"))
                .body("optSubjects[0]",equalTo("C"))
                .body("optSubjects[1]",equalTo("C++"))
                .header("Content-Type","application/json")
                .log().all()
        ;
    }
    // to Delete the record
    @Test(priority = 2)
    void testDelete(){
        given()
                .when()
                .delete("http://localhost:8080/students/ef07")
                .then()
                .statusCode(200);
    }
}
