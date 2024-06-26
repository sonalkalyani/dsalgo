Feature: Navigation to 'Queue' home page and validating its Functionality
As a user
I want to be able to navigate to the 'Queue' home page
So that I can access its functionalities
Additionally, I want to verify the correct execution of Python code snippets 


Background:
Given User should be logged in with valid credential


Scenario: User selecting 'Queue' Data Structure
When The user select Get Started button in "Queue" panel
Then The user should be redirected to following page
|queue|

Scenario Outline: Navigate through 'Queue' learning and run valid Python code
Given User is on "Queue" Home page
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
| Topics|                                 | Topic specific|
|Implementation of Queue in Python|       |implementation-lists|
|Implementation using collections.deque|   |implementation-collections|
|Implementation using array|              |Implementation-array|
|Queue Operations|                        |QueueOp|

Scenario Outline: Navigate through 'Queue' learning and run invalid Python code
Given User is on "Queue" Home page
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
| Topics|                                 | Topic specific|
|Implementation of Queue in Python|       |implementation-lists|
|Implementation using collections.deque|   |implementation-collections|
|Implementation using array|              |Implementation-array|
|Queue Operations|                        |QueueOp|



Scenario: Validation of Left Panel Links in 'Queue' Topic - Specific Page  
Given User is on "Queue" "Implementation of Queue in Python" page
Then The user clicks on LINKS on the left panel to validate the Python Editor funtionality

"""
print"Hello"
print"Welcome!!"

"""
    
    
    
    
    
    

    
    
    
    
    
    
 