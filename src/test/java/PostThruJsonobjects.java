
import io.restassured.RestAssured;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.Random;

import static io.restassured.RestAssured.given;

public class PostThruJsonobjects {

    String baseURL = "http://localhost:3000";

    @Test
    public void getBDDStyle() {

        RestAssured.baseURI = baseURL;
        Random rand = new Random();
        int randnumber = rand.nextInt(1000);
        JSONObject json = new JSONObject();
        json.put("id", randnumber);
        json.put("title", "json-server" + randnumber);
        json.put("author", "typicode" + randnumber);

        given()
                .header("content-type" , "application/json")
                .and()
                .body(json.toString())
        .when()
                .post("/posts")
        .then()
                 .statusCode(201)
                 .and()
                 .log().all();
    }
}
