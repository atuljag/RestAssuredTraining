package day3;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


// Will learn testNG assertion in this code

public class AssertionDemo {

    @Test
    void testAssert() {

        Response res = given()

                .when()
                .get("https://www.google.com/");
        Assert.assertEquals(res.getStatusCode(), 200);
    }


}
