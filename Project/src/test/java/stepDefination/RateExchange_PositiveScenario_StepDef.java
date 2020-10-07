package stepDefination;

import java.time.LocalDateTime;
import org.testng.Assert;
import io.cucumber.java.en.*;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.RestAssured;

public class RateExchange_PositiveScenario_StepDef {
	
	Response response;
	String responseStatus;
	String responseBody;
	
	@Given("Go to Rates API for Foreign Exchange rates {string}")
	public void go_to_rates_api_for_foreign_exchange_rates(String URI) {
	    Header h1 = new Header("Accept","application/JSON");
	    response = RestAssured.given().header(h1).get(URI);
	}

	@When("get the response status")
	public void get_the_response_status() {
		responseStatus = String.valueOf(response.getStatusCode());
	}

	@Then("validate the status of the response is {string}")
	public void validate_the_status_of_the_response_is(String status) {
	    Assert.assertEquals(responseStatus, status);
	}
	
	@When("get the response body")
	public void get_the_response_body() {
		responseBody = response.getBody().asString();
	}

	@Then("Verify that response body is not null")
	public void verify_that_response_body_is_not_null() {
	    Assert.assertNotNull(responseBody);
	}
	
	
}
