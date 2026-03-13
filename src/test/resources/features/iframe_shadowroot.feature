@intermediate
Feature: Manejo de iframe y shadow root

  Scenario: Interactuar con un iframe
    Given que el usuario abre la pagina de iframe
    When cambia al iframe configurado
    Then la interaccion con iframe debe ser exitosa

  Scenario: Interactuar con un shadow root
    Given que el usuario abre la pagina de shadow root
    When accede al shadow root configurado
    Then la interaccion con shadow root debe ser exitosa