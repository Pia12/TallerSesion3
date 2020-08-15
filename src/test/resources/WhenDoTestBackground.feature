Feature: WhenDoBackground

  Background:
    Given tengo abierta la aplicacion WhenDo
    When hago tab en el boton [+] de la parte inferior de la lista

  @Regression @SmokeTest @BVT
  Scenario: COMO usuario de WhenDo
  QUIERO ingresar el titulo y nota
  PARA poder crear una tarea en mi lista

    And lleno el textbox [Titulo] con el valor : <Titulo>
    And lleno el textbox [Notas] con el valor : <Nota>
    And hago tab en el boton [Guardar] en pantalla Mi Lista

    Then verifico que el Titulo : <Titulo> es mostrado
    And verifico que la Nota : <Nota> es mostrado
    And cierro WhenDo en mi dispositivo celular

  @Regression @SmokeTest @BVT
  Scenario: COMO usuario de WhenDo
  QUIERO ingresar el titulo y nota
  PARA poder crear una tarea en mi lista

    And lleno el textbox [Titulo] con el valor : <Titulo>
    And lleno el textbox [Notas] con el valor : <Nota>
    And hago tab en el boton [Guardar] en pantalla Mi Lista

    Then verifico que el Titulo : <Titulo> es mostrado
    And verifico que la Nota : <Nota> es mostrado
    And cierro WhenDo en mi dispositivo celular

  @Regression @SmokeTest @BVT
  Scenario: COMO usuario de WhenDo
  QUIERO ingresar el titulo y nota
  PARA poder crear una tarea en mi lista

    And lleno el textbox [Titulo] con el valor : <Titulo>
    And lleno el textbox [Notas] con el valor : <Nota>
    And hago tab en el boton [Guardar] en pantalla Mi Lista

    Then verifico que el Titulo : <Titulo> es mostrado
    And verifico que la Nota : <Nota> es mostrado
    And cierro WhenDo en mi dispositivo celular
