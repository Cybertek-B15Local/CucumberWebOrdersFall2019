Feature:Create an order
  @product
  Scenario: Product Information
    Given user clicks on {order} button
    When user choose "FamilyAlbum" from drop down
    And user type a quantity
    And user type a price
    Then user hit on "calculate" button

    @adress
    Scenario Outline: Adress Information
      When user sent "<name>", "<street>", "<city>", "<zipcode>"
      Examples:
        | name | street | city | zipcode |
        |Sam  |Oak    | Allen | 80505|

      @payment
      Scenario: Payment information
        When user select a card from chexboxes
        And type cardNumber
        And type expire date
        Then click "process" button
        And user should be able to see that new order created
