@petOrders

Feature: Automatizacion servicios Swagger Pet Store

  @createOrder
  Scenario Outline: Creacion de Order
    Given la url base es "https://petstore.swagger.io/v2"
    When creo la orden con id "<idOrder>" id de mascota "<idMascota>" cantidad "<cantidad>"
    Then Valido que el codigo de respuesta es 200
    And valido que el estado de complecion de la orden es "true"
    Examples:
      | idOrder | idMascota | cantidad |
      | 44      | 3         | 4        |
      | 54      | 6         | 10       |

  @getOrder
  Scenario Outline: Consulta de Order
    Given la url base es "https://petstore.swagger.io/v2"
    When consulto la orden con el id "<orderId>"
    Then valido que el codigo de respuesta sea 200
    And valido que el status de la orden es "placed"
    Examples:
      | orderId |
      | 44      |
      | 54      |