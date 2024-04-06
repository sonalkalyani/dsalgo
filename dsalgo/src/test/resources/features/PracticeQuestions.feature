Feature: Check Practice Question Page in Array Functionality
As a user
I want to navigate to the links in the array practise page
So that I can access its functionalities

Background:
Given User is on "array" Practice Question page

 

#Scenario Outline: Validation of Practice Questions Page with valid code
#When The user clicks "<Topics>" link
#Then The user should be redirected the question page contains a question,an tryEditor with Run and Submit buttons
#When The user is on Python Editor and write valid code in Editor and click the run button
#Then The user should be able to see output in the console
#
#Examples: 
#|Topics|                            
#|Search the array|              		
#|Max Consecutive Ones|        		    	            
#|Find Numbers with Even Number of Digits|     		
#|Squares of  a Sorted Array|

#Scenario Outline: Validation of Practice Questions Page with no code
#When The user clicks "<Topics>" link
#Then The user should be redirected the question page contains a question,an tryEditor with Run and Submit buttons
#When The user clicks the Run button without entring the code in the Editor
#Then Nothing happens to the page and no error message is displayed
#Examples: 
#|Topics|                            
#|Search the array|              		
#|Max Consecutive Ones|        		    	            
#|Find Numbers with Even Number of Digits|     		
#|Squares of  a Sorted Array|



#Scenario Outline: Validation of Practice Questions Page with invalid code and run button
#When The user clicks "<Topics>" link
#Then The user should be redirected the question page contains a question,an tryEditor with Run and Submit buttons
#When The user is on Python Editor and write invalid code in Editor and click the run button
#Then The user should able to see an error message in alert window
#
#
#Examples: 
#|Topics|                            
#|Search the array|              		
#|Max Consecutive Ones|        		    	            
#|Find Numbers with Even Number of Digits|     		
#|Squares of  a Sorted Array|


Scenario Outline: Validation of Practice Questions Page with invalid code and submit buttom
When The user clicks "<Topics>" link
Then The user should be redirected the question page contains a question,an tryEditor with Run and Submit buttons
When The user is on Python Editor and write invalid code in Editor and click the submit button
Then The user see an error message "Error occurred during submission"

Examples: 
|Topics|                            
|Search the array|              		
|Max Consecutive Ones|        		    	            
|Find Numbers with Even Number of Digits|     		
|Squares of  a Sorted Array|