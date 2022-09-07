package testRestAssured;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class FirstAPITest {

	public static void main(String[] args) {

		
		//RestAssured.baseURI = "https://reqres.in/api/users/2";  
		
		RestAssured.baseURI = "https://reqres.in/api/users?page=2";  
		
		
		
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response response = httpRequest.request(Method.GET, "https://reqres.in/api/users?page=2"); //writing link in the get method words the same way 
		
		Response response = httpRequest.request(Method.GET, "");
		
		
		System.out.println("Response Status Code Obtained is: " +response.getStatusLine()); 
		response.prettyPrint();			//this prints value automatically 
		
		//System.out.println("Response Content :" +response.prettyPrint()); 

	}

}
