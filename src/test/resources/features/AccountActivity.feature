@new
Feature: Account Activity
    Background:
      Given user is on the login page
      And user enters valid username and password
      And user is on "Account Summary" page
      When user clicks on "Account Activity" menu tab
    Scenario: Account Activity page title should be Zero - Account Activity
      Then page title should be "Zero - Account Activity"

    Scenario: In the Account dropdown default option should be Savings
      Then Savings should be default option in the Account dropdown

    Scenario: Account dropdown should have the following options
      Then user should be able to see following options under Account dropdown
      |Savings|
      |Checking|
      |Savings|
      |Loan|
      |Credit Card|
      |Brokerage|

      Scenario: Transactions table should have following column names
        Then user should be able to see following column names in Transactions table
        |Date|
        |Description|
        |Deposit|
        |Withdrawal|
