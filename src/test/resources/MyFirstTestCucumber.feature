Feature: Login

  @Regression @SmokeTest @BVT
  Scenario: COMO usuario administrador
            QUIERO poder loguear usando user y password
            PARA poder ingresa a la aplicacion de manera segura

    Given yo tengo un usuario empleado
    When yo ingreso a la pagina principal en whatsapp
    And yo lleno el [usuario] con : cucumber2
    And yo lleno el [password] con : 123456
    And yo lleno el [email] con : cucumber@cucumber.com
    Then verifico que puedo ingresar a la pagina principal

# my commnet para el scenario 2
  @Regression @SmokeTest @BVT
  Scenario Outline: Description
    Given yo tengo un usuario <usuario>
    When yo ingreso a la pagina principal en <abc>
    And yo lleno el [usuario] con : <nameUser>
    And yo lleno el [password] con : <password>
    And yo lleno el [email] con : cucumber@cucumber.com
    Then verifico que puedo ingresar a la pagina principal

    Examples:
      | usuario      | nameUser | password | abc      |
      | adminstrador | admin1   | 123      | face.com |
      | empleado     | emple1   | 456      | wah.com  |
      | invitado     | invi1    | 789      | abc.com  |