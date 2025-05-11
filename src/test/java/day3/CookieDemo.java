package day3;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CookieDemo {

    @Test
    void testCookie() {

        given()

                .when()
                .get("https://www.google.com")

                .then()
                .statusCode(200)
                .log().cookies();


    }

    @Test
    void getCookiesInfo() {

        Response res = given()

                .when()
                .get("https://www.google.com");

//get single cookie value
//    String cookie_value = res.getCookie("AEC");
//    System.out.println("Value of cookie is ===> " + cookie_value);

        //get all cookies value

        Map<String, String> cookie_values = res.getCookies();
        for (String k : cookie_values.keySet()) {

            System.out.println(k + "     " + cookie_values);

        }


    }
}
