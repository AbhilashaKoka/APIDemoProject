Feature: Verify TestBox Login Page

  Scenario: TextBox:Successful login with valid Credential
    Given User is on Landing Page
    When User enter details username, email, current address, permanent address
    And Click on Submit
    Then user should able to verify the detail on output area


  Scenario: TextBox:Successful login with valid Credential
    Given User is on Landing Page
    When User enter details "uname", email, current address, permanent address
    |uname|
    |sita |
    And Click on Submit
    Then user should able to verify the detail on output area
