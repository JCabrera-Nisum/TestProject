/* Date: 8/29/2022
 * TODO: For the POST request, Convert the payload content passed through the script into a json file. 
 * Read the json file and send the content as parameter
  */


package trainingOnRestAssured;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class PostMethodWithJSONFile {
  @Test
  public void postCreateJSONFileDSL() {
	  
	  JSONParser pars = new JSONParser();
	  
	  try {		  
		 JSONObject jo = (JSONObject) pars.parse(new FileReader("/Users/Joshua/Desktop/WORK/JSON_files/json_create_post.json"));
		 
		 System.out.println(jo.toString());
		 
		  RestAssured
			.given()
				.body(jo.toString())
			.when()
				.post("https://reqres.in/api/users")
			.then()
				.assertThat()
					.statusCode(201)
					.log()
						.body();
		  
	  }
	  catch(Exception e) {
		  e.printStackTrace();
	  }
	  
  }
  
  
  
  @Test
  public void postRegisterFailJSONFileDSL() {
	  JSONParser pars = new JSONParser();
	  
	  try {		  
		 JSONObject jo = (JSONObject) pars.parse(new FileReader("/Users/Joshua/Desktop/WORK/JSON_files/json_register_fail_post.json"));
		 
		 System.out.println(jo.toString());
		 
		  RestAssured
			.given()
				.body(jo.toString())
			.when()
				.post("https://reqres.in/api/register")
			.then()
				.assertThat()
					.statusCode(400)
					.log()
						.body();
		  
	  }
	  catch(Exception e) {
		  e.printStackTrace();
	  }
  }
}
