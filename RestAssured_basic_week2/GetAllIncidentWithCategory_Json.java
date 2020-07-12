package basic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetAllIncidentWithCategory_Json {
	@Test
	public void getAllIncident() {
		//step1: Get the URI / Endpoint of Service
		RestAssured.baseURI = "https://dev53783.service-now.com/api/now/table/incident";
		//step2: Authorization (Basic Auth)
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		//step3: Request type (Get) + dynamic Param
		Map<String,String> parameterMap = new HashMap<String, String>();
		//mapObj.put(key, value);
		parameterMap.put("category", "Hardware");
		parameterMap.put("sysparm_fields", "sys_id,number,category");
		
		Response response = RestAssured
				.given()
				.params(parameterMap)
				.get();
		
		//Step4: validate Response -> Status Code : 200
		System.out.println(response.getStatusCode());
		//step5: validate Response format
		System.out.println(response.getContentType());
		// print the Response
		response.prettyPrint();
		
		//Convert the response as Xml
				JsonPath jsonResponse = response.jsonPath();
				
				//get all incident number
				List<String> list = jsonResponse.getList("result.number");
				
				//get first item from the list
				String firstIn_number = list.get(0);
				
				System.out.println(list.size());
				
				System.out.println(firstIn_number);
				
				response.prettyPrint();
				
				
		
		
	}
	
}
