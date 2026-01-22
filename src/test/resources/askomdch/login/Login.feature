@login
Feature: Login Functionality
  As a Customer
  I want to login AskOmDch OnlineStore
  So that I can access my personalized data and preferences.

  Background:
    Given As I'm on the AskOmDch Account Page

  @positiveScenario
  Scenario Outline: Login Successfully
    When I enter valid credentials "<username>" and "<password>"
    And I click the "Log in" button
    Then I get redirected to Dashboard Page
    And I should see welcome message
    Examples:
      | username      | password |
      | USADeltaForce | Pass123! |
      | USANavy       | Pass456! |

  @negativeScenario
  Scenario Outline: Login fails with invalid credentials
    When I enter valid credentials "<username>" and "<password>"
    And I click the "Log in" button
    Then I should see error "<error_message>"
    Examples:
      | username      | password | error_message                                                                                                                    |
      | USADeltaForce | 00000    | Error: The password you entered for the username USADeltaForce is incorrect. Lost your password?                                  |
      | Pass456!      | Pass456! | Error: The username Pass456! is not registered on this site. If you are unsure of your username, try your email address instead. |