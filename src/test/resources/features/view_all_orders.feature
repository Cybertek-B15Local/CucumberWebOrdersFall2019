Feature: view all orders

  Background:
    Given user is logged in
    And user clicks on "View All Orders" tab
  @title
  Scenario: verify page title
    Then verify title of page is List of All Orders

    @buttons
    Scenario: verify button clickable
      When user clicks on "CheckAll" button
      Then verify all orders are selected
      When user clicks on "UncheckAll" button
      Then verify all orders are unselected


      Scenario: verify
        When user selects only orders from "US"
        Then verify there is 5 orders
        And verify their names below
        |Paul Brown|
        |Charles Dodgeson|
        |Bob Feather|
        |Samuel Clemens|
        |Clare Jefferson|

