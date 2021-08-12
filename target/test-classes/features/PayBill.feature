Feature: Pay Bills
  Background: 
    Given user is on the login page
    And user enters valid username and password
    And user is on "Account Summary" page
    When user clicks on "Pay Bills" menu tab
  Scenario: When user navigates to Pay Bills, page title should be Zero - Pay Bills
    Then page title should be "Zero - Pay Bills"

  Scenario: If user completes a valid pay operation, "The payment was successfully submitted."
    message should be displayed
      And user enters an amount "1234"
      And user selects a date
      And user clicks on Pay button
      Then "The payment was successfully submitted." message should be displayed

  Scenario: User tries to make a payment without entering the amount and
  gets Please fill in this field message!
    And user does not enter amount and enters a date
    Then user should get "Please fill out this field." message under "amount"

  Scenario: User tries to make a payment without entering the date and
  gets Please fill in this field message!
    And user does not enter date and enters an amount
    Then user should get "Please fill out this field." message under "date"

  Scenario: Amount field should not accept alphabetical or special characters.
    And user enters a non-number value in the amount input
    Then "The payment was successfully submitted." message should not be displayed

  Scenario: Amount field should not accept alphabetical or special characters.
    And user enters an invalid value in the date input
    Then "The payment was successfully submitted." message should not be displayed


