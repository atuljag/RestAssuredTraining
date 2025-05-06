package day3;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class PathAndQueryParameters {

    // https://reqres.in/api/users?page=2&id=8

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
