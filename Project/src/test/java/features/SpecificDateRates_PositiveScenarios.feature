Feature: Specific date Exchange rates

	Background: 
	Given Go to API for Latest Foreign Exchange rates "https://api.ratesapi.io/api/2020-10-03"
	
	Scenario: Exchange rates latest
		When get the response status of API
		Then validate the response status as "200" 