package steps;

import java.io.File;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateIncident {
	
	
	public static RequestSpecification request;
	public static Response response;

	@Given("setup the base uri$")
	public void setUpBaseUri() {

		RestAssured.baseURI = "https://dev92834.service-now.com/api/now/table/incident";
	}

	@And("setup the authentication$")
	public void setUpAuth() {

		RestAssured.authentication = RestAssured.basic("admin", "India@123");
	}

	@And("pass the data file (.*) to the body$")
	public void setUpBodyData(String data) {
		
		File file = new File("./data/"+data);
		
		request = RestAssured
		.given()
		.contentType(ContentType.JSON)
		.when()
		.body(file);

		
	}

	@When("place the post request$")
	public void placePostRequest() {
		response = request.post();
		
	}

	@Then("validate the response code as (.*)$")
	public void verifyStatusCode(int data) {

		response.then().assertThat().statusCode(data);
		response.prettyPrint();
	}
	
	@When("place the get request$")
	public void placeGetRequest() {
		
		response = RestAssured.get();

	}
	
	

}
