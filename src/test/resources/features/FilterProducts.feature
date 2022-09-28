Feature: Filter Products Test
  Scenario Outline: Filtering products by brand
    Given I am on the product page
      |http://localhost:4200/item-gird|
    When I should see a grid of products
    And When I click on a <brand> in the filters
    Then I should see less products on screen
    Examples:
      |brand|
      |Snacks|
    |Breakfast Cereals|
    |Condiments       |
    |Household        |
    |Drinks           |