package Hands_On_Assign;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Case_3 {
  @Test
  public void deleteMethod() {
	  RestAssured
	  			.when()
	  				.delete("https://reqres.in/api/users/2")
	  			.then()
	  				.statusCode(204);
  }
}
