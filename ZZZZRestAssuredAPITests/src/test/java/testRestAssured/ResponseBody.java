package testRestAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyExtractionOptions;
import io.restassured.specification.RequestSpecification;

public class ResponseBody {

	  @Test //(enabled = false)
	  public void test1() {  
		  
																			//RestAssured.baseURI = "https://reqres.in/api/users/2";  
	  
		  
		  	RestAssured.baseURI = "https://reqres.in/api/users?page=2";  
						
			RequestSpecification httpRequest = RestAssured.given();
					
			Response response = httpRequest.request(Method.GET, "");
			
			
			
			ResponseBodyExtractionOptions responseBody = response.getBody();
			//responseBody.asPrettyString();			//this or the below way works 
			
			System.out.println(responseBody.asPrettyString());		
			
			
			
			//System.out.println(response.body().asPrettyString());		//asPrettyString = JSON format | //asString = horizontal list 
			//System.out.println(response.getBody());


	  }
	  
	  
	  @Test
	  public void test2() {
		  
	  
		  
		  	RestAssured.baseURI = "https://reqres.in/api/users?page=2";  
						
			RequestSpecification httpRequest = RestAssured.given();
					
			Response response = httpRequest.request(Method.GET, "");
			
			
			
			JsonPath jsonPath = response.jsonPath();			//in the body we are trying to extract a specific value 
			
			System.out.println(jsonPath.get("data[0]"));					//https://jsonpath.com/   was used 
			
			System.out.println("The email id for the second object in the list = " +jsonPath.get("data[1].email")); 
			
			//ResponseBodyExtractionOptions responseBody = response.getBody();
			//responseBody.asPrettyString();			//this or the below way works 
			
			//System.out.println(responseBody.asPrettyString());
			
			
			//System.out.println(response.body().asPrettyString());		//asPrettyString = JSON format | //asString = horizontal list 
			//System.out.println(response.getBody());


	  }
	  
	  
}
