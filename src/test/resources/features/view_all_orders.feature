Feature: view all orders

  Background:
    Given user is logged in
    And user clicks on "View All Orders" tab

  Scenario: verify page title
    Then verify title of page is List of All Orders

    Scenario: verify Check All button clickable
      When user clicks on "Check All" button
      Then verify all checkboxes are selected
      When user clicks on "Uncheck All" button
      Then verify all checkboxes unselected

      Scenario: verify
        When user selects only orders from "US"
        Then verify there is 5 orders
        And verify their names below
        |Paul Brown|
        |Charles Dodgeson|
        |Bob Feather|
        |Samuel Clemens|
        |Clare Jefferson|

