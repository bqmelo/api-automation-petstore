Feature: User creation in the PetStore

  Scenario: Create an user in the PetStore
    Given the user is authenticated in the PetStore
    When try to create another user
    Then the new user should be created successfully