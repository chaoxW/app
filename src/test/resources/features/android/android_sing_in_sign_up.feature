@BD-3
Feature: Sign in /sign up

  Scenario Outline: Behaviour of Sign in /sign up with incorrect email id (Validations)

    Given I am on sign up sign in screen of a brand
    When I click on sign in sign up with email
    Then I can see sign in sign up with email screen
    When I click on continue button enabled
    Then I can see that the email id field is mandatory
    And I enter an '<incorrect email id>'
    And I click on continue button
    Then I will see the error message as per the wireframe

    Examples:
      | incorrect email id |
      | abc 123@           |
      | okikjhdbksa        |
      | @.com              |