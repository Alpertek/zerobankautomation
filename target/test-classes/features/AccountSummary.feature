@new
Feature: Account summary

  Background:
    Given user is on the login page
    And user enters valid username and password
    When user is on "Account Summary" page

  Scenario: Check if Page title is "Zero - Account Summary" after successful login
    Then page title should be "Zero - Account Summary"

  Scenario: Check if Account summary page has the 4 account types
    Then Account summary page should have the following account types
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |

  Scenario: Credit Accounts table must have 3 columns
    Then Credit Accounts table should have the columns of
      | Account    |
      | Credit Card|
      | Balance    |
