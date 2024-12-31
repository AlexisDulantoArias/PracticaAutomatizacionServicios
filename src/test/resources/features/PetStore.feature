@petStoreTest
Feature: Módulo de mascotas

  @crearMascota
  Scenario Outline: Crear y validar una nueva mascota
    Given la url base del servicio es "https://petstore.swagger.io/v2"
    When creo una mascota con el ID <idMascota> con nombre "<nombreMascota>" y de estado "<status>"
    Then valido que el código de respuesta sea 200
    And verifico que el estado de la mascota sea "<status>"
    And imprimo la respuesta del API

    Examples:
      | idMascota | nombreMascota | status    |
      | 123       | Dobby         | available |
      | 234       | Pelusa        | pending   |
      | 345       | Black         | sold      |

  @modificarMascota
  Scenario Outline: Modificar y validar datos de mascota
    Given la url base del servicio a modificar es "https://petstore.swagger.io/v2"
    When modifico mascota de ID <idMascota> y nombre "<nombreMascota>" con este nuevo estado "<status>"
    Then valido el código de respuesta sea 200
    And imprimo la modificacion de respuesta del API
    Examples:
      | idMascota | nombreMascota | status |
      | 123       | Dobby         | sold   |

  @encontrarMascotaPorID
  Scenario Outline: Encontrar mascota por ID
    Given la url base del servicio para encontrar mascota es "https://petstore.swagger.io/v2"
    When busco a mascota por ID <petID>
    Then valido el codigo de respuesta sea 200
    And imprimo la respuesta de la API
    Examples:
      | petID |
      | 123   |
      | 234   |
      | 345   |