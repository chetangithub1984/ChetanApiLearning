import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestLogSpecification;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class JsonSerializeDeserialize {

    String baseURL = "http://localhost:3000";


    @Test
    public void getBDDStyle() throws IOException {

        RestAssured.baseURI = baseURL;

        JsonPojo input = new JsonPojo();
        input.setAuthor("chetan");
        GsonBuilder builder = new GsonBuilder();
        builder.serializeNulls().setPrettyPrinting();
        Gson gson = builder.create();
        //Gson gson = new Gson();
        String classobjToJson = gson.toJson(input);

        System.out.println(classobjToJson);
        //System.out.println(JsontoClassObj.getAuthor());
        Response res = given().log().everything()
                .header("content-type", "application/json")
                .and()
                .body(input)
                .when()
                .post("/posts")
                .then()
                .statusCode(201)
                .and().log().all()
                .extract().response();
        JsonPojo JsontoClassObj =gson.fromJson(res.prettyPrint(),JsonPojo.class);
        System.out.println(JsontoClassObj);
        /*jrd = gson.fromJson(res.prettyPrint(),jrd.getClass());

        Assert.assertEquals(jid.getId(),jrd.getId());*/
    }
}
