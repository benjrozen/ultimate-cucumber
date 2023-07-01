Feature: Order a book from https://bookcart.azurewebsites.net/api

  Scenario: As an existing bookcart user, I want to be able to make a purchase
    Given the user is authenticated
    And he adds bookId "3" to cart
    When he completes checkout
