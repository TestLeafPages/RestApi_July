package basic;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DeleteIncident {
	
	@Test//(dependsOnMethods = "chaining.CreateIncidentWithOutBody.createIncident")
	public void deleteIncident() {
		String sys_id = "61cf0fc02f86501064df2d6df699b6f0";
		RestAssured.baseURI = "https://dev53783.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		Response response =  RestAssured
				.given()
				.log()
				.all()
				.contentType(ContentType.JSON)
				.pathParam("sysID", sys_id)
				.delete("{sysID}");
		//Step4: validate Response -> Status Code : 200
		System.out.println(response.getStatusCode());
		//step5: validate Response format
		System.out.println(response.getContentType());
		// print the Response
		response.prettyPrint();
		
	}
	
}
