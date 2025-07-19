@productChange
Feature: Product changes

  Background:
    Given user is on the login page
    Given user is on the product home page

  Scenario: Edit_product_TC01
    When user search for the product code
    Then from the product list user will edit the product details
    Then change the account name
    And validate the changes made