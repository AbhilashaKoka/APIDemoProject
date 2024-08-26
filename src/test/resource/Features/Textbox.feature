Feature: Verify TestBox Login Page

  Scenario: TextBox:Successful login with valid Credential
    Given User is on Landing Page
    When User enter details username, email, current address, permanent address
    And Click on Submit
    Then user should able to verify the detail on output area


#  Scenario Outline: TextBox:Successful login with valid Credential
#    Given User is on Landing Page
#    When User enter details "<uname>", "<email>", "<curraddr>", "<permaddr>"
#    And Click on Submit
#    Then user should able to verify the detail on output area
#    Examples:
#      |uname|email|curraddr|permaddr|
#      |sita |sita@gmail.com|ADSADS|ADSAFFA|
#
# directly passing value in scenario
#  Scenario: TextBox:Successful login with valid Credential
#    Given User is on Landing Page
#    When User enter details "sita", "sita@email", "afsfsgds", "adsaf"
#    And Click on Submit
#    Then user should able to verify the detail on output area


#  #List<List<String>>
#  Scenario: TextBox:Successful login with valid Credential
#    Given User is on Landing Page
#    When User enter details
#      |sita |sita@gmail.com|ADSADS|ADSAFFA|
#    And Click on Submit
#    Then user should able to verify the detail on output area

##List<Map<Key,Value>>
#  Scenario: TextBox:Successful login with valid Credential
#    Given User is on Landing Page
#    When User enter details
#      |uname|email|curraddr|permaddr|
#      |sita |sita@gmail.com|ADSADS|ADSAFFA|
#    And Click on Submit
#    Then user should able to verify the detail on output area


#    #List<Map<Key,Value>>
#  Scenario: TextBox:Successful login with valid Credential
#    Given User is on Landing Page
#    When User enter details
#      |uname|email|curraddr|permaddr|
#      |sita |sita@gmail.com|ADSADS|ADSAFFA|
#      |sita |sita@gmail.com|ADSADS|ADSAFFA|
#    And Click on Submit
#    Then user should able to verify the detail on output area