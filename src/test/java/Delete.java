import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class Delete {

    private String baseURL = "http://localhost:3000";

    @Test
    public void getBDDStyle() throws IOException {

        RestAssured.baseURI = baseURL;

        given()
                .header("Content-Type" , "application/json")
        .when()
                .delete("/posts/67")
        .then()
                .statusCode(200)
                .and()
                .log().all();

    }
}
