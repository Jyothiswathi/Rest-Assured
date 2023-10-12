package LatestRestAssured;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import file.Payload;


public class addLibrary {
	@Test
public void addLibrary()
{
	RestAssured.baseURI="http://216.10.245.166"	;
	given().log().all().body(Payload.addlLibrary("jyo","123"))
	.when().post(" Library/Addbook.php")
	.then().log().all().assertThat().statusCode(200);
}
	
	

}
