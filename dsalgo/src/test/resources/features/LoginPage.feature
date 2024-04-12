Feature: Login page functionality
As a user
I want to be able to login with credentials
So that I can access the dsalgo portal

Background:
Given The user is on the DS Algo Sign in Page


@TC001
Scenario: Verify Login page title
When The user gets the title of the page
Then Page title should be "Login"

@TC002
Scenario: Verify Register link under the login button
Then On clicking register link, page should navigate to Registration page with title Registration


Scenario: verify login is successful with valid credentials
When The user enters valid username and valid password and clicks on Login button
Then The user should be navigated to Home Page with the message "You are logged in" and with the user name on the top
 

Scenario: Verify error message when login button is clicked with blank username and blank password
When The user clicks login button after leaving the username textbox and password textbox blank
Then The error message Please fill out this field should appear below Username textbox 


Scenario: Verify error message when login button is clicked with valid username and invalid password
When The user enters below valid username and invalid password in textbox
| Username | Password |
| ninja153 | sgr232s |
And The user clicks on login button
Then The user should able to see an error message "Invalid Username and Password"

Scenario: Verify error message when login button is clicked with invalid username and valid password
When The user enters below invalid username and valid password in textbox
| Username | Password |
| abcwer2	| sdet@153  |
And The user clicks on login button
Then The user should able to see an error message "Invalid Username and Password"

Scenario: Verify error message when login button is clicked with invalid username and invalid password
When The user enters below invalid username and invalid password in textbox
| Username | Password |
| test1223	| xxxdss  |
And The user clicks on login button
Then The user should able to see an error message "Invalid Username and Password"
