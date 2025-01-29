@browser
Feature: Verify RadioButton Click functionality



  Background:
    Given I am in RadioBox landing page



  Scenario Outline: CheckBox1
    When I select radiobutton "<Options>"
    Then I am able to verify the details "<Console>"
    Examples:
      | Options    | Console                      |
      | Yes        | You have selected Yes        |
      | Impressive | You have selected Impressive |

