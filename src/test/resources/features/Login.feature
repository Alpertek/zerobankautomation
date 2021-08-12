@login
Feature: Only authorized users should be able to login
  Background:
    Given user is on the login page

  Scenario: User Logs in with valid credentials
    When user enters valid username and password
    Then "Account Summary" page should be displayed

    Scenario Outline: User tries to log in with invalid credentials
      When user enters "<username>" "<password>"
      Then login should fail and error message "Login and/or password are wrong." should be displayed
      Examples:
      |username|password|
      |abcd123 |password|
      |username|passw123|
      |        |password|
      |username|        |



#
#  Scenario: User tries to log in with wrong username and a valid password
#    When user enters "abcdef" "password"
#    Then login should fail and error message "Login and/or password are wrong." should be displayed
#
#  Scenario: User tries to log in with a valid username and a wrong password
#    When user enters "username" "password123"
#    Then login should fail and error message "Login and/or password are wrong." should be displayed
#
#  Scenario: User tries to log in with a blank username and a valid password
#    When user enters "" "password"
#    Then login should fail and error message "Login and/or password are wrong." should be displayed
#  Scenario:  User tries to log in with a valid username and a blank password
#    When user enters "username" ""
#    Then login should fail and error message "Login and/or password are wrong." should be displayed

