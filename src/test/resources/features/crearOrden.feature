Feature: Creación y obtencion de Order en PetStore
  @crearOrden
  Scenario Outline: Creación de una nueva Order
    Given la URL del servicio es 'https://petstore.swagger.io/v2/store/order'
    And el cuerpo de la solicitud es
      """
      {
        "id": <orderId>,
        "petId": <petId>,
        "quantity": <quantity>,
        "shipDate": "<shipDate>",
        "status": "<status>",
        "complete": <complete>
      }
      """
    When envío una solicitud POST
    Then el código de respuesta es 200
    And la respuesta debería ser
      """
      {
        "id": <orderId>,
        "petId": <petId>,
        "quantity": <quantity>,
        "shipDate": "<shipDate>",
        "status": "<status>",
        "complete": <complete>
      }
      """

    Examples:
      | orderId | petId | quantity | shipDate                  | status   | complete |
      | 5       | 1     | 2        | 2024-08-01T00:00:00.000+0000  | placed   | true     |
      | 2       | 2     | 1        | 2024-08-02T00:00:00.000+0000  | approved | false    |

    @obtenerOrden
    Scenario Outline: Consulta de una Order existente
      Given la URL del servicio es 'https://petstore.swagger.io/v2/store/order/<orderId>'
      When envío una solicitud GET
      Then el código de respuesta es <statusCode>
      And la respuesta debería ser
      """
      {
        "id": <orderId>,
        "petId": <petId>,
        "quantity": <quantity>,
        "shipDate": "<shipDate>",
        "status": "<status>",
        "complete": <complete>
      }
      """

      Examples:
        | orderId | petId | quantity | shipDate                  | status   | complete | statusCode |
        | 5       | 1     | 2        | 2024-08-01T00:00:00.000Z  | placed   | true     | 200        |
        | 4       | 2     | 2        | 2024-08-08T00:00:43.057Z  | delivered | false    | 200        |
