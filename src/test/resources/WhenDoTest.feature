Feature: WhenDo

  Scenario: Agregar una tarea en la lista WhenDo

    Given tengo abierta la aplicacion WhenDo

    When hago tab en el boton [+] de la parte inferior de la lista
    And lleno el textbox [Titulo] con el valor : Taller03
    And lleno el textbox [Notas] con el valor : Contenido Taller03
    And hago tab en el boton [Guardar] en pantalla Mi Lista

    Then verifico que el Titulo : Taller03 es mostrado
    And verifico que la Nota : Contenido Taller03 es mostrado
    And cierro WhenDo en mi dispositivo celular
