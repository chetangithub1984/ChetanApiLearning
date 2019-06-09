import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static io.restassured.RestAssured.given;

public class PutThruFile {

    String baseURL = "http://localhost:3000";

    @Test
    public void getBDDStyle() throws IOException {

        RestAssured.baseURI = baseURL;

        FileInputStream fis = new FileInputStream(new File("E:\\Learning\\GitHub Repo\\IntelliJ\\RestApi\\src\\main\\resources\\JsonInput.json"));

       Response response = given()
                .header("content-type" , "application/json")
                .and()
                .body(IOUtils.toString(fis,"UTF-8"))
        .when()
                .put("/posts/128")
        .then()
                .statusCode(200)
                .and()
                .log().all().extract().response();
        JsonPath jsxpath = new JsonPath(response.asString());
        System.out.println(jsxpath.get("id"));
    }
}
