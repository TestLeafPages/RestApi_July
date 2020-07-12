package basic;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateIncidentWithBody_File {
	
	@Test
	public void createIncident() {
		//step1: Get the URI / Endpoint of Service
		RestAssured.baseURI = "https://dev53783.service-now.com/api/now/table/incident";
		//step2: Authorization (Basic Auth)
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		//step3: Request type (Post) + Content Type + file
		
		//Create File obj to call a json file
		//ClassName obj = new Classnaame();
		File dataFile = new File("JsonFile.json");
		
		Response response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body(dataFile)
				.post();
		//Step4: validate Response -> Status Code : 200
		System.out.println(response.getStatusCode());
		//step5: validate Response format
		System.out.println(response.getContentType());
		// print the Response
		response.prettyPrint();
		
	}
	
}
