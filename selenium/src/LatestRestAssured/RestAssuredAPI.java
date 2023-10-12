package LatestRestAssured;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;


public class RestAssuredAPI {
	@Test
		public void login()
		{
		RestAssured.baseURI="http://localhost:8080";
	String response	=given().log().all().body("{ \"username\": \"jyothisahu507\", \"password\": \"Jyothi@123\" }").header("Content-Type","application/json")
		.when().post("/rest/auth/1/session")
		.then().log().all().assertThat().extract().response().asString();
	System.out.println(response);
	
		
		}

}
