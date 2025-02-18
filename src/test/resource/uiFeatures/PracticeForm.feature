#
Feature: Verify Form Submission functionality
#
#Background:
#  Given I am in form landing page

@browser
   Scenario: PracticeForm1
      Given I am in form landing page
      When I enter details and click on Submit
      Then I am able to verify form details successfully

#    Scenario: PracticeForm2
#    When I fill all valid List of Map details Values and click on submit
#      | FirstName | LastName | Gender | Email                 | Mobile     | DOB         | Subject          | Hobbies | CurrentAddr | State         | City    |
#      | Sita      | Kumari   | Female | sita.kumari@gmail.com | 9142343241 | 28 JUN 1983 | Computer Science | Reading | adsffsfff   | Uttar Pradesh | Lucknow|
#    Then I am able to verify form details successfully
#
#
#   Scenario: PracticeForm3
#    When I fill all valid List of List and click on submit
#       | Sita|Kumari| Female| sita.kumari@gmail.com|9142343241|28 JUN 1983|Computer Science |Reading|adsffsfff|Uttar Pradesh|Lucknow|
#    Then I am able to verify form details successfully