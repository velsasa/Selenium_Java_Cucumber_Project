Feature: Login functionality scenarios

  @Login @One
  Scenario: Verify whether the User is able to login with valid credentials
    Given I launch the application
    And I navigate to Account Login page
    When I login to the Application using Username "testersasa29@gmail.com" and Password "Testersasa29!"
    Then I should see that the User is able to login successfully

  @Login @Two
  Scenario: Verify whether the User is not able to login with invalid credentials
    Given I launch the application
    And I navigate to Account Login page
    When I login to the Application using Username "testersasa29@gmail.com" and Password "Testersasa29!!!"
    Then I should see an error message that the credentials are invalid

  @Login @Three
  Scenario: Verify whether the User is not able to login without providing credentials
    Given I launch the application
    And I navigate to Account Login page
    When I login to the Application using Username "" and Password ""
    Then I should see an error message that the credentials are invalid

  @Login @Four
  Scenario: Verify whether the User is able to reset the forgotten password
    Given I launch the application
    And I navigate to Account Login page
    When I reset the forgotten password for email "testersasa29@gmail.com"
    Then I should see a message informing the User that data information related to reset password have been sent to email address