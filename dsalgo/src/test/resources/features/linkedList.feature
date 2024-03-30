Feature: Navigation to Linked List home page and validating its Functionality
As a user
I want to be able to navigate to the Linked List home page
So that I can access its functionalities
Additionally, I want to verify the correct execution of Python code snippets 

Background:
 Given User should be logged in with valid credential.

Scenario:
       #//Given User is on DS_Algo Home page after logged in
When The user select Get Started button in "Linked List" panel
Then The user should be redirected to Linked List page.


Scenario Outline: Navigate through Linked List learning and run valid Python code
Given User is on "Linked List" Home page
When The user clicks "<Topics>" link
Then The user should be redirected to Topics page
When The user clicks Try Here button
Then The user should redirected to the page having Editor and Run button
When The user clicks the Run button after writes following Valid Python Code in editor
"""
print"Hello"
print"Welcome!!"
print x =0
"""
Then The user is able to see the output inside the console



#Scenario Outline: Navigate through Linked List learning and run invalid Python code
#Given User is on Linked List Home page
#When The user clicks "<Topics>" link
#Then The user should be redirected to "<Topics>" page
#When The user clicks Try Here button
#Then The user should redirected to the page having Editor and Run button
#When The user clicks the Run button after writes invalid python code in editor
#Then The user see error msg in alert window


Examples: 
|Topics|
|Introduction|
#|Creating Linked List|
#|Types of Linked List|
#|Implement Linked List in Python|
#|Traversal|
#|Insertion|
#|Deletion|


#Scenario: Validation of Left Panel Links in Linked List Topic - Specific Page  
#
#Given User is on Linked List Home page
#When The user clicks "<Topics>" link
#|Topics|
#|Introduction|
#|Creating Linked List|
#|Types of Linked List|
#|Implement Linked List in Python|
#|Traversal|
#|Insertion|
#|Deletion|
#
#Then The user should be redirected to Topics page
#Then The user tries to click on LINKS on the left panel
#Then The user should redirected to the page having Editor and Run button



