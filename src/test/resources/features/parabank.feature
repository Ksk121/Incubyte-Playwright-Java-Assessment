Feature: ParaBank Registration

  Scenario: Register user and verify account balance

    Given User launches ParaBank application
    When User navigates to registration page
    And User enters valid registration details
    Then User account should be created successfully
    And User should see account overview page
    And User should print account balance