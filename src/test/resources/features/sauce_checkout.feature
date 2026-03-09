Feature: Compra E2E en SauceDemo consumiendo datos desde JSON

  Background:
    Given cargo los datos de SauceDemo desde "testdata/sauceData.json"

  @smoke @sauce
  Scenario: Checkout exitoso con 2 productos
    Given ingreso a SauceDemo y hago login con datos del JSON
    When agrego los productos del JSON al carrito
    And hago checkout con datos del JSON
    Then debo ver la pantalla de orden completada

  @negative @sauce
  Scenario: Checkout falla si falta postal code
    Given ingreso a SauceDemo y hago login con datos del JSON
    When agrego los productos del JSON al carrito
    And intento hacer checkout sin postal code
    Then debo ver un mensaje de error en el checkout