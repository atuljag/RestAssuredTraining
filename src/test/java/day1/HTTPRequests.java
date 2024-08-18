package day1;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class HTTPRequests {

	int id;

	@Test(priority = 1)
	void getUsers() {

		given()

				.when()

				.get("https://reqres.in/api/users?page=2")

				.then()

				.statusCode(200).body("page", equalTo(2)).log().all();
	}

	@Test(priority = 2)
	void ctreateUser() {
		HashMap data = new HashMap();
		data.put("name", "Atul");
		data.put("job", "Engineer");

		id = given().contentType("application/json").body(data)

				.when().post("https://reqres.in/api/users").jsonPath().getInt("id");

//		.then()
//		.statusCode(201)
//		.body("name", equalTo("Atul"))
//		.log().all();
	}

	@Test(priority = 3)
	void updateUser() {

		HashMap data = new HashMap();
		data.put("name", "Atul Jagtap");
		data.put("job", "Test Engineer");

		given().contentType("application/json").body(data)

				.when().put("https://reqres.in/api/users/" + id)

				.then().statusCode(200).body("name", equalTo("Atul Jagtap")).log().all();

	}

	@Test(priority = 4)
	void deleteUser() {

		when().delete("https://reqres.in/api/users/" + id)

				.then().statusCode(204);
	}

}
