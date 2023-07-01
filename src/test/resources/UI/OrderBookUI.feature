@selenium
Feature: Order a book from https://bookcart.azurewebsites.net/

  Background:
    Given the user is logged in

  Scenario: As an existing bookcart user, I want to be able to make a purchase
    When the user adds book "HP2" to cart from homepage
    And completes checkout flow
    Then he should be notified that the order was placed successfully
