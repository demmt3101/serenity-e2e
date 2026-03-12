Feature: Login básico

  Scenario: Login exitoso
    Given que el usuario abre la pagina de login
    When ingresa el usuario "standard_user"
    And ingresa la contraseña "secret_sauce"
    And hace clic en el boton login
    Then deberia visualizar la pagina principal