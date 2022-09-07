package trainingOnRestAssured;

import org.json.simple.JSONObject;
//import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class postMethod {
	@Test
	public void postCreateDSL() {
		
		JSONObject params = new JSONObject();

		params.put("name", "example-test3");
		params.put("job", "leader");
		
		
		RestAssured
		.given()
			.body(params.toString())
		.when()
			.post("https://reqres.in/api/users")
		.then()
			.assertThat()
				.statusCode(201)
				.log()
					.body();
	}


//	@Test
//	public void postCreate(){
//		RestAssured.basePath = "https://reqres.in";
//
//		String body = "{\r\n"
//				+ "\"name\":\"example-test\",\r\n"
//				+ "\"job\":\"leader\",\r\n"
//				+ "}";
//		RequestSpecification httpReq = RestAssured.given();
//
//		Response res = httpReq.body(body).post("/api/users");
//
//
//		int statusCode = res.getStatusCode();
//		Assert.assertEquals(statusCode, 201);
//
//		res.prettyPrint();
//	}

//	@Test
//	public void postJSON() {
//		RestAssured.basePath = "https://reqres.in";
//
//		RequestSpecification httpReq = RestAssured.given();
//
//		JSONObject params = new JSONObject();
//
//		params.put("name", "example-test3");
//		params.put("job", "leader");
//		
//		httpReq.header("Content-type", "application/json");
//
//		httpReq.body(params.toString());
//
//		Response res = httpReq.request(Method.POST, "/api/users");
//		
//		Response res = httpReq.header("Content-type", "application/json").body(params.toString()).post("/api/users");
//
//
//		int statusCode = res.getStatusCode();
//		Assert.assertEquals(statusCode, 201);
//
//		res.prettyPrint();
//	}
}
