#Feature: verifying the CRM login functionality

#Scenario: Test the login page

#Given that user is on the login page
#When the user provided valid "868kinwest@gmail.com" and "Test@123"
#Then user should see the home page

Feature: verifying the CRM login functionality with DDT

Scenario Outline: Test the login page

Given that user is on the login page
When the user provided valid "<username>" and "<password>"
Then user should see the home page

Examples:
	|username|password|
	|868kinwest@gmail.com|Test@123|
	|test|test|