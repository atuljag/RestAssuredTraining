package day3;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PathAndQueryParameter {

    @Test
    void testPathAndQueryParam() {

        given()
                .header("x-api-key", "reqres-free-v1")
                .pathParams("myPath", "users")
                .queryParam("page", 2)
                .queryParam("id", 8)

                .when()
                .get("https://reqres.in/api/{myPath}")

                .then()
                .statusCode(200)
                .log().body();

    }
}
