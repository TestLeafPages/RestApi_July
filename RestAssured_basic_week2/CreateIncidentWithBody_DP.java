package basic;

import java.io.File;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateIncidentWithBody_DP {
	//Step 1  Create dataProvider method
	@DataProvider(name = "fetchData", parallel = true)
	public String[] getData() {//void -> no output
		//1st -> No of Rows, 2nd -> No of  Columns 
		String[] data = new String[2];// with length
		data[0] = "./data/JsonFile1.json";// with index
		data[1] = "./data/JsonFile2.json";// with index
		return data;
	}
	
	@Test(dataProvider ="fetchData")
	public void createIncident(String filePath) {
		//step2: Get the URI / Endpoint of Service
		RestAssured.baseURI = "https://dev53783.service-now.com/api/now/table/incident";
		//step3: Authorization (Basic Auth)
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		//step4: Request type (Post) + Content Type + file
		
		//Create File obj to call a json file
		//ClassName obj = new Classnaame();
		File dataFile = new File(filePath);
		
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
