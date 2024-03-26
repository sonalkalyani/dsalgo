
@LoginFunctionality
Feature: As a user
  I want to be able to login with credentials
  So that I can access my profile and settings

	@TC_001 
	Scenario: verify user is navigated to home page when login button is clicked with valid username and valid password is entered
    Given The user is on the DS Algo Sign in Page
    When The user enters valid credentials
    Then The user should be redirected to Home Page with the message "You are logged in" and with the user name on the top
  
	@TC_002
	Scenario: Verify error message when login button is clicked with blank username and blank password
    Given The user is on the DS Algo Sign in Page
    When The user clicks login button after leaving the "<username>" textbox and "<password>" textbox blank
    Then The error message "Please fill out this field." appears below Username textbox

	@TC_003
	Scenario: Verify error message when login button is clicked with blank username and valid password
    Given The user is on the DS Algo Sign in Page
    When The user clicks login button after entering the "<username>" and leaves "<password>" textbox blank
    Then The error message "Please fill out this field." appears below Username textbox
  
  @TC_004
	Scenario: Verify error message when login button is clicked with valid username and blank password
    Given The user is on the DS Algo Sign in Page
    When The user clicks login button after entering the "<username>" and leaves "<password>" textbox blank
    Then The error message "Please fill out this field." appears below password textbox
    
 @TC_005
	Scenario: Verify error message when login button is clicked with invalid username and invalid password
    Given The user is on the DS Algo Sign in Page
    When The user clicks login button after entering invalid username and invalid password
    Then The user should able to see an error message "Invalid username and password".
    
 @TC_006
	Scenario: Verify error message when login button is clicked with valid username and invalid password
    Given The user is on the DS Algo Sign in Page
    When The user clicks login button after entering valid username and invalid password
    Then The user should able to see an error message "Invalid username and password".
 
 @TC_007
	Scenario: Verify error message when login button is clicked with invalid username and valid password
    Given The user is on the DS Algo Sign in Page
    When The user clicks login button after entering valid username and invalid password
    Then The user should able to see an error message "Invalid username and password".  
      
 
    Examples: 
      | username  | password |
      | ninja153 | sdet@153 | 
      | abcde | dfdf@w45fd |
			| ninja153 | sgr232s | 
      | abcwer2 | sdet@153 |