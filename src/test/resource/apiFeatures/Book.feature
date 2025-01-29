@restapi
Feature: Verify add/remove book from ReadingList

  @restapi
  Scenario: Add book successfully from Book List
    Given  A list of books are avaliable
    When I enter valid credential to login
      | username | password     |
      | ritadevi | ritadevi@123 |
    And I Authorized new User
      | username | password     |
      | ritadevi | ritadevi@123 |
    And I added a book to my reading list
      | ISBN          |
      | 9781449325862 |
    Then The book is added successfully in book List


  @restapi
  Scenario: Add book successfully from Book List
    Given  A list of books are avaliable
    When I enter valid credential to login
      | username  | password      |
      | ritadevi3 | ritadevi3@123 |
    And I Authorized new User
      | username | password     |
      | ritadevi | ritadevi@123 |
    And I remove a book from my reading list
      | ISBN          |
      | 9781449325862 |
    Then The book is remove successfully from book List



