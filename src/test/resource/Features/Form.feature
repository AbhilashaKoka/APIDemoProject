Feature: Verify Form Submission functionality

  Scenario: PracticeForm:successfully login by valid credential
    Given I am in from landing page
    When I fill all valid credential and click on submit
    |FirstName|LastName|Gender|Email|Mobile|DOB|Subject|Hobbies|CurrentAddr|State|City|
    | Sita|Kumari| Female| sita.kumari@gmail.com|9142343241|28 JUN 1983|Computer Science |Reading|adsffsfff|Uttar Pradesh|Lucknow|
    Then I am able to verify form details successfully
