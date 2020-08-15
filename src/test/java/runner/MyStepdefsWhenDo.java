package runner;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class MyStepdefsWhenDo {

    private AppiumDriver driver;
    @Given("^tengo abierta la aplicacion WhenDo$")
    public void tengoAbiertaLaAplicacionWhenDo() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("deviceName", "Galaxy A70");
        capabilities.setCapability("platformVersion", "10");
        capabilities.setCapability("appPackage", "com.vrproductiveapps.whendo");
        capabilities.setCapability("appActivity", ".ui.HomeActivity");
        capabilities.setCapability("platformName", "Android");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @When("^hago tab en el boton \\[\\+\\] de la parte inferior de la lista$")
    public void hagoTabEnElBotonDeLaParteInferiorDeLaLista() {
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/fab")).click();
    }

    @And("^lleno el textbox \\[(Titulo|Notas)\\] con el valor : (.*)$")
    public void llenoElTextboxTituloConElValorTaller(String control, String valor) {
        switch (control){
            case "Titulo":
                // llenar datos titulo
                driver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextTitle")).sendKeys(valor);
                break;
            case "Notas":
                // llenar datos notas
                driver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextNotes")).sendKeys(valor);
                break;

        }
    }

    @And("^hago tab en el boton \\[Guardar\\] en pantalla Mi Lista$")
    public void hagoTabEnElBotonGuardarEnPantallaMiLista() {
        //click guardar
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/saveItem")).click();

      }

    @Then("^verifico que el Titulo : (.*) es mostrado$")
    public void verificoQueElTituloTallerEsMostrado(String value) {
        WebDriverWait explicitWait= new WebDriverWait(driver,15);
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='"+value+"']")));
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='"+value+"']")));

        Assert.assertTrue("Error , el titulo no fue creado",driver.findElement(By.xpath("//*[@text='"+value+"']")).isDisplayed());

    }

    @And("^verifico que la Nota : (.*) es mostrado$")
    public void verificoQueLaNotaContenidoTallerEsMostrado(String value) {
        WebDriverWait explicitWait= new WebDriverWait(driver,15);
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='"+value+"']")));
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='"+value+"']")));

        Assert.assertTrue("Error , la nota no fue creada",driver.findElement(By.xpath("//*[@text='"+value+"']")).isDisplayed());
    }

    @And("^cierro WhenDo en mi dispositivo celular$")
    public void cierroWhenDoEnMiDispositivoCelular() {
        driver.quit();
    }
}
