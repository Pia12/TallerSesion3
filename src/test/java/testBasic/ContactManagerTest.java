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

/**
 * @autor : eynar.pari
 * @date : 01/08/2020.
 **/
public class ContactManagerTest {

    private AppiumDriver driver;

    @Before
    public void setUp() throws Exception {
        // configuracion appium
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("deviceName", "Testing03");
        capabilities.setCapability("platformVersion", "9.0");
        capabilities.setCapability("appPackage", "com.example.android.contactmanager");
        capabilities.setCapability("appActivity", ".ContactManager");
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
    public void agregarContancto() throws InterruptedException {

        String contacto="AAABRemove";
        //driver.findElement(By.id("com.android.permissioncontroller:id/continue_button")).click();
        // click OK
        driver.findElement(By.id("android:id/button1")).click();
        // click add contact
        driver.findElement(By.id("com.example.android.contactmanager:id/addContactButton")).click();
        // llenar datos contact name
        driver.findElement(By.xpath("//*[contains(@resource-id,'contactNameEditText')]")).sendKeys(contacto);
        // llenar datos contact phone
        driver.findElement(By.xpath("//*[contains(@resource-id,'contactPhone')]")).sendKeys("111222333444");
        // llenar datos contact emial
        driver.findElement(By.xpath("//*[contains(@resource-id,'contactEmail')]")).sendKeys("borrar@borrar.com");
        // click save
        driver.findElement(By.id("com.example.android.contactmanager:id/contactSaveButton")).click();
        // verificacion

        // contacto  - >  //*[@text='AARemove']

        // tiempo
        // Thread.sleep(5000);

        WebDriverWait explicitWait= new WebDriverWait(driver,15);
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='"+contacto+"']")));
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='"+contacto+"']")));

        Assert.assertTrue("Error , el contacto no fue creado",driver.findElement(By.xpath("//*[@text='"+contacto+"']")).isDisplayed());
    }
}
