package Hands_On_Assign;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class Case_1 {
  @Test
  public void getMethod() {
	  
		RestAssured.baseURI = "https://reqres.in/api/users/2";  
		
		RequestSpecification httpRequest = RestAssured.given();
		
		Response response = httpRequest.request(Method.GET, "https://reqres.in/api/users?page=2");

		
		int statusCode = response.getStatusCode();
		
		Assert.assertEquals(statusCode, 200);
		
		System.out.println("Response Status Code: " +response.getStatusLine()); 


  }
 

}
