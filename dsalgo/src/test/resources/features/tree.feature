Feature: Navigation to 'Tree' home page and validating its Functionality
As a user
I want to be able to navigate to the 'Tree' home page
So that I can access its functionalities
Additionally, I want to verify the correct execution of Python code snippets 

Background:
 Given User should be logged in with valid credential


Scenario: User selecting 'Tree' Data Structure
When The user select Get Started button in "Tree" panel
Then The user should be redirected to following page
|tree|

Scenario Outline: Navigate through 'Tree' learning and run valid Python code
Given User is on "Tree" Home page
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
|Overview of Trees|									|overview-of-trees|
|Terminologies|											|terminologies|
|Types of Trees|										  |types-of-trees|
|Tree Traversals|										|tree-traversals|
|Traversals-Illustration| 					  |traversals-illustration|
|Binary Trees|											  |binary-trees|
|Types of Binary Trees|  						|types-of-binary-trees|
|Implementation in Python|					  |implementation-in-python|
|Binary Tree Traversals|						  |binary-tree-traversals|
|Implementation of Binary Trees| 		|implementation-of-binary-trees|
|Applications of Binary trees| 			|applications-of-binary-trees|
|Binary Search Trees|								|binary-search-trees|
|Implementation Of BST|							|implementation-of-bst|

Scenario Outline: Navigate through 'Tree' learning and run invalid Python code
Given User is on "Tree" Home page
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
|Overview of Trees|									|overview-of-trees|
|Terminologies|											|terminologies|
|Types of Trees|									  |types-of-trees|
|Tree Traversals|										|tree-traversals|
|Traversals-Illustration| 				  |traversals-illustration|
|Binary Trees|										  |binary-trees|
|Types of Binary Trees|  						|types-of-binary-trees|
|Implementation in Python|				  |implementation-in-python|
|Binary Tree Traversals|					  |binary-tree-traversals|
|Implementation of Binary Trees| 		|implementation-of-binary-trees|
|Applications of Binary trees| 			|applications-of-binary-trees|
|Binary Search Trees|								|binary-search-trees|
|Implementation Of BST|							|implementation-of-bst|


Scenario: Validation of Left Panel Links in 'Tree' Topic - Specific Page  
Given User is on "Tree" "Overview of Trees" page
Then The user clicks on LINKS on the left panel to validate the Python Editor funtionality

"""
print"Hello"
print"Welcome!!"

"""
Then The user should be signout the application if clicks on the signout link 

















