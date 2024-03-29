Feature: Validate the Queue data structure functionality
  I want to be able to navigate to the Queue home page
  So that I can access its functionalities
  Additionally, I want to verify the correct execution of Python code snippets

  Background: 
    Given I am on the Home page

  Scenario: User should be directed to Queue Page from Home Page
    Given User is on DS_Algo Home page after logged in
    When User selects Queue item from Data Structures dropdown
    Then User should be redirected to Queue Page

  Scenario Outline: Validating  all the links in Queue page and
    		 run Valid and Invalid Python code and validate it

    Given User is on Queue home page
    And User clicks  "<Topics>" link
    Then User should be redirected to "<Topics>"  Page
    And User clicks TRY HERE button
    Then User should be redirected to a page having an tryEditor with a Run button
    And User writes Valid "<PythonCode>" and clicks Run button
    Then User is able to see the output in console

 Examples: 
      | Topics                                 | PythonCode       |
      | Implementation of Queue in Python      | print("Hello") |
      | Implementation using collections.deque |                  |
      | Implementation using array             |                  |
      | Queue Operations                       |                  |


  Scenario Outline: Validating  all the links in Queue page and
    run Valid and Invalid Python code and validate it

    Given User is on Queue home page
    And User clicks  "<Topics>" link
    Then User should be redirected to "<Topics>"  Page
    And User clicks TRY HERE button
    Then User should be redirected to a page having an tryEditor with a Run button
    And User writes InValid "<PythonCode>" and clicks Run button
    Then User is able to see the error msg in pop up window

    Examples: 
      | Topics                                 | PythonCode       |
      | Implementation of Queue in Python      | Println("Hello") |
      | Implementation using collections.deque |                  |
      | Implementation using array             |                  |
      | Queue Operations                       |                  |

  Scenario: Validation of Left Panel Links in Queue Topic - Specific Page
    Given User is on Queue Home page
    When The user clicks "<Topics>" link
      | Topics                                 |
      | Implementation of Queue in Python      |
      | Implementation using collections.deque |
      | Implementation using array             |
      | Queue Operations                       |
    Then User should be redirected to Topics page
    Then User tries to click on LINKS on the left panel
    Then User should be redirected to a page having an tryEditor with a Run button
    
    
    
    
    
    
    
    
    
    
    
    
