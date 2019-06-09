import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Random;

import static io.restassured.RestAssured.given;

public class PostThruJavaClassesResponseValidation {

    String baseURL = "http://localhost:3000";


    @Test
    public void getBDDStyle() throws IOException {

        RestAssured.baseURI = baseURL;

        JsonInputData jid = new JsonInputData(1,"Mr", "Patel");
        JsonReceiveData jrd = new JsonReceiveData();
        Gson gson = new GsonBuilder().create();

        Response res = given()
                .header("content-type", "application/json")
                .and()
                .body(jid)
                .when()
                .post("/posts")
                .then()
                .statusCode(201)
                .and()
                .log().all().extract().response();
        jrd = gson.fromJson(res.prettyPrint(),jrd.getClass());

        Assert.assertEquals(jid.getId(),jrd.getId());
    }
}
