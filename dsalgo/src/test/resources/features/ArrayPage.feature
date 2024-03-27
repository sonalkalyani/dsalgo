@Array
Feature: Array Page Functionalities
As a user I want to access the Array page and the links in the page.

Background: Check User is in home page
	Given User is on DSAlgo Portal URL
	When User clicks the Get Started Button
	And User enters home page and click Sign in
	Then User can enter below Username and Password and click the Login Button and navigate to home page.
	 |	Username |	Password |
	 | ninja153  | sdet@153 |
	 
	 
	 User should be logged into the DSAslgo Portal


Scenario: As a user, I should be able to view and navigate the array topics
	Given User clicks on Array - Get Started button
	When User can able to view the topics covered in array
	Then User can click on the links and navigate to the linked page
	
	
Scenario Outline:  As a user, I shoud be in Arrays in Python Page and view and navigate to the side links.
	Given User should be in Arrays in the Python page and check the title <input1>
	When User clicks on the side links
	Then User should be navigated to the clicked links 
	
	Examples:
       | input1	|
       |	Arrays in Python	|


