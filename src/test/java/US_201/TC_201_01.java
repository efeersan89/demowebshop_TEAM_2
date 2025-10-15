package US_201;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BaseDriver;

import java.time.Duration;

public class TC_201_01 {
    public static void main(String[] args) {

        //
        WebDriver driver = BaseDriver.driver("https://demowebshop.tricentis.com");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        //
        WebElement homePageRegister = driver.findElement(By.className("ico-register"));

        homePageRegister.click();

        //
        WebElement gender = driver.findElement(By.id("gender-male"));
        wait.until(ExpectedConditions.visibilityOf(gender));
        gender.click();

        //
        WebElement firstName = driver.findElement(By.id("FirstName"));
        wait.until(ExpectedConditions.visibilityOf(firstName));
        firstName.sendKeys("efe");

        //
        WebElement lastName = driver.findElement(By.id("LastName"));
        wait.until(ExpectedConditions.visibilityOf(lastName));
        lastName.sendKeys("ersan");

        //
        WebElement email = driver.findElement(By.id("Email"));
        wait.until(ExpectedConditions.visibilityOf(email));
        email.sendKeys("efeersan@gmail.com");

        //
        WebElement password = driver.findElement(By.id("Password"));
        wait.until(ExpectedConditions.visibilityOf(password));
        password.sendKeys("Test12345");

        //
        WebElement confirmPassword = driver.findElement(By.id("ConfirmPassword"));
        wait.until(ExpectedConditions.visibilityOf(confirmPassword));
        confirmPassword.sendKeys("Test12345");


        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement clickRegister = driver.findElement(By.id("register-button"));
        clickRegister.click();
















    }
}
