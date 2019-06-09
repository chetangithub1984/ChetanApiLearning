import io.restassured.RestAssured;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

import static io.restassured.RestAssured.given;

public class PostThruJavaClasses {

    String baseURL = "http://localhost:3000";


    @Test
    public void getBDDStyle() throws IOException {

        RestAssured.baseURI = baseURL;

        JsonInputData jid = new JsonInputData(129,"Mr", "Chetan");

        given()
                .header("content-type", "application/json")
                .and()
                .body(jid)
                .when()
                .post("/posts")
                .then()
                .statusCode(201)
                .and()
                .log().all();
    }
}
