Feature: Create a new incident

Background:
Given setup the base uri
And setup the authentication

Scenario Outline: Create incident using data file

And pass the data file <File> to the body 
When place the post request
Then validate the response code as 201

Examples:
|File|
|data.json|
|data3.json|

Scenario: Get all the incidents

When place the get request
Then validate the response code as 200

