package Hands_On_Assign;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Case_2 {
	
  @Test
  public void postMethod() {
	  RestAssured
	  			.given()
	  				.body("{\"name\": \"example-test\""
	  						+ "\"job\": \"leader\"}")
	  			.when()
	  				.post("https://reqres.in/api/users")
	  			.then()
	  				.statusCode(201);
	  
  }
}
