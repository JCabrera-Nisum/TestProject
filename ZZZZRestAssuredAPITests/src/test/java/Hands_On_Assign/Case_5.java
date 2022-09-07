package Hands_On_Assign;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Case_5 {
  @Test
  public void patchMethod() {
	  
	  
	  RestAssured
		.given()
			.body("{\"name\": \"deleteme-patched-example-test\"}")
		.when()
			.patch("https://reqres.in/api/users/deleteme")
		.then()
			.statusCode(200);
  }
}
