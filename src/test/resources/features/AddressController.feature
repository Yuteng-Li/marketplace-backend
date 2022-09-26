Feature: Address endpoints

  Scenario Outline: Get Address
    Given Setting up with port number <port>
    When I send a GET request for address id <id>
    Then I should receive a status <code> if it exists.
    Examples:
      | port | id |code|
      | 3305 | 3  |200 |
  Scenario Outline: Get all addresses
    Given Setting up with port number <port>
    When I send a GET request for all addresses
    Then I should receive a status <code> if it exists.
      Examples:
        |port|code|
        |3305|200 |
  Scenario Outline: Update Address
    Given Setting up with port number <port>
    When I send a PUT request for address id: <addressId>
      |userId|addressId|name|streetOne|streetTwo|city|state|zip|billStatus|shipStatus|
      |5|5|John Doe|12 The Good Place|Upper unit|San Francisco|CA|94321|true|false|
    Then I should receive a status <code> if it exists.
      Examples:
        |port|code|addressId|
        |3305|200|5|
  Scenario Outline: Create Address
    Given Setting up with port number <port>
    When I send a POST request with a new address
      |userId|addressId|name|streetOne|streetTwo|city|state|zip|billStatus|shipStatus|
      |1|33|Billy Jane|666 The Bad Place|Down Unit|San Francisco|CA|94321|true|false|
    Then I should receive a status <code> if it exists.
          Examples:
          |port|code|
          |3305|201|

  Scenario Outline: Delete Address
    Given Setting up with port number <port>
    When I send a DELETE request with the address id <id>
    Then I should receive a status <code> if it exists.
      Examples:
        |port|id|code|
        |3305|1|200|

