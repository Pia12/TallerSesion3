  Feature: WhenDoOutline
  Scenario Outline: Agregar una tarea en la lista WhenDo

    Given tengo abierta la aplicacion WhenDo

    When hago tab en el boton [+] de la parte inferior de la lista
    And lleno el textbox [Titulo] con el valor : <Titulo>
    And lleno el textbox [Notas] con el valor : <Nota>
    And hago tab en el boton [Guardar] en pantalla Mi Lista

    Then verifico que el Titulo : <Titulo> es mostrado
    And verifico que la Nota : <Nota> es mostrado
    And cierro WhenDo en mi dispositivo celular

    Examples:
      | Titulo   | Nota               |
      | Taller01 | Contenido Taller01 |
      | Taller02 | Contenido Taller02 |
      | Taller03 | Contenido Taller03 |