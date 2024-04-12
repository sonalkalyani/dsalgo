Feature: Navigation to 'Data Structures Introduction' home page and validating its Functionality
As a user
I want to be able to navigate to the 'Data Structures Introduction' home page
So that I can access its functionalities
Additionally, I want to verify the correct execution of Python code snippets 

Background:
 Given User should be logged in with valid credential
 
 Scenario:
When The user select Get Started button in "Data Structures-Introduction" panel
Then The user should be redirected to following page
|data-structures-introduction|



Scenario Outline: Navigate through 'Data Structures-Introduction' learning and run valid Python code
Given User is on "Data Structures-Introduction" Home page
When The user clicks "<Topics>" link
Then The user should be redirected to "<Topic specific>" page 
When The user clicks Try Here button
Then The user should redirected to the page having Editor and Run button
When The user clicks the Run button after writes following Valid Python Code in editor
"""
print"Hello"
print"Welcome!!"

"""
Then The user is able to see the output inside the console

Examples: 
|Topics|                             |Topic specific|
|Time Complexity|										|time-complexity|

Scenario Outline: Navigate through 'Data Structures-Introduction' and run invalid Python code
Given User is on "Data Structures-Introduction" Home page
When The user clicks "<Title>" link
Then The user should be redirected to "<Title specific>" page
When The user clicks Try Here button
Then The user should redirected to the page having Editor and Run button
When The user clicks the Run button after writes following Invalid Python code in editor
"""
public class PythonCode{
 int a = 0;
}
"""
Then The user see error msg in alert window

Examples: 
|Topics|                             |Topic specific|
|Time Complexity|										|time-complexity|

Scenario: Validation of Left Panel Links in 'Data Structures-Introduction' Topic - Specific Page  

Given User is on "Data Structures-Introduction" "Time Complexity" page

Then The user clicks on LINKS on the left panel to validate the Python Editor funtionality

"""
print"Hello"
print"Welcome!!"

"""

