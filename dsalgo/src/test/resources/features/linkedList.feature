Feature: Navigation to 'Linked List' home page and validating its Functionality
As a user
I want to be able to navigate to the 'Linked List' home page
So that I can access its functionalities
Additionally, I want to verify the correct execution of Python code snippets 

Background:
Given User should be logged in with valid credential

Scenario: User selecting 'Linked List' Data Structure
When The user select Get Started button in "Linked List" panel
Then The user should be redirected to following page
|linked-list|

Scenario Outline: Navigate through 'Linked List' learning and run valid Python code
Given User is on "Linked List" Home page
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
|Introduction|                      |linked-list|
|Creating Linked LIst|              |creating-linked-list|             
|Types of Linked List|						  |types-of-linked-list|
|Implement Linked List in Python|   |implement-linked-list-in-python|
|Traversal|										      |traversal|
|Insertion|												  |insertion-in-linked-list|
|Deletion|													|deletion-in-linked-list|



Scenario Outline: Navigate through 'Linked List' learning and run invalid Python code
Given User is on "Linked List" Home page
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
|Title|                            | Title specific|
|Introduction|                      |linked-list|
|Creating Linked LIst|              |creating-linked-list|             
|Types of Linked List|						  |types-of-linked-list|
|Implement Linked List in Python|  |implement-linked-list-in-python|
|Traversal|										    |traversal|
|Insertion|												|insertion-in-linked-list|
|Deletion|													|deletion-in-linked-list|


Scenario: Validation of Left Panel Links in 'Linked List' Topic - Specific Page  
Given User is on "Linked List" "Introduction" page
Then The user clicks on LINKS on the left panel to validate the Python Editor funtionality

"""
print"Hello"
print"Welcome!!"

"""



