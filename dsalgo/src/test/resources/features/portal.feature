Feature: Home page Navigation and Home Page Access for Unauthenticated Users 
As a User
I want to navigate to DS-Algo home page 
So that I can verify the the access for Unauthenticated Users

@FunctionTest
Scenario: User navigate to DS_Algo home page from DS_Algo Introduction page
Given The user is opening the browser and enter the DS_Algo Portal <URL>
Then The user should landed on the DS_Algo get started page with message "You are at the right place"
When The user clicks Get Started button  
Then The user should land on the DS_Algo home page



  



   







