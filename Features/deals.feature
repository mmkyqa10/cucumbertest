Feature: Deals page validation

  Scenario: Verify the functionality of new deal creation
  Given that the user is on the login page for deals
	And 	click on the Login button
	When 	provided the valid username and password
	|868kinwest@gmail.com|Test@123|
	And 	click on the login buttom
	And 	clicks on the deals->New option
	And 	fill the title,description and probability
	|deal2|test deal|50%|
	And 	click on Save button for deals
	Then 	deal should be added 