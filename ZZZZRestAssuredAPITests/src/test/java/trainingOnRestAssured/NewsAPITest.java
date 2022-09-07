package trainingOnRestAssured;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class NewsAPITest {
  @Test
  public void getMediaMetadataURL() {
	  RestAssured.baseURI = "https://api.nytimes.com/svc/mostpopular/v2/emailed/";
	  
	  RequestSpecification httpReq = RestAssured.given();
	  
	  Response res = httpReq.request(Method.GET, "7.json?api-key=3LyzmKEwQNep9rgh95cnStU5hfWusLyo");
	  
	  int statusCode = res.getStatusCode();
	  Assert.assertEquals(statusCode, 200);
	  
	  
	  JsonPath jp = res.jsonPath();
	  
	  List<String> list = jp.getList("results.media.media-metadata");
	  
	  
	  System.out.println(list);
	  
  }
}
