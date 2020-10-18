Feature: Verify the new contact creation functionality 

Scenario Outline: Create multiple contacts
Given that the user is on the login page
And 	click on Login button
When 	enter the valid "<username>" and "<password>"
And 	click on login buttom
And 	clicks on contacts-> New
And 	fill the "<firstname>" and "<lastname>"
And 	click on Save button
Then 	contact should be added with "<fullname>"

Examples:
|username|password|firstname|lastname|fullname|
|868kinwest@gmail.com|Test@123|fname1|lname1|fname1 lname1|
|868kinwest@gmail.com|Test@123|fname2|lname2|fname2 lname2|
|868kinwest@gmail.com|Test@123|fname3|lname3|fname3 lname3|