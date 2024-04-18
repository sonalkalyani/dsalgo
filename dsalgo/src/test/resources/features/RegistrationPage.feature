Feature: New User Registartion Functionality

  Background: 
    Given I am on the registration page

  Scenario Outline: User cannot register with  null values for username and password
    When User does not enter username "<username>" and password "<password>"
    And User submit the registration form with errors
    Then User should see an error popup

    Examples: 
      | username | password |
      |          |          |

 Scenario Outline: User cannot register with invalid Username
    When User enters username "<username>" with invalid special charecter and valid password "<password>"
    And User submit the registration form with errors
    Then User should see an error message

    Examples: 
      | username   | password  |
      | Sandy$345  | happy1234 |
      | Sandy&John | happy1234 |
      | Sandy 345  | happy1234 |

  Scenario Outline: User cannot register with invalid password
    When User enters valid username "<username>" and invalid password "<password>" with all numeric values
    And User submit the registration form with errors
    Then User should see an error message

    Examples: 
      | username  | password  |
      | Sandy+345 | 123456789 |

  Scenario Outline: User cannot register with invalid password
    When User enters valid username "<username>" and invalid password "<password>" with charecters less than 8
    And User submit the registration form with errors
    Then User should see an error message

    Examples: 
      | username  | password |
      | Sandy@345 | happy12  |

  Scenario Outline: User cannot register with invalid password
    When User enters valid username "<username>" and invalid password "<password>" with charecters equal to 8
    And User submit the registration form with errors
    Then User should see an error message

    Examples: 
      | username  | password |
      | Sandy@345 | happy123 |

     

  Scenario Outline: User cannot register with different  values for password and confirm password
    When User enters valid username "<username>" and password "<password>" and different confirmpassword "<confirmpassword>" feild
    And User submit the registration form with errors
    Then User should see an error message

    Examples: 
      | username  | password  | confirmpassword |
      | Sandy@345 | happy1234 | happy4567       |

  Scenario Outline: User can register with valid information
    When User enters valid username "<username>" and password "<password>"
    And User submits the registration form  successfully
    And User should be redirected to Home Page
    And user should be logged in with the registered "<username>"

    Examples: 
      | username  | password   |
      | Quality_123| quality@8989|

   
  Scenario Outline: User cannot  register with existing  user details
    When User enters existing username "<username>" and password "<password>"
    And User submit the registration form with errors
    Then User should see an error message

    Examples: 
      | username  | password   |
      | Sandy_0987 | Numpy@8899 |

  Scenario: User can  traverse to Login page from Registration page
    When User clicks on login link
    Then User should traverse to Login page