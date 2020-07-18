package week3.day1;


import javax.management.RuntimeErrorException;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import static org.hamcrest.Matchers.*;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;



public class LearnCookies {
	
	@Test
	public void newIncident() {
		RestAssured.baseURI = "https://dev92834.service-now.com/api/now/table/incident";
		//RestAssured.authentication = RestAssured.basic("admin", "India@123");
		
		 Response response = RestAssured
		.given()
		.auth()
		.basic("admin", "India@123")
		.contentType(ContentType.JSON)
		.when()
		.body("{\"short_description\":\"created from rest assured\"}")
		.post();
		
		 
		 // To get a single cookie
		
		  String cookie = response.getCookie("JSESSIONID"); 
		  
		  
		  Response response2 = RestAssured
		  .given()
		  .cookie("JSESSIONID", cookie)
		  .param("sysparm_fields", "sys_id,number,short_description")
		  .param("sysparm_limit", "10")
		  .get();
		 
		  response2.prettyPrint();
		 
		// to get all the cookies
		/*
		 * Map<String, String> cookies = response.getCookies();
		 * 
		 * Set<Entry<String, String>> entrySet = cookies.entrySet();
		 * 
		 * for (Entry<String, String> eachEntry : entrySet) {
		 * 
		 * System.out.println(eachEntry.getKey()+" --> "+eachEntry.getValue()); //
		 * System.out.println(eachEntry.getValue());
		 * 
		 * }
		 */
		 
		 
		/*
		 * String value = cookies.get("JSESSIONID");
		 * 
		 * System.out.println(value);
		 */
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		

	}

}
