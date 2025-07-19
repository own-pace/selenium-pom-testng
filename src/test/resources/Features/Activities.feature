@activityTask
Feature: New task

  Background:
    Given user is on the login page

  Scenario: validate_activity_information_with_all_necessary_fields_TC01
    When user enters  all the required fields
    Then validate the activity