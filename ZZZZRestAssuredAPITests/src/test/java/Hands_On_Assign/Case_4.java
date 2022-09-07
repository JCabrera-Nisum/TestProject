package Hands_On_Assign;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Case_4 {
  @Test
  public void putMethod() {
	  
	  String put = "{\"id\":1,\"email\":\"joshua.cabrera@reqres.in\",\"first_name\":\"Joshua\",\"last_name\":\"Cabrera\",\"avatar\":\"https://reqres.in/img/faces/1-image.jpg\"}";
	  
	  
	  RestAssured
	  			.given()
	  				.body(put)
	  			.when()
	  				.put("https://reqres.in/api/users/1")
	  			.then()
	  				.statusCode(200);
  }
}
