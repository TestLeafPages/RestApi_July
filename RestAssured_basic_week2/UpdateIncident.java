package basic;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UpdateIncident {
	
	@Test
	public void createIncident() {
		RestAssured.baseURI = "https://dev53783.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		
		Response response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body("{\"short_description\" : \"Update from Rest AssuAssured\", \"category\" : \"Software\"}")
				.patch("d4b01fc02f86501064df2d6df699b6f4");
		
		//Step4: validate Response -> Status Code : 200
		System.out.println(response.getStatusCode());
		//step5: validate Response format
		System.out.println(response.getContentType());
		// print the Response
		response.prettyPrint();
		
		String sys_id = response.jsonPath().get("result.sys_id");
		System.out.println(sys_id);
		
	}
	
}
