Feature: Address endpoints

  Scenario Outline: Get Address
    Given Setting up with port number <port>
    When I send a GET request for address id <id>
    Then I should receive a status 200 if it exists.
    Examples:
      | port | id |
      | 3305 | 3  |