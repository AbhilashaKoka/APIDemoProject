@browser
Feature: Verify Form Submission functionality

Background:
  Given I am in from landing page

#Hard Coding Value
  Scenario: PracticeForm:successfully login by valid credential
      When I enter details firstname, lastname,gender,email,mobile,dob,subject,hobbies,currentaddr,state,city
     Then I am able to verify form details successfully


  @skip_scenario
    ##List<Map<Key,Value>>
  Scenario: PracticeForm:successfully login by valid credential
    When I fill all valid List of Map details Values and click on submit
      | FirstName | LastName | Gender | Email                 | Mobile     | DOB         | Subject          | Hobbies | CurrentAddr | State         | City    |
      | Sita      | Kumari   | Female | sita.kumari@gmail.com | 9142343241 | 28 JUN 1983 | Computer Science | Reading | adsffsfff   | Uttar Pradesh | Lucknow|
    Then I am able to verify form details successfully


  @skip_scenario
    ##List<Map<Key,Value>>
  Scenario: PracticeForm:successfully login by valid credential
    When I fill all valid List of List and click on submit
       | Sita|Kumari| Female| sita.kumari@gmail.com|9142343241|28 JUN 1983|Computer Science |Reading|adsffsfff|Uttar Pradesh|Lucknow|
    Then I am able to verify form details successfully