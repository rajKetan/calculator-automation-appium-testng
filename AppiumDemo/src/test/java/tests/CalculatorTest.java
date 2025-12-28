package tests;

import java.net.URI;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.CalculatorPage;

public class CalculatorTest {

    AndroidDriver driver;
    CalculatorPage calc;

    @BeforeClass
    public void setUp() throws Exception {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "motorola motorola edge 60 fusion");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName", "uiautomator2");
        capabilities.setCapability("platformVersion", "16");
        capabilities.setCapability("appPackage", "com.google.android.calculator");
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

        driver = new AndroidDriver(
                URI.create("http://127.0.0.1:4723/").toURL(),
                capabilities
        );

        calc = new CalculatorPage(driver);
        Thread.sleep(3000);
    }

    @Test
    public void testAddition() {
        calc.click8();
        calc.clickAdd();
        calc.click2();
        calc.clickEqual();
        Assert.assertEquals(calc.getResult(), "10", "Addition Failed");
    }

    @Test
    public void testSubtraction() {
        calc.click8();
        calc.clickSub();
        calc.click2();
        calc.clickEqual();
        Assert.assertEquals(calc.getResult(), "6", "Subtraction Failed");
    }

    @Test
    public void testMultiplication() {
        calc.click8();
        calc.clickMul();
        calc.click2();
        calc.clickEqual();
        Assert.assertEquals(calc.getResult(), "16", "Multiplication Failed");
    }

    @Test
    public void testDivision() {
        calc.click8();
        calc.clickDiv();
        calc.click2();
        calc.clickEqual();
        Assert.assertEquals(calc.getResult(), "4", "Division Failed");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
