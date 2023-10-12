package RestAssured;

import io.restassured.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.asserts.Assertion;

import file.Payload;
import file.ReuseableMethods;
import io.restassured.path.json.*;

public class Basics {
//validate if add place API is working fine or not
public static  void main(String args[])
{
	String address1="70 Summer walk, USA";
	RestAssured.baseURI="https://rahulshettyacademy.com";
String response	=given().log().all().queryParam("key", "qaclick123").headers("Content-Type","application/json")
	.body(Payload.addaplace()).when().log().all().post("maps/api/place/add/json")
	.then().log().all().assertThat().statusCode(200).headers("Server",equalTo("Apache/2.4.41 (Ubuntu)"))
	.extract().response().asString();
JsonPath js=new JsonPath(response);
String placeId=js.getString("place_id");
System.out.println(placeId);
//update the place
given().queryParam("key", "qaclick123").header("Content-Type","application/json").
body("{\r\n"
		+ "\"place_id\":\""+placeId+"\",\r\n"
		+ "\"address\":\"70 winter walk, USA\",\r\n"
		+ "\"key\":\"qaclick123\"\r\n"
		+ "}").when().put("maps/api/place/update/json").
then().assertThat().log().all().statusCode(200).body("msg",equalTo("Address successfully updated"));

String getPaceResponse=given().queryParam("key","qaclick123").queryParam("place_id", "6c9d3ec9e02049b4a53ba2a5d49e0d05").header("Content-Type","application/json").
when().get("maps/api/place/get/json").
then().assertThat().log().all().statusCode(200).extract().response().asString();
JsonPath js1= ReuseableMethods.rawTojson(getPaceResponse);
String actualAddress=js1.getString("address");
System.out.println(actualAddress);
Assertion a=new Assertion();
}
}
