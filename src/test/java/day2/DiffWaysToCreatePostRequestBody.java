package day2;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

public class DiffWaysToCreatePostRequestBody {

	// 1. Post request body using hashmap
	// @Test
	void CreateUserByHashmap() {

		HashMap data = new HashMap();
		data.put("name", "Atul");
		data.put("job", "Engineer");

		given().contentType("application/json").body(data)

				.when().post("https://reqres.in/api/users")

				.then().statusCode(201).body("name", equalTo("Atul")).log().all();

	}

	// 2. Post request body using org.json
	// @Test
	void CreateUserByUsingJSONLibrary() {

		JSONObject data = new JSONObject();
		data.put("name", "Atul");
		data.put("job", "Engineer");

		given().contentType("application/json").body(data.toString())

				.when().post("https://reqres.in/api/users")

				.then().statusCode(201).body("name", equalTo("Atul")).log().body();
	}

	// 3. Post request body using POJO
	// @Test
	void CreateUserUsingPOJO() {

		Pojo_PostRequest data = new Pojo_PostRequest();

		data.setName("Atul");
		data.setJob("Engineer");

		given().contentType("application/json").body(data)

				.when().post("https://reqres.in/api/users")

				.then().statusCode(201).body("name", equalTo("Atul")).log().body();
	}

	// 4. Post request body using external json file
	@Test
	void CreateUserUsingExternalJSONFile() throws FileNotFoundException {

		File f = new File(".//body.json");
		FileReader fr = new FileReader(f);
		JSONTokener jt = new JSONTokener(fr);
		JSONObject data = new JSONObject(jt);

		given().contentType("application/json").body(data.toString())

				.when().post("https://reqres.in/api/users")

				.then().statusCode(201).body("name", equalTo("Atul")).log().body();
	}

}
