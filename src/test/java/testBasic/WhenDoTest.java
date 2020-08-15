package testBasic;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class WhenDoTest {
    private AppiumDriver driver;

    @Before
    public void setUp() throws Exception {
        // configuracion appium
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("deviceName", "Galaxy A70");
        capabilities.setCapability("platformVersion", "10");
        capabilities.setCapability("appPackage", "com.vrproductiveapps.whendo");
        capabilities.setCapability("appActivity", ".ui.HomeActivity");
        capabilities.setCapability("platformName", "Android");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @After
    public void tearDown() throws Exception {
        // cerrar sesion
        driver.quit();
    }
    @Test
    public void verifyLista() throws InterruptedException {
        String titulo="Pia";

        // Click en boton +
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/fab")).click();
        // Agregar titulo
         driver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextTitle")).sendKeys(titulo);
        // Agregar notas
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextNotes")).sendKeys("Contenido");
        // Click Guardar
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/saveItem")).click();

        // Verificación

        WebDriverWait explicitWait= new WebDriverWait(driver,15);
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='"+titulo+"']")));
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='"+titulo+"']")));

        Assert.assertTrue("Error , el contacto no fue creado",driver.findElement(By.xpath("//*[@text='"+titulo+"']")).isDisplayed());

    }

}
