package week3.day1;


import javax.management.RuntimeErrorException;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import static org.hamcrest.Matchers.*;



public class CreateIncident {
	
	@Test
	public void newIncident() {
		RestAssured.baseURI = "https://dev92834.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "India@123");
		
		 Response response = RestAssured
		.given()
		.contentType(ContentType.JSON)
		.when()
		.body("{\"short_description\":\"created from rest assured\"}")
		.post()
		.then()
		.assertThat()
		//.statusCode(201)
		//.body("result.short_description", equalTo("created from rest assured"))
		.body("result.short_description", containsString("created from"))
		.extract()
		.response();
		 
		//int statusCode = response.getStatusCode();
		
		//response.prettyPrint();
		
		/*
		 * if(statusCode==200) { System.out.println("matching"); }else {
		 * System.out.println("doesn't match");
		 * 
		 * }
		 */
		 
		 
		
		 
	//TestNG assertion	 
	//	 Assert.assertEquals(response.getStatusCode(), 200);
		 
		
		
	//	System.out.println(response.getStatusCode());
		 
		 
		

	}

}
