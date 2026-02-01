@register
Feature: User Registration

  As a new user
  I want to create a account through the registration form
  So that my credentials are saved in the system

  Background:
    Given As I'm on the AskOmDch Account Page

  @positiveScenario
  Scenario Outline: Registering successful
    When I enter "<Username>" "<Email address>" and "<Password>" in the registration form
    And I click the "Register" button
    Then I get redirected to Dashboard Page
    And I should see welcome message
    Examples:
      | Username       | Email address                | Password     |
      | newAppUser100Kigali | newAppUser1000Kigali@example01.com | Password123! |
      | newAppUser2000Kigali | newAppUser2000@Kigaliexample01.com | Password456@ |

  @negativeScenario
  Scenario Outline: Registration with missing required fields
    When I enter "<username>" "<emailAddress>" and "<password>" in the registration form
    And I click the "Register" button
    Then I should see error "<error_message>"
    Examples:
      | username    | emailAddress            | password   | error_message                                 |
      |             | newuser999@example.com  | Test@12345 | Error: Please enter a valid account username. |
      | testuser123 |                         | Test@12345 | Error: Please provide a valid email address.  |
      | testuser999 | testuser999@example.com |            | Error: Please enter an account password.      |


  @negativeScenario
  Scenario Outline: Registration fails when username or email already exists
    When I enter "<username>" "<emailAddress>" and "<password>" in the registration form
    And I click the "Register" button
    Then I should see error "<error_message>"

    Examples:
      | username      | emailAddress                | password     | error_message                                                                   |
      | newAppUser100 | newAppUser100@example01.com | Password123! | Error: An account is already registered with your email address. Please log in. |
      | newAppUser200 | newAppUser200@example01.com | Password456@ | Error: An account is already registered with your email address. Please log in. |

  @invalidCredentials
  Scenario Outline: Registration fails with invalid inputs
    When I enter "<username>" "<emailAddress>" and "<password>" in the registration form
    And I click the "Register" button
    Then I should see error "<error_message>"

    Examples:
      | username     | emailAddress                          | password      | error_message                          |
      | x            | aaaaaaaaaa1000000000@example01.com    | Password123A! | Error: Please provide a valid username |
      | therealuserx | newappr000ealuser000001@example01.com | 12345567      | Error: Please provide a valid password |

