Feature: Navigation to 'Stack' home page and validate its Functionality
As a user
I want to navigate to the 'Stack' home page
So that I can access its functionalities
Additionally, I want to verify the correct execution of Python code snippets 

Background:
Given User should be logged in with valid credential

#Scenario:
#When The user select Get Started button in "Stack" panel
#Then The user should be redirected to following page
#|stack| 
#
#Scenario Outline: Navigate through 'Stack' learning and run valid Python code
#Given User is on "Stack" Home page
#When The user clicks "<Topics>" link
#Then The user should be redirected to "<Topic specific>" page
#When The user clicks Try Here button
#Then The user should redirected to the page having Editor and Run button
#When The user clicks the Run button after writes following Valid Python Code in editor
#"""
#print"Hello"
#print"Welcome!!"
#
#"""
#Then The user is able to see the output inside the console
#
#Examples: 
#|Topics|                            | Topic specific|
#|Operations in Stack|               |operations-in-stack|
#|Implementation|             				|implementation|             
#|Applications|						  				|stack-applications|

#
Scenario Outline: Navigate through 'Stack' learning and run invalid Python code
Given User is on "Stack" Home page
When The user clicks "<Topics>" link
Then The user should be redirected to "<Topic specific>" page
When The user clicks Try Here button
Then The user should redirected to the page having Editor and Run button
When The user clicks the Run button after writes following Invalid Python code in editor
"""
print"Hello"
print"Welcome!!"
int a =0;
"""
Then The user see error msg in alert window


Examples: 
|Topics|                            | Topic specific|
|Operations in Stack|               |operations-in-stack|
|Implementation|             			 |implementation|             
|Applications|						  				 |stack-applications|



#Scenario: Validation of Left Panel Links in 'Stack' Topic - Specific Page  
#
#Given User is on "Stack" "Operations in Stack" page
#Then The user clicks on LINKS on the left panel to validate the Python Editor funtionality
#
#"""
#print"Hello"
#print"Welcome!!"
#
#"""





