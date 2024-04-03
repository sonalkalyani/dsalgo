Feature: Home page Navigation and Home Page Access for Unauthenticated Users 
As a User
I want to navigate to DS-Algo home page 
So that I can verify the the access for Unauthenticated Users

Background:
Given The user is on the Home page of DS_Algo portal

Scenario: Verify 'Data Structures DropDown List' size and options
When The user clicks on the DataStructures DropDown arrow
Then The user should be able to see below  six options in dropdown menu
|Arrays|
|Linked List|
|Stack|
|Queue|
|Tree|
|Graph|

Scenario: Verify display of 'You are not logged in' Message for Unauthenticated Users for DropDown List
When The user selects following options from the drop down without login

|Arrays|
|Linked List|
|Stack|
|Queue|
|Tree|
|Graph|

Then The user should be able to see an warning message "You are not logged in"



Scenario: Verify display of 'You are not logged in' Message for Unauthenticated Users for 'Get Started Button'

When The user clicks following any Get Started button for Data Structures Option on the DS home page
|Arrays|
|Linked List|
|Stack|
|Queue|
|Tree|
|Graph|
Then The user should be able to see an warning message "You are not logged in"



Scenario: Navigation to Register Page
When The user clicks "Register" link
Then The user should be redirected to Register Page
When The user should be able to see "Login" link at the bottom of the page
Then The user should be able to navigate to login page

Scenario: Navigation to 'Sign In' Page
When The user clicks on "Sign In" link
Then The user shoulde be redirected to login page
When The user should be able to see "Register" link
Then The user should able to navigate to Register page

