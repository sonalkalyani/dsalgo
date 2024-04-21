Feature: Navigation to 'Array' home page and validate its Functionality
As a user
I want to navigate to the 'Array' home page
So that I can access its functionalities
Additionally, I want to verify the correct execution of Python code snippets 

Background:
Given User should be logged in with valid credential


Scenario: User selecting 'Array' Data Structure
When The user select Get Started button in "Array" panel
Then The user should be redirected to following page
|array|


Scenario Outline: Navigate through 'Array' learning and run valid Python code
Given User is on "Array" Home page
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
|Arrays in Python|              		|arrays-in-python|
|Arrays Using List|        		    	|arrays-using-list|             
|Basic Operations in Lists|     		|basic-operations-in-lists|
|Applications of Array|        			|applications-of-array|  

Scenario Outline: Navigate through 'Array' learning and run invalid Python code
Given User is on "Array" Home page
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
|Topics|                            |Topic specific|
|Arrays in Python|              		|arrays-in-python|
|Arrays Using List|        		    	|arrays-using-list|             
|Basic Operations in Lists|     		|basic-operations-in-lists|
|Applications of Array|        			|applications-of-array|  




Scenario: Validation of Left Panel Links in 'Array' Topic - Specific Page  

Given User is on "Array" "Arrays in Python" page
Then The user clicks on LINKS on the left panel to validate the Python Editor funtionality


"""
print"Hello"
print"Welcome!!"

"""
Scenario: Validation of Practice Question link in the Array Page
Given User is on "Array" "Arrays in Python" page
When The user clicks "array" Practice Questions link
Then The user should be redirected to practice page having links like "Search the array" ,"Max Consecutive Ones","Find Numbers with Even Number of Digits" and "Squares of a Sorted Array"
