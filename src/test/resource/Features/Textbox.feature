@browser
Feature: Verify TestBox Login Page

  Background:
    Given User is on Landing Page
    And Click on Submit
    Then user should able to verify the detail on output area



#Hard Coding Value
  Scenario: TextBox:Successful login with valid Credential
      When User enter details username, email, current address, permanent address

  @skip_scenario
  #Data Driven Test
  Scenario Outline: Data driven Test for TextBox using  different Parameter:Successful login with valid Credential
    When User TextBox Details "<uname>", "<email>", "<curraddr>", "<permaddr>"

    Examples:
      |uname|email|curraddr|permaddr|
      |sita |sita@gmail.com|ADSADS|ADSAFFA|

  @skip_scenario
   #directly passing value in scenario
  Scenario: DataDriven test for TextBox directly passing value in scenario:Successful login with valid Credential
    When User TextBox values "sita", "sita@gmail.com", "afsfsgds", "adsaf"


  @skip_scenario
#  #List<List<String>>
  Scenario: Data Driven test for TextBox List<List<String>>:Successful login with valid Credential
    When User enter textBox values List of List
      |sita |sita@gmail.com|ADSADS|ADSAFFA|

  @skip_scenario
##List<Map<Key,Value>>
  Scenario: Data Drive test for TextBox List<Map<Key,Value>>:Successful login with valid Credential
    When User enter textbox values List of Map
      |uname|email|curraddr|permaddr|
      |sita |sita@gmail.com|ADSADS|ADSAFFA|



  @skip_scenario
#    #List<Map<Key,Value>>
  Scenario: Data Driven test for TextBox List<Map<Key,Value>>:Successful login with valid Credential
    When User enter details values using testdataClass
      |uname|email|curraddr|permaddr|
      |sita |sita@gmail.com|ADSADS|ADSAFFA|
      |sita |sita@gmail.com|ADSADS|ADSAFFA|
