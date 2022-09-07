package testRestAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ResponseTest1 {
  @Test
  public void test1() {
	  
		RestAssured.baseURI = "https://reqres.in/api/users/2";  
  
	  
	  	//RestAssured.baseURI = "https://reqres.in/api/users?page=2";  
			
		
		RequestSpecification httpRequest = RestAssured.given();
		
		
		Response response = httpRequest.request(Method.GET, "https://reqres.in/api/users?page=2"); //writing link in the get method works the same way 
//		Response response = httpRequest.request(Method.GET, "");
		
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);	//we can try 204| what we get is failure ran 
	  
		System.out.println("Response Status Code Obtained is: " +response.getStatusLine()); 
		String statusLine = response.getStatusLine();
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
		//response.prettyPrint();			
		

//validated status code and status line here

  }
  
  
  
  
}
