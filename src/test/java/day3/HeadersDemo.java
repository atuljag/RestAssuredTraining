package day3;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class HeadersDemo {

    @Test
    void testHeader() {

        given()

                .when()
                .get("https://www.google.com")

                .then()
                .log().status()
                .header("X-Frame-Options", "SAMEORIGIN")
                .and()
                .header("Server", "gws");
    }

    @Test
    void GetHeaderInfo() {

        Response res = given()

                .when()
                .get("https://www.google.com");

// get single header value
//        String header_value = res.getHeader("Server");
//        System.out.println("Value of header ====> " +header_value);

        //get multiple header values

        Headers header_values = res.getHeaders();
        for (Header K : header_values) {
            System.out.println(K.getName() + "    " + K.getValue());

        }


    }
}
