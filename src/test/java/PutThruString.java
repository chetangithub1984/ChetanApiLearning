import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class PutThruString {

    String baseURL = "http://localhost:3000";

    @Test
    public void getBDDStyle() throws IOException {

        RestAssured.baseURI = baseURL;

       Response response = given()
                .header("content-type" , "application/json")
                .and()
                .body(  "{ " +
                        "\"id\": 128," +
                "\"title\": \"json-server_updated\"," +
                "\"author\": \"typicode_updated\" " +
                     "}")
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
