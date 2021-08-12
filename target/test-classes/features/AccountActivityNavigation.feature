@AccountActivityNavigation
Feature:    Navigating	to	specific	accounts	in	Accounts	Activity

  Scenario Outline: <account_type> account redirect
    Given the user is logged in
    When the user clicks on "<account_type>" link on the Account Summary page
    Then "Account Activity" page should be displayed
    And Account drop down should have "<account_type>" selected

    Examples:
      | account_type |
      | Savings      |
      | Brokerage    |
      | Checking     |
      | Credit Card  |
      | Loan         |



