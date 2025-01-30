@browser
Feature: Verify Alert  functionality

  Background:
    Given I am in Alert landing page

  Scenario: Verify Click first Button  Click Button to see alert
    When  I click on First Button
    Then I am able to see alert Pop Up


  Scenario: Verify Click second Button  On button click, alert will appear after 5 seconds
    When  I click on second Button
    Then I am able to see alert Pop Up in 5 min

  Scenario:Verify Click third Button   On button click, confirm box will appear
    When  I click on third Button
    Then I am able to see alert confirm box

  Scenario:  Verify Click fourth Button On button click, prompt box will appear
    When  I click on fourth Button
    Then I am able to see alert  prompt box