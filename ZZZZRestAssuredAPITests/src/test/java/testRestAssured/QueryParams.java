package testRestAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyExtractionOptions;
import io.restassured.specification.RequestSpecification;

public class QueryParams {

	  @Test //(enabled = false)
	  public void test1() {    
		  
		  	//RestAssured.baseURI = "https://reqres.in/api/users?page=2";  
		  
		  	RestAssured.baseURI = "https://api.nasa.gov/neo/rest/v1/feed"; //?start_date=START_DATE&end_date=END_DATE&api_key=API_KEY";  

						
			RequestSpecification httpRequest = RestAssured.given();
			
			httpRequest.queryParam("start_date", "2015-09-07");
			
			httpRequest.queryParam("end_date", "2015-09-08");
			
			httpRequest.queryParam("api_key", "DEMO_KEY");
		
			Response response = httpRequest.request(Method.GET, "");
			
			
			
			ResponseBodyExtractionOptions responseBody = response.getBody();
			
			//System.out.println(responseBody.asPrettyString());		
			
			System.out.println(responseBody.asString());
			
			
			
			JsonPath jsonPath = response.jsonPath();			//in the body we are trying to extract a specific value 
			
			System.out.println(jsonPath.get("links"));					//https://jsonpath.com/   was used 
			
			//System.out.println("The email id for the second object in the list = " +jsonPath.get("data[1].email")); 
			
			
			
			//System.out.println(response.body().asPrettyString());		
			//System.out.println(response.getBody());
			


	  }
	  
}
