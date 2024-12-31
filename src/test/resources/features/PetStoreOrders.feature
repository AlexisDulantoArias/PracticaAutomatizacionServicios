@petStoreTest
Feature: Módulo de Pedidos

  @crearPedido
  Scenario Outline: Crear y validar un pedido exitoso para una mascota con cantidad específica
    Given la URL base del servicio es "https://petstore.swagger.io/v2"
    When creo un pedido con ID <idPedido> para la mascota de ID <idMascota> de cantidad <cantidadPedido>
    Then valido que el código de respuesta es 200
    And verifico que el estado del pedido sea "placed"
    And imprimo la respuesta del pedido creado en la API
    Examples:
      | idPedido | idMascota | cantidadPedido |
      | 1        | 123       | 10             |
      | 2        | 345       | 12             |
      | 3        | 890       | 7              |

  @buscarPedido
  Scenario Outline: Buscar un pedido mediante su ID
    Given la URL base del servicio para consultar el pedido por ID es "https://petstore.swagger.io/v2"
    When consulto el ID del pedido <idPedido>
    Then valido que el código de respuesta sea 200 para el servicio
    And verifico el id de la mascota <idMascota>
    And verifico la cantidad del pedido <cantidadPedido>
    And la respuesta debe tener todos los datos de la orden
    Examples:
      | idPedido | idMascota | cantidadPedido |
      | 1        | 123       | 10             |
      | 2        | 345       | 12             |
      | 3        | 890       | 7              |