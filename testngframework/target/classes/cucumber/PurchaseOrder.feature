@tag
Feature: Purchase the order from ecommerce website

  Background:
    Given I landed on Ecommerce page

  @tag2
  Scenario Outline: Positive test of submitting the order
    Given Logged in with username <name> and password <password>
    When I add product <product> to cart
    And checkout <product> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on confirmation page

  Examples:
    | name                | password    | product     |
    | jennie123@gmail.com | Jennie123   | ZARA COAT 3 |
