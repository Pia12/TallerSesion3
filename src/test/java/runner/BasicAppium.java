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

/**
 * @autor : eynar.pari
 * @date : 08/08/2020.
 **/
public class BasicAppium {

    private AppiumDriver driver;

    @Given("^tengo abierto la aplicacion ContactManager$")
    public void tengoAbiertoLaAplicacionContactManager() throws MalformedURLException {
        // configuracion appium
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("deviceName", "EynarH");
        capabilities.setCapability("platformVersion", "9");
        capabilities.setCapability("appPackage", "com.example.android.contactmanager");
        capabilities.setCapability("appActivity", ".ContactManager");
        capabilities.setCapability("platformName", "Android");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @When("^hago click en el boton \\[OK\\] en el diaglo de actualizar$")
    public void hagoClickEnElBotonOKEnElDiagloDeActualizar() {

        // click OK
        driver.findElement(By.id("android:id/button1")).click();
    }

    @And("^hago click en el boton \\[Agregar Contacto\\] en ContactManager$")
    public void hagoClickEnElBotonAgregarContactoEnContactManager() {
        // click add contact
        driver.findElement(By.id("com.example.android.contactmanager:id/addContactButton")).click();
    }

    @And("^lleno el textbox \\[(contact name|contact phone|contact emial)\\] con el valor : (.*)$")
    public void llenoElTextboxContactNameConElValorAAABRemove(String control,String valor) {

        switch (control){
            case "contact name":
                // llenar datos contact name
                driver.findElement(By.xpath("//*[contains(@resource-id,'contactNameEditText')]")).sendKeys(valor);
                break;
            case "contact phone":
                // llenar datos contact phone
                driver.findElement(By.xpath("//*[contains(@resource-id,'contactPhone')]")).sendKeys(valor);
                break;
            case "contact emial":
                // llenar datos contact emial
                driver.findElement(By.xpath("//*[contains(@resource-id,'contactEmail')]")).sendKeys(valor);
                break;

        }

    }


    @And("^hago click en el boton \\[save\\] en ContacManager$")
    public void hagoClickEnElBotonSaveEnContacManager() {
        // click save
        driver.findElement(By.id("com.example.android.contactmanager:id/contactSaveButton")).click();
    }

    @Then("^verifico que el contacto : (.*) es mostrado$")
    public void verificoQueElContactoAAABRemoveEsMostrado(String value) {
        WebDriverWait explicitWait=  new WebDriverWait(driver,15);
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='"+value+"']")));
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='"+value+"']")));

        Assert.assertTrue("Error , el contacto no fue creado",driver.findElement(By.xpath("//*[@text='"+value+"']")).isDisplayed());

    }

    @And("^cierro ContactManager en mi dispositivo celular$")
    public void cierroContactManagerEnMiDispositivoCelular() {
        driver.quit();
    }
}
