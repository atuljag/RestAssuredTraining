package day2;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;

public class DiffWaysToCreatePostRequestBody {

	// 1. Post request body using hashmap
	@Test
	void CreateUserByHashmap() {

		HashMap data = new HashMap();
		data.put("name", "Atul");
		data.put("job", "Engineer");

		given().contentType("application/json").body(data)

				.when().post("https://reqres.in/api/users")

				.then().statusCode(201).body("name", equalTo("Atul")).log().all();

	}

}
