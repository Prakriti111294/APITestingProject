Feature: Specific date Exchange rates

	Background: 
	Given Go to API for Latest Foreign Exchange rates "https://api.ratesapi.io/api/2030-10-03"
	
	Scenario: Exchange rates latest
		When get the response status of API
		Then validate the response status as "200" 
		
	Scenario: Specific date exchange rates API body validation
		When get the body of response of API
		Then Validate the response body 
		
	Scenario: Future Date validation
		When capture the response
		Then validate the date in response with current date
		
		