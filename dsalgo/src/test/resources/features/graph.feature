Feature: Navigation to 'Graph' home page and validate its Functionality
As a user
I want to navigate to the 'Graph' home page
So that I can access its functionalities
Additionally, I want to verify the correct execution of Python code snippets 

Background:
Given User should be logged in with valid credential


Scenario: User selecting 'Graph' Data Structure
When The user select Get Started button in "Graph" panel
Then The user should be redirected to following page
|graph|


Scenario Outline: Navigate through 'Graph' learning and run valid Python code
Given User is on "Graph" Home page
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
|Topics|                            |Topic specific|
|Graph|               							|graph|
|Graph Representations|        			|graph-representations|             


Scenario Outline: Navigate through 'Graph' learning and run invalid Python code
Given User is on "Graph" Home page
When The user clicks "<Topics>" link
Then The user should be redirected to "<Topic specific>" page
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
|Topics|                            | Topic specific|
|Graph|               							 |graph|
|Graph Representations|        		 |graph-representations|

Scenario: Validation of Left Panel Links in 'Graph' Topic - Specific Page  

Given User is on "Graph" "Graph" page
Then The user clicks on LINKS on the left panel to validate the Python Editor funtionality

"""
print"Hello"
print"Welcome!!"

"""




