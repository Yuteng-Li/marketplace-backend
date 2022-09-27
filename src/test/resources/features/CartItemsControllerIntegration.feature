Feature: Credit card endpoints
  Scenario Outline: Get a credit card
    Given I have a credit card <id>
    When I send a GET request for the credit card
    Then I should receive a status <code> if the card is found.
    Examples:
      | id | code |
      |1 |200   |