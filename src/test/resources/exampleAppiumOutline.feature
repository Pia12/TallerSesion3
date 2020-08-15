Feature: ContactManagerOutline

  Scenario Outline: contactos

    Given tengo abierto la aplicacion ContactManager
    When hago click en el boton [OK] en el diaglo de actualizar
    And hago click en el boton [Agregar Contacto] en ContactManager
    And lleno el textbox [contact name] con el valor : <Contacto>
    And lleno el textbox [contact phone] con el valor : <PhoneContacto>
    And lleno el textbox [contact emial] con el valor : abbc@abc.com
    And hago click en el boton [save] en ContacManager
    And verifico que el contacto : <Contacto> es mostrado

    Examples:
      | Contacto  | PhoneContacto |
      | AA1Remove | 99999         |
      | AA2Remove | 88888         |
      | AA3Remove | 7777          |