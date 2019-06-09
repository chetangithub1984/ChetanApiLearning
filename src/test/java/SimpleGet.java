import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleGet {


    @Test
    public void getmtd() {

        Response response = RestAssured.get("http://localhost:3000/posts");
        int code = response.getStatusCode();
        Assert.assertEquals(200,code);
        System.out.println(response.asString());


    }
}
