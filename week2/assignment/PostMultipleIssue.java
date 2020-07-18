package week2.assignment;

import java.io.File;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PostMultipleIssue {
	
	
	@DataProvider(name="sendFile")
	public String[] fetchFile() {
		String[] filePath = new String[2];
		filePath[0] = "./data1.json";
		filePath[1] = "./data2.json";
		
		return filePath;

	}
	
	
	@Test(dataProvider="sendFile")
	public void attachFile(String filePath) {
		//System.out.println(filePath);
		
		File data = new File(filePath);
		
		
		RestAssured.baseURI = "https://api-may2020.atlassian.net/rest/api/2/issue";
		
		RestAssured.authentication = RestAssured.preemptive().basic("hari.radhakrishnan@testleaf.com", "bdKG1TEWa0fAlPDqHfr880BD");
		
	
		RestAssured
		.given()
		.contentType(ContentType.JSON)
		.log().all()
		.body(data)
		.when()
		.post()
		.then()
		.log().all();
		
		//System.out.println(response.getStatusCode());
		
	

	}
	
	

}
