package Demo;

import java.net.URI;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class AutomateCalc {

    public static void main(String[] args) throws Exception {

        // Desired Capabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("deviceName", "motorola motorola edge 60 fusion");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName", "uiautomator2");
        capabilities.setCapability("platformVersion", "16");
        capabilities.setCapability("appPackage", "com.google.android.calculator");
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

        URL url = URI.create("http://127.0.0.1:4723/").toURL();
        AndroidDriver driver = new AndroidDriver(url, capabilities);

        Thread.sleep(5000);
        System.out.println("Application Started");

        // ================= ADDITION (8 + 2 = 10) =================
        performOperation(driver,
                "Addition",
                "com.google.android.calculator:id/op_add",
                "10");

        // ================= SUBTRACTION (8 - 2 = 6) =================
        performOperation(driver,
                "Subtraction",
                "com.google.android.calculator:id/op_sub",
                "6");

        // ================= MULTIPLICATION (8 * 2 = 16) =================
        performOperation(driver,
                "Multiplication",
                "com.google.android.calculator:id/op_mul",
                "16");

        // ================= DIVISION (8 / 2 = 4) =================
        performOperation(driver,
                "Division",
                "com.google.android.calculator:id/op_div",
                "4");

        driver.quit();
    }

    // ================= COMMON METHOD =================
    public static void performOperation(AndroidDriver driver,
                                        String operationName,
                                        String operatorId,
                                        String expectedResult) throws InterruptedException {

        // Clear calculator
        driver.findElement(By.id("com.google.android.calculator:id/clr")).click();
        Thread.sleep(1000);

        // 8
        driver.findElement(By.id("com.google.android.calculator:id/digit_8")).click();

        // Operator
        driver.findElement(By.id(operatorId)).click();

        // 2
        driver.findElement(By.id("com.google.android.calculator:id/digit_2")).click();

        // =
        driver.findElement(By.id("com.google.android.calculator:id/eq")).click();
        Thread.sleep(2000);

        // Result
        WebElement result = driver.findElement(
                By.id("com.google.android.calculator:id/result_final"));

        String actualResult = result.getText();

        if (actualResult.equals(expectedResult)) {
            System.out.println(operationName + " : PASS");
        } else {
            System.out.println(operationName + " : FAIL (Expected "
                    + expectedResult + ", Got " + actualResult + ")");
        }
    }
}
