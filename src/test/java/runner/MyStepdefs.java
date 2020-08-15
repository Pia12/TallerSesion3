package runner;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @autor : eynar.pari
 * @date : 08/08/2020.
 **/
public class MyStepdefs {

    @Given("^yo tengo un usuario (.*)$")
    public void yoTengoUnUsuarioAdministrador(String value) {
        System.out.println("tipo de usuario "+value);

    }

    @When("^yo ingreso a la pagina principal en (.*)$")
    public void yoIngresoALaPaginaPrincipalEnFacebookCom(String miUrl) {
        System.out.println("value miUrl "+miUrl);
    }

    @And("^yo lleno el \\[(usuario|password|email)\\] con : (.*)$")
    public void yoLlenoElUsuarioConCucumber(String nombreCajaTexto, String value) {
        System.out.println("caja de texto "+nombreCajaTexto);
        System.out.println("value"+value);
    }


    @Then("^verifico que puedo ingresar a la pagina principal$")
    public void verificoQuePuedoIngresarALaPaginaPrincipal() {
        System.out.println("verificacion");
    }
}
