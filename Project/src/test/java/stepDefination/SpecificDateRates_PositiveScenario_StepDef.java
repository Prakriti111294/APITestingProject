package stepDefination;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.testng.Assert;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class SpecificDateRates_PositiveScenario_StepDef {
	
	Response response;
	String responseStatus;
	String responseBody ;
	
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
	
	@When("get the body of response of API")
	public void get_the_body_of_response_of_api() {
		responseBody = response.getBody().asString();
	}

	@Then("Validate the response body")
	public void validate_the_response_body() {
		Assert.assertNotNull(responseBody);
		response.then().log().body();
	}
	
	@When("capture the response")
	public void capture_the_response() {
		responseBody = response.getBody().asString();
	}
	
	@Then("validate the date in response with current date")
	public void validate_the_date_in_response_with_current_date() {
		JsonPath extractor = response.jsonPath() ;
	    String date = extractor.getString("date") ;
	    Date currDate = new Date();
	    SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd"); 
	    String curr = sdf.format(currDate);
	    System.out.println("When we are extracting data for future date - 2030-11-06 , we will get the data of current date");
	    Assert.assertNotEquals(curr,date) ;
	}
	
	



	
}
