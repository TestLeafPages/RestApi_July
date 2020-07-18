package week2.assignment;

import java.io.File;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetAllIssue {
	
	@Test
	public void attachFile() {
		
		
		
		RestAssured.baseURI = "https://api-may2020.atlassian.net/rest/api/3/search";
		
		RestAssured.authentication = RestAssured.preemptive().basic("hari.radhakrishnan@testleaf.com", "bdKG1TEWa0fAlPDqHfr880BD");
		
	
		Response response = RestAssured.get();
		
		JsonPath jsonPath = response.jsonPath();
		
		
		
		/*
		 * int total = jsonPath.get("total");
		 * 
		 * System.out.println(total);
		 */
		
	

	}
	
	

}
