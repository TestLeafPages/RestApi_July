package week2.assignment;

import java.io.File;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class UpdateIssue extends Base{
	
	
	
	
	@Test(dependsOnMethods ="week2.assignment.CreateAnIssue.createIssue")
	public void updateIssue() {
		
		
		
		RestAssured.baseURI = "https://api-may2020.atlassian.net/rest/api/2/issue/"+issueId;
		
		RestAssured.authentication = RestAssured.preemptive().basic("hari.radhakrishnan@testleaf.com", "bdKG1TEWa0fAlPDqHfr880BD");
		
	
		Response response = RestAssured
		.given()
		.contentType(ContentType.JSON)
		.log().all()
		.body("{\"fields\": {\"description\": \"update from rest assured\"}}")
		.put();
		
		
		System.out.println(response.getStatusCode());


		
	

	}
	
	

}
