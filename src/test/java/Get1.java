import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Get1 {

    private String baseURL = "http://localhost:3000";

    public String getBaseURL() {
        return baseURL;
    }

    @Test
        public void getBDDStyle () {

            RestAssured.baseURI = getBaseURL();


            given()
                    .header("content-type" , "application/json")
            .when()
                .get("/posts/")
            .then()
                    .statusCode(200)
                    .log()
                    .all();
        }


    public void testName() {
        System.out.println("Hello World");
    }
}
