package LatestRestAssured;
import io.restassured.*;

import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.asserts.Assertion;

import file.updatedPayload;
import io.restassured.path.json.*;





public class Basic {

	public static void main(String[] args) {
		//add a place in google maps
	RestAssured.baseURI= "https://rahulshettyacademy.com";
String response	=given().log().all().queryParam("key ", "qaclick123").header("Contant-Type","application/json")
	.body(updatedPayload.addPlace()).when().log().all().post("/maps/api/place/add/json").then().assertThat().statusCode(200)
	.body("scope", equalTo("APP")).header("Server","Apache/2.4.52 (Ubuntu)").extract().response().asString();
	System.out.println(response);	
	JsonPath js=new JsonPath(response);
	String placeId=js.getString("place_id");
	System.out.println(placeId);
	
	given().log().all().queryParam("key", "qaclick123").queryParam("place_id", ""+placeId+"")
	.body("{\r\n"
			+ "\"place_id\":\""+placeId+"\",\r\n"
			+ "\"address\":\"70 winter walk, USA\",\r\n"
			+ "\"key\":\"qaclick123\"\r\n"
			+ "}")
	.when().put("/maps/api/place/update/json")
	.then().log().all().assertThat().body("msg",equalTo("Address successfully updated"));
	
	
	//extract the  data  by using get method
	
	String getResponse=given().queryParam("key", "qaclick123").queryParam("place_id", ""+placeId+"")
	.when().get("/maps/api/place/get/json")
	.then().assertThat().extract().response().asString();
	JsonPath js1=new JsonPath(getResponse);
String address	=js1.getString("address");
System.out.println(address);
Assert.assertEquals(address, "70 winter walk, USA");

	

	}



}
