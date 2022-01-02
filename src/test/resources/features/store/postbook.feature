@PostBook
Feature: Bookstore
  As a demoqa user
  I want to add list a book to my wishlist read
  So that I can read it later

  Scenario: Post a Book
    Given I am on the post book bookstore page
    When I enter my username and password correctly for post a book
      And I choose a book
      And I click post book button
    Then I succeed to add a book to my profile
      And I check the book in my profile