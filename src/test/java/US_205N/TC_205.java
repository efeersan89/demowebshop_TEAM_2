package US_205N;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BaseDriver;

import java.time.Duration;

public class TC_205 {
    public static void main(String[] args) {
        //
        WebDriver driver = BaseDriver.driver("https://demowebshop.tricentis.com");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement homePageLoginBtn = driver.findElement(By.className("ico-login"));
        homePageLoginBtn.click();

        WebElement loginPageEmail = driver.findElement(By.id("Email"));
        wait.until(ExpectedConditions.visibilityOf(loginPageEmail));
        loginPageEmail.sendKeys("efeersan@gmail.com");

        WebElement loginPagePassword = driver.findElement(By.id("Password"));
        wait.until(ExpectedConditions.visibilityOf(loginPagePassword));
        loginPagePassword.sendKeys("Test12345678");

        WebElement loginButton = driver.findElement(By.cssSelector(".button-1.login-button"));
        loginButton.click();













    }

}
