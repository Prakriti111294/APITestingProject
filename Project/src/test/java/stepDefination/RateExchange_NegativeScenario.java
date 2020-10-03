package stepDefination;

import org.testng.Assert;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;

public class RateExchange_NegativeScenario {
	
	Response response;
	String responseStatus;
	
	@Given("Get the API {string}")
	public void get_the_api(String URI) {
		Header h1 = new Header("Accept","application/JSON");
	    response = RestAssured.given().header(h1).get(URI);
	}
	
	@When("get the status of incorrect API")
	public void get_the_status_of_incorrect_api() {
		responseStatus = String.valueOf(response.getStatusCode());
	}

	@Then("validate the response status {string}")
	public void validate_the_response_status(String status) {
		Assert.assertEquals(responseStatus, status);
		
	}

	
	
}
