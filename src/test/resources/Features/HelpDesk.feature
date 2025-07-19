Feature: New_Ticket_Functionality
@priorityDropDown
  Scenario: Vtiger_priority_dropdown_text_validation_TC01
    Given user should be on home page
    When user click one of the priority options
    Then validate the text of selected priority option