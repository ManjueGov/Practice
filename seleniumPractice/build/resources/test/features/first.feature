Feature: Accounts Demo

  Scenario Outline: Account Sign up using excel sheet
    When user choose to start signup an account
    And he enters the details as <signUpDetails>

    Examples:
      |signUpDetails  |
      |user1           |
      |user2           |
      |user3           |

  Scenario Outline: Account Login
    When he chooses to login as <loginDetails>

    Examples:
      | loginDetails |
      |user1         |