Feature: ContactManager

  Scenario: Agregar un Contacto En Contact Manager

    Given tengo abierto la aplicacion ContactManager

    When hago click en el boton [OK] en el diaglo de actualizar
    And hago click en el boton [Agregar Contacto] en ContactManager
    And lleno el textbox [contact name] con el valor : AAABRemove
    And lleno el textbox [contact phone] con el valor : 9999999
    And lleno el textbox [contact emial] con el valor : appium@appium.com
    And hago click en el boton [save] en ContacManager

    Then verifico que el contacto : AAABRemove es mostrado
    And cierro ContactManager en mi dispositivo celular
