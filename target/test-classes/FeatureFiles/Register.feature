Feature: Registration functionality scenarios

  @Register @One
  Scenario: Verify whether the user is able to register into the application by providing all the details
    Given I launch the application
    And I navigate to Account Registration page
    When I provide all the below valid details
      | FirstName | Sasa                   |
      | LastName  | Vel                    |
      | Email     | testersasa29@gmail.com |
      | Telephone | +381644005582          |
      | Password  | Testersasa29!          |
    And I select the Privacy Policy
    And I click on Continue Button
    Then I should see that the User account has successfully created

    @Register @Two
    Scenario: Verify whether the user is not allowed to register on skipping the mandatory fields
      Given I launch the application
      And I navigate to Account Registration page
      When I click on Continue Button
      Then I should see that the User Account is not created
      And I should see the error message informing the User to fill the mandatory fields

      @Register @Three
      Scenario: Verify whether the user is not allowed to register into the application by subsribing to Newsletter
        Given I launch the application
        And I navigate to Account Registration page
        When I provide all the below valid details
          | FirstName | Sasa                   |
          | LastName  | Vel                    |
          | Email     | testersasa29@gmail.com |
          | Telephone | +381644005582          |
          | Password  | Testersasa29!          |
        And I select the Privacy Policy
        And I subscribe to Newsletter
        And I click on Continue Button
        Then I should see that the User account has successfully created

        @Register @Four
        Scenario: Verify whether the user is restricted from creating a duplicate account
          Given I launch the application
          And I navigate to Account Registration page
          When I provide the below duplicate details
            | FirstName | Sasa                   |
            | LastName  | Vel                    |
            | Email     | testersasa29@gmail.com |
            | Telephone | +381644005582          |
            | Password  | Testersasa29!          |
          And I select the Privacy Policy
          And I click on Continue Button
          Then I should see that the User is restricted from creating duplicate account