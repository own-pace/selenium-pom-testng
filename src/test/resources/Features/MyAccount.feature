@dragndrop
Feature: Drag & Drop functionality
  Background:
  Given user is on the login page
  And user is on the My Account section on the home page

  Scenario: Drag_&_drop_of_tabs_TC01

  When user clicks on the customized tab
  Then user can change the tab position from the selected tab section
  And user can verify the changed position of the tabs



