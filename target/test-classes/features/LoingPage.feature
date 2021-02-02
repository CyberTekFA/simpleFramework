Feature: user should be sign Up to login
  @wip
  Scenario: I as user should be able to navigate to mystore application sign up page and when I
    enter valid email and fill up field I shoudl be able to sign up successfully.
    Given I as user enter a valid email into email field
    When I click submit button
    Then I verify sign Up page displayed
