@browser
Feature: Verify TestBox Login Page

  Background:
    Given User is on Landing Page

  Scenario:verify textbox1
    When User enter details username, email, current address, permanent address and Click on submit
    Then user should able to verify the detail on output area


  Scenario:verify textbox2
    When User TextBox values "sita", "sita@gmail.com", "afsfsgds", "adsaf" and Click on submit
    Then user should able to verify the detail on output area


  Scenario Outline: verify textbox3
    When User TextBox Details "<uname>", "<email>", "<curraddr>", "<permaddr>" and Click on submit
    Then user should able to verify the detail on output area
    Examples:
      |uname|email|curraddr|permaddr|
      |sita |sita@gmail.com|ADSADS|ADSAFFA|


    Scenario: verify textbox4
    When User enter textBox values List of List and Click on submit
      | sita | sita@gmail.com | ADSADS | ADSAFFA |
    Then user should able to verify the detail on output area



  Scenario: verify textbox5
    When User enter textbox values List of Map and Click on submit
      | uname | email          | curraddr | permaddr |
      | sita  | sita@gmail.com | ADSADS   | ADSAFFA  |
    Then user should able to verify the detail on output area



  Scenario:verify textbox6
    When User enter details values using testdataClass and Click on submit
      | uname | email          | curraddr | permaddr |
      | sita  | sita@gmail.com | ADSADS   | ADSAFFA  |
      | sita  | sita@gmail.com | ADSADS   | ADSAFFA  |
    Then user should able to verify the detail on output area