Feature: Accounts Demo

  @Demo @Sanity
  Scenario Outline: Account Sign up using excel sheet
    When user choose to start signup an account
    And he enters the details as <signUpDetails>

    Examples:
      |signUpDetails  |
      |user1           |
      |user2           |
      |user3           |

  @Demo @Sanity
  Scenario Outline: Account Login
    When he chooses to login as <loginDetails>
    And he choose to create an event as <calendarEvents>

    Examples:
      | loginDetails |
      |user1         |
#      |user2         |
#      |user3         |