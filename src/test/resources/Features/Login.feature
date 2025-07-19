  @regression
Feature: Login_Functionality

  Background:
    Given user is on the login page

  Scenario Outline: Login_with_valid_credentials_TC01
   When user enters valid "<Uid>" & "<Pwd>" & click on login
    Then user should validate the home page
    Examples:
    |Uid  |Pwd  |
    |admin|admin|

      @dropdown
      Scenario Outline: loginThemeDropDown_validation_TC02
        Then validate dropdown exist
        And default selection should be "<Default_value>"
        And there should be four values in dropdown as "<options>"
        Examples:
        |Default_value|options                |
        |blue         |Aqua,blue,nature,orange|
