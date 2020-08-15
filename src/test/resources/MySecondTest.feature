Feature: Login2

  Background:
    Given yo tengo un usuario empleado
    When yo ingreso a la pagina principal en whatsapp

  @Regression @SmokeTest @BVT
  Scenario: COMO usuario administrador
  QUIERO poder loguear usando user y password
  PARA poder ingresa a la aplicacion de manera segura

    And yo lleno el [usuario] con : cucumber2
    And yo lleno el [password] con : 123456
    And yo lleno el [email] con : cucumber@cucumber.com
    Then verifico que puedo ingresar a la pagina principal

  @Regression @SmokeTest @BVT
  Scenario: COMO usuario administrador
  QUIERO poder loguear usando user y password
  PARA poder ingresa a la aplicacion de manera segura

    And yo lleno el [usuario] con : cucumber2
    And yo lleno el [password] con : 123456
    And yo lleno el [email] con : cucumber@cucumber.com
    Then verifico que puedo ingresar a la pagina principal

  @Regression @SmokeTest @BVT
  Scenario: COMO usuario administrador
  QUIERO poder loguear usando user y password
  PARA poder ingresa a la aplicacion de manera segura

    And yo lleno el [usuario] con : cucumber2
    And yo lleno el [password] con : 123456
    And yo lleno el [email] con : cucumber@cucumber.com
    Then verifico que puedo ingresar a la pagina principal