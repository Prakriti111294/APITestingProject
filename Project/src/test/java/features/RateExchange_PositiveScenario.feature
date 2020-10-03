Feature: Exchange rates

	Background: 
	Given Go to Rates API for Foreign Exchange rates "https://api.ratesapi.io/api/latest"
	
	Scenario: Exchange rates API status
		When get the response status
		Then validate the status of the response is "200" 
		
	Scenario: Exchange rates API body
		When get the response body
		Then Verify that response body is not null
		
	