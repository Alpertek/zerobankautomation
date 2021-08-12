Feature: Find Transactions in Account Activity

#  Background:
#    Given the user is logged in
#    And user clicks on "Account Activity" menu tab
#  Scenario: Search date range
#    Given user clicks on "Find Transactions" menu tab
#    When the user enters date range from 2012-09-01 to 2012-09-06
#    And clicks find button
#    Then results table should only show transactions dates between “2012-09-01” and “2012-09-06”
#    And the results should be sorted by most recent date
#    When the user enters date range from “2012-09-02” to “2012-09-06”
#    And clicks find button
#    Then results table should only show transactions dates between “2012-09-02” and “2012-09-06”
#    And the results table should only not contain transactions dated “2012-09-01”

#  Scenario: Search date range
#    When the user enters date range from "2012-09-01" to "2012-09-06"
#    And clicks search
#    Then results table should only show transactions dates between "2012-09-01" to "2012-09-06"
#    And the results should be sorted by most recent date
#
#  Scenario: Search Description
#    When the user enters description "ONLINE"
#    And clicks search
#    Then results table should only show descriptions containing "ONLINE"
#
#  Scenario: Search Description2
#    When the user enters description "OFFICE"
#    And clicks search
#    Then results table should only show descriptions containing "OFFICE"
#    And results table should not show descriptions containing "ONLINE"
#
#  Scenario: Search Description Case İnsensitive
#    When the user enters description "ONLINE"
#    And clicks search
#    Then results table should only show descriptions containing "ONLINE"
#    When clean the tab
#    When the user enters description "online"
#    And clicks search
#    Then results table should only show "No results."
#
#  Scenario: Type
#    And clicks search
#    Then results table should show at least one result under Deposit
#    Then results table should show at least one result under WithDrawal
#    When user selects type "Deposit"
#    And clicks search
#    Then results table should show at least one result under Deposit
#    Then results table should show no result under "Withdrawal"
#    When user selects type "Withdrawal"
#    And clicks search
#    Then results table should show at least one result under WithDrawal
#    Then results table should show no result under Deposit