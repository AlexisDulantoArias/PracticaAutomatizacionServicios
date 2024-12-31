@petStoreTest @userTest

Feature: Módulo de usuario

  @createUser
  Scenario Outline: Crear usuario
    Given la URL del servicio para crear el usuario es "https://petstore.swagger.io/v2"
    When creo un usuario con nombre de usuario "<username>", primer nombre"<firstName>", apellidos "<lastName>", contraseña "<password>"
    Then valido que el codigo de respuesta del servicio sea 200
    Examples:
      | username  | firstName | lastName | password     |
      | usuario16 | Alejandro | Saldivar | alejandro123 |
      | usuario32 | Alexis    | Dulanto  | alexis123    |

  @findUserByUsername
  Scenario Outline: Buscar usuario por Username
    Given la URL del servicio para buscar usuario por username es "https://petstore.swagger.io/v2"
    When busco al usuario por su username "<username>"
    Then valido que el codigo de respuesta del servicio para buscar usuario por username sea 200
    And imprimo la respuesta
    Examples:
      | username  |
      | usuario16 |
      | usuario32 |

  @loginUser
  Scenario Outline: Loguear y cerrar sesión de usuario en el sistema
    Given la URL del servicio para loguear usuario en el sistema es "https://petstore.swagger.io/v2"
    When inicio sesión con username "<username>" y contraseña "<password>"
    And cierro sesión de la cuenta del usuario
    Then valido el código de respuesta es 200
    Examples:
      | username  | password     |
      | usuario16 | alejandro123 |
      | usuario32 | alexis123    |