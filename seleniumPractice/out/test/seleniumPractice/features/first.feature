Feature: Accounts Demo

  Scenario Outline: Account Sign up using excel sheet
    When user choose to start signup an account
    And he enters the details as <signUpDetails>

    Examples:
      |signUpDetails  |
      |user           |


  Scenario: Account Login
      When user choose to login to the account