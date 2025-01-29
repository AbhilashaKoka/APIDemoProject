@browser
Feature: Verify CheckBox Click functionality



  Background:
    Given I am in from landing page



  Scenario : CheckBox1
    When I select radio button "Home"
   Then I am able to select all options



  Scenario Outline: CheckBox2
  When I select "<Checkbox>"
  Then I am able to select desire options "<FirstOptions>" "<SecondOptions>"
    Examples:
        | Checkbox  | FirstOptions  | SecondOptions  |
        | Desktop   | Notes         | Commands       |
        | Documents | WorkSpace     | Office         |
        | Downloads | Word File.doc | Excel File.doc |
