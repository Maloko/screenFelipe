Feature: Registration

  Scenario Outline: successgul registration
    Given "Pepito" wants to sign up in the application
    When "Pepito" sends the required information to sign up
      | <name> | <last name> | <age> | <email> | <country> |
    Then "Pepito" should have a new account created
    Examples:
      | name   | last name | age | email            | country  |
      | Julian | Mesa      | 20  | pepito@gmail.com | Colombia |
      | Goku   | Garcia    | 21  | goku@gmail.com   | Colombia |


  Scenario: missing requerid registration
    Given "Pepito" wants to sign up in the application
    When "Pepito" no completa todos los campos
    Then "Pepito" debera salir un mensaje de campo requerido
