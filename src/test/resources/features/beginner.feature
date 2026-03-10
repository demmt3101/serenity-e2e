@beginner
Feature: Validación básica de la página de inicio de sesión

  Scenario: Abrir SauceDemo y validar elementos principales
    Given que el usuario abre la página de SauceDemo
    Then el título de la página debe ser "Swag Labs"
    And el logo de la aplicación debe ser visible
    And el campo username debe ser visible
    And el campo password debe ser visible
    And el botón login debe ser visible