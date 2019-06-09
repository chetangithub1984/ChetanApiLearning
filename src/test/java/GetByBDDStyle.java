import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetByBDDStyle {

    @Test
    public void getBDDStyle () {


      given()
      .get("http://localhost:3000/posts/234")
          .then()
              .statusCode(200).log().all().extract().response();

    }
}
