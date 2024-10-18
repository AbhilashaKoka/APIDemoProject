@restapi
Feature: Verify add/remove book from ReadingList

  Scenario: Add/Remove book successfully from ReadingList
    Given I am an authorized user
    And A list of books are avaliable
    When I added a book to my reading list
    Then The book is added
    When I remove a book from my reading list
    Then The Book is removec
