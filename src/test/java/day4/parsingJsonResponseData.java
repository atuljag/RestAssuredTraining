package day4;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class parsingJsonResponseData {

    @Test
    void testJsonResponse() {
//Approach 1
        given()

                .when()
                .get("https://dummyjson.com/carts")

                .then()
                .body("carts[11].products[1].title", equalTo("Marni Red & Black Suit"))
                .body("carts[11].products[1].total", equalTo(899.95F));


        //Approach 2

        Response res = given()

                .when()
                .get("https://dummyjson.com/carts");

        Assert.assertEquals(res.statusCode(), 200);
        String val = res.jsonPath().get("carts[11].products[1].title").toString();
        Assert.assertEquals(val, "Marni Red & Black Suit");
        String total = res.jsonPath().get("carts[11].products[1].total").toString();
        Assert.assertEquals(Double.parseDouble(total), 899.95);

    }
}
