@sanity
Feature: Lead creation

  Background:
    Given user is on the login page

    Scenario: lead_creation_with_all_mandatory_fields_TC01
      When user enters all mandatory fields and save the details
      Then user can see the saved lead & validate it