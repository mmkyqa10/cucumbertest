Feature: Deals page validation using map

  Scenario: Verify the functionality of new deals creation
  Given that the user is on the login page for dealsmap
	And 	click on the Login button for dealsmap
	When 	provided the valid username and password for dealsmap
	|username|password|
	|868kinwest@gmail.com|Test@123|
	And 	click on the login buttom for dealsmap
	And 	clicks on the deals->New option for dealsmap
	And 	fill the title,description and probability for dealsmap
	|title|description|probability|
	|mapdeal1|maptestdeal1|50|
	|mapdeal2|maptestdeal2|60|
	|mapdeal3|maptestdeal3|40|
	And 	click on Save button for dealsmap
	Then 	deal should be added for dealsmap