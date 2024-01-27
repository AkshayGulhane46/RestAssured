package Day2;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;
public class DifferentWaysToCreatePostRequestBody {

    // Post Request body usign HashMap
    //@Test(priority = 1)
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

    //Post a content using json.org
    //@Test(priority = 1)
    public void testPostUsingJsonLibrary(){
        JSONObject data = new JSONObject();
        data.put("name","Akshay");
        data.put("gender","male");
        data.put("Physics",34);

        String optSubjects[] = {"C","C++"};

        data.put("optSubjects",optSubjects);

        given()
                .contentType("application/json")
                .body(data.toString())// data should be in String format here
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

    //Post a content using POJO classes
    //@Test(priority = 1)
    public void testPostUsingPOJOClass(){
        // Create objecct of a POJO class
        Pojo_PostRequest data = new Pojo_PostRequest();
        data.setName("Vaibhav");
        data.setGender("Male");
        data.setEnglish("23");
        data.setPhysics("22");
        data.setMaths("23");

        String courses[] = {"C","C++"};
        data.setOptSubjects(courses);

        given()
                .contentType("application/json")
                .body(data)
                .when()
                .post("http://localhost:8080/students")
                .then()
                .statusCode(201)
                .body("name",equalTo("Vaibhav"))
                .body("gender",equalTo("Male"))
                .body("optSubjects[0]",equalTo("C"))
                .body("optSubjects[1]",equalTo("C++"))
                .header("Content-Type","application/json")
                .log().all()
        ;
    }

    //Post a content using External JSON file
    @Test(priority = 1)
    public void testPostUsingExternalFile() throws FileNotFoundException {

        File f = new File(".\\body.json"); // open file
        FileReader fr = new FileReader(f);  // read the file
        JSONTokener jt = new JSONTokener(fr); // sent to JSONTokener
        JSONObject data = new JSONObject(jt); // sent the tokener output to data



        given()
                .contentType("application/json")
                .body(data.toString())// data should be converted to string before sending
                .when()
                .post("http://localhost:8080/students")
                .then()
                .statusCode(201)
                .body("name",equalTo("Akshay"))
                .body("gender",equalTo("Male"))
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
                .delete("http://localhost:8080/students/71e2")
                .then()
                .statusCode(200);
    }


}
