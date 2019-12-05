Feature: Search for products by using search field

  Scenario: As a user I would like to find products by clicking the search Button
    Given the user is on the search field
    When the user types a product name
      And the user presses the search button
    Then the user will find relevant results

  Scenario: As a user I would like to find products by pressing the submit Button from the keyboard
    Given the user is on the search field
    When the user types a product name
      And the user presses the submit Button from the keyboard
    Then the user will find relevant results

  Scenario: As a user I would like to find products ignoring search keyword case
    Given the user is on the search field
    When the user types a product name in lower case
    And the user presses the submit Button from the keyboard
    Then the user will find relevant results in upper case

  Scenario: As a user I would like to receive an error page on invalid search keyword
    Given the user is on the search field
    When the user types invalid characters keyword
    And the user presses the submit Button from the keyboard
    Then the user will receive an error page

