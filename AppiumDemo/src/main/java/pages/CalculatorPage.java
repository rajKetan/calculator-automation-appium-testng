package pages;

import org.openqa.selenium.By;
import io.appium.java_client.android.AndroidDriver;

public class CalculatorPage {

    private AndroidDriver driver;

    // ===== Constructor =====
    public CalculatorPage(AndroidDriver driver) {
        this.driver = driver;
    }

    // ===== Locators =====
    private By digit8 = By.id("com.google.android.calculator:id/digit_8");
    private By digit2 = By.id("com.google.android.calculator:id/digit_2");

    private By add = By.id("com.google.android.calculator:id/op_add");
    private By sub = By.id("com.google.android.calculator:id/op_sub");
    private By mul = By.id("com.google.android.calculator:id/op_mul");
    private By div = By.id("com.google.android.calculator:id/op_div");

    private By equal = By.id("com.google.android.calculator:id/eq");
    private By result = By.id("com.google.android.calculator:id/result_final");

    // ===== Actions =====
    public void click8() {
        driver.findElement(digit8).click();
    }

    public void click2() {
        driver.findElement(digit2).click();
    }

    public void clickAdd() {
        driver.findElement(add).click();
    }

    public void clickSub() {
        driver.findElement(sub).click();
    }

    public void clickMul() {
        driver.findElement(mul).click();
    }

    public void clickDiv() {
        driver.findElement(div).click();
    }

    public void clickEqual() {
        driver.findElement(equal).click();
    }

    public String getResult() {
        return driver.findElement(result).getText();
    }
}
