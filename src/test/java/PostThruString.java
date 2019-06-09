import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

import static io.restassured.RestAssured.given;

public class PostThruString {

    String baseURL = "http://localhost:3000";

    @Test
    public void getBDDStyle() throws IOException {

        RestAssured.baseURI = baseURL;

       Response response = given()
                .header("content-type" , "application/json")
                .and()
                .body(  "{ " +
                        "\"id\": 67," +
                "\"title\": \"json-server67\"," +
                "\"author\": \"typicode67\" " +
                     "}")
        .when()
                .post("/posts")
        .then()
                .statusCode(201)
                .and()
                .log().all().extract().response();
        JsonPath jsxpath = new JsonPath(response.asString());
        System.out.println(jsxpath.get("id"));
    }
}
