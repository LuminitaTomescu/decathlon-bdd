Feature: Filter products by using filter fields

  Scenario: As a user I would like to filter products by gender
    Given the user is on the found page product
    When the user clicks on gender filter
    Then the user will receive filtered products

  Scenario: As a user I would like to filter accessories by color
    Given the user is on the accessories page product
    When the user clicks on the favorite color filter
    Then the user will receive filtered color products