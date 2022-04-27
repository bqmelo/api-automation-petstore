Feature: Pets management in the PetStore

  Scenario Outline: List pets available
    Given petStore has pets available
    When user search for <status> pets
    Then should be returned only <status> pets
    Examples: Pets in stock
      | status    |
      | available |
      | pending   |
      | sold      |