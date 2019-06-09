
import io.restassured.RestAssured;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

import static io.restassured.RestAssured.given;

public class PostThruJsonFile {

    String baseURL = "http://localhost:3000";

    @Test
    public void getBDDStyle() throws IOException {

        RestAssured.baseURI = baseURL;

        FileInputStream fis = new FileInputStream(new File("E:\\Learning\\GitHub Repo\\IntelliJ\\RestApi\\src\\main\\resources\\JsonInput.json"));

        given()
                .header("content-type" , "application/json")
                .and()
                .body(IOUtils.toString(fis,"UTF-8"))
        .when()
                .post("/posts")
        .then()
                 .statusCode(201)
                 .and()
                 .log().all();
    }
}
