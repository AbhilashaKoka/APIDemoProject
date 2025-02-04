Feature: Book Management

  Scenario: Add books from Excel data
    Given I have the Excel file
    When I read the books data from the Excel file
    Then the books data should be processed correctly
