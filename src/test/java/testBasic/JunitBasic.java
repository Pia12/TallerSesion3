package testBasic;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class JunitBasic {

    private AppiumDriver driver;

    @Before
    public void setUp() throws Exception {
        // set up appium
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Galaxy A70");
        capabilities.setCapability("platformVersion", "10");
        //capabilities.setCapability("deviceName", "Testing03");
       // capabilities.setCapability("platformVersion", "9.0");
        capabilities.setCapability("appPackage", "com.sec.android.app.popupcalculator");
        capabilities.setCapability("appActivity", ".Calculator");
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
    public void verifySumCalculator() throws InterruptedException {

        // Click botón 1
        //driver.findElement(By.id("com.google.android.calculator:id/digit_1")).click();
        driver.findElement(By.xpath("//android.widget.Button[@text='1']")).click();
        // Click botón +
        driver.findElement(By.xpath("//*[@resource-id='com.sec.android.app.popupcalculator:id/calc_keypad_btn_add']")).click();
        // Click botón 2
        driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_02")).click();
        // Click botón =
        driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_equal")).click();

        // Verificación
        // Resultado actual
        String actualResult=driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_edt_formula")).getText();
        // Resultado esperado
        String expectedResult="3";

        //Assert.assertEquals("ERROR CUANDO FALLE ","EXPECTED RESULT","ACTUAL RESULT");
        Assert.assertEquals("Error la suma es incorrecta, se esperaba :" +expectedResult,expectedResult,actualResult);
    }
}