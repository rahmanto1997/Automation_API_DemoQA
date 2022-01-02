@Login
Feature: Login
  As a Linkedin user
  I want to see my timeline
  So that I can like or comment my friend post

  Scenario: Login Success with valid username valid password and get userID
    Given I am on the login page
    When I enter my username and password correctly
      And I click 'Login' button
    Then I am redirected to the dashboard
      And I get user Id

