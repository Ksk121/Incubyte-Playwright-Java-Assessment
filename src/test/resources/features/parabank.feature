Feature: ParaBank User Registration and Login

  Scenario: Register a new user successfully

    Given User launches ParaBank application
    When User navigates to registration page
    And User enters valid registration details
    Then User account should be created successfully

  Scenario: Login with newly created user

    Given User is on ParaBank login page
    When User enters newly registered credentials
    Then User should be logged into the application

  Scenario: Verify account balance

    Given User is logged into ParaBank application
    Then User should see account overview page
    And User should print account balance