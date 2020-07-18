package week2.assignment;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class AttachFileToIssue {
	
	@Test
	public void attachFile() {
		
		File data = new File("./webex_issue.jpg");
		
		RestAssured.baseURI = "https://api-may2020.atlassian.net/rest/api/3/issue/RA-577/attachments";
		
		RestAssured.authentication = RestAssured.preemptive().basic("hari.radhakrishnan@testleaf.com", "bdKG1TEWa0fAlPDqHfr880BD");
		
		Response response = RestAssured
		.given()
		.header("Content-Type","multipart/form-data")
		.header("X-Atlassian-Token","no-check")
		.log().all()
		.multiPart(data)
		.post();
		
		System.out.println(response.getStatusCode());
		
		
		

	}
	
	

}
