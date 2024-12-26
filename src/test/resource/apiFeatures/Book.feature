@restapi
Feature: Verify add/remove book from ReadingList

  @restapi
  Scenario: Add/Remove book successfully from ReadingList
    Given I am an authorized user
    And A list of books are avaliable
    When I added a book to my reading list
    Then The book is added
    When I remove a book from my reading list
    Then The Book is removec

    @restapi
    Scenario: Book Store End To End API Test
      Then Verify Successfully Create User
      Then Verify Successfully get User
      Then Verify Successfully get Books
      Then Verify Successfully Get book by ISBN
      Then Verify Successfully update books by  UserID and ISBN
      Then Verify Successfully Delete Book


