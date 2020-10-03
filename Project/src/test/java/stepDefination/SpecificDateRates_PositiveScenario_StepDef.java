package stepDefination;

import org.testng.Assert;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;

public class SpecificDateRates_PositiveScenario_StepDef {
	
	Response response;
	String responseStatus;
	
	@Given("Go to API for Latest Foreign Exchange rates {string}")
	public void go_to_api_for_latest_foreign_exchange_rates(String URI) {
		Header h1 = new Header("Accept","application/JSON");
	    response = RestAssured.given().header(h1).get(URI);
	}
	
	@When("get the response status of API")
	public void get_the_response_status_of_api() {
		responseStatus = String.valueOf(response.getStatusCode());
	}
	@Then("validate the response status as {string}")
	public void validate_the_response_status_as(String status) {
		Assert.assertEquals(responseStatus, status);
	}

}
