package testRestAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ResponseHeaders {

		  @Test (enabled = false) //putting this ignores this and runs the test under
		  public void test1() {
			  
				RestAssured.baseURI = "https://reqres.in/api/users/2";  
		  
					
				
				RequestSpecification httpRequest = RestAssured.given();
				
				
				Response response = httpRequest.request(Method.GET, "");
				
				
				Headers allHeaders = response.getHeaders();
				for(Header header : allHeaders) { 
					System.out.println("Key: " +header.getName() + " Value: " +header.getValue()); 	//gets all headers with the key value 
				}
				
				
						
				//Assert.assertEquals(statusCode, 200);	
			  
//				System.out.println("Response Status Code Obtained is: " +response.getStatusLine()); 
//				String statusLine = response.getStatusLine();
//				Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
				
				//response.prettyPrint();			
				

		  }
		  
		  
		  @Test 
		  public void test2() {			//test validates the response headers//
			  
				RestAssured.baseURI = "https://reqres.in/api/users/2";  
				
				RequestSpecification httpRequest = RestAssured.given();
				
				Response response = httpRequest.request(Method.GET, "");
		  
				String contentType = response.header("Content-Type"); 	//this gets the value another way 
				System.out.println("The Content-Type value is: " +contentType);
				
				String DateValue = response.header("DateValue"); 	
				System.out.println("The DateValue - value is: " +DateValue);
				
				String Connection = response.header("Connection"); 	
				System.out.println("The Connection value is: " +Connection);
				
				//gets headers individually directly - this is only possible when you know the header names already 
			
		  }
		  
		  
		}

