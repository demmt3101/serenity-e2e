Feature: Login básico

  Scenario: Compra exitosa con dos productos aleatorios
    Given que el usuario abre la pagina de login
    When ingresa el usuario "standard_user" y la contraseña "secret_sauce"
    Then deberia visualizar la pagina principal
    When selecciona dos productos aleatorios y completa la compra
    Then la compra debe completarse exitosamente
