Feature: Creating and Viewing the Schedule

  @Login
  Scenario: The user logs in to the system
    Given User is on the login page
    And User provides email
    And User provides password
    Then User clicks LOG IN
    And User is on the dashboard

  @Create
  Scenario: The user creates a schedule
    Given User is on the scheduler page
    And User creates schedule
    Then User closes the browser