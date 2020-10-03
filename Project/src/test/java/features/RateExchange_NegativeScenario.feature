Feature: Rate Exchange Negative Scenarios

	Scenario: Validate the status code for incorrect uri
		Given Get the API "https://api.ratesapi.io/api/"
		When get the status of incorrect API
		Then validate the response status "200"
		