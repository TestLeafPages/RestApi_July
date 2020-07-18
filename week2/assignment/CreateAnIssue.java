package week2.assignment;

import java.io.File;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateAnIssue extends Base{
	
	
	
	
	@Test
	public void createIssue() {
		
		
		
		RestAssured.baseURI = "https://api-may2020.atlassian.net/rest/api/2/issue";
		
		RestAssured.authentication = RestAssured.preemptive().basic("hari.radhakrishnan@testleaf.com", "bdKG1TEWa0fAlPDqHfr880BD");
		
	
		Response response = RestAssured
		.given()
		.contentType(ContentType.JSON)
		.log().all()
		.body("{\r\n" + 
				"	\"fields\": {\r\n" + 
				"	\"project\":\r\n" + 
				"				{\r\n" + 
				"					\"key\": \"RA\"\r\n" + 
				"				},\r\n" + 
				"	\"summary\": \"create issue in MAR project\",\r\n" + 
				"	\"description\": \"Creating of an issue using project keys and issue type names using the REST API\",\r\n" + 
				"	\"issuetype\": {\r\n" + 
				"					\"name\": \"Bug\"\r\n" + 
				"				}\r\n" + 
				"	}\r\n" + 
				"}")
		.post();
		


		JsonPath jsonPath = response.jsonPath();
		
		issueId = jsonPath.get("id");
		
	

	}
	
	

}
