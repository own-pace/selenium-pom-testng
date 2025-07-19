Feature: Test all API

  @allObject
    Scenario: TC01_List_all_objects
    Given endpoint "https://api.restful-api.dev/objects"
    When user perform get operation
    Then status code should be 200
    And record should be 13