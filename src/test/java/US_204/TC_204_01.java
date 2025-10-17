package US_204;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BaseDriver;

import java.time.Duration;

public class TC_204_01 {
    public static void main(String[] args) {
        WebDriver driver = BaseDriver.driver("https://demowebshop.tricentis.com");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement homePageLoginBtn = driver.findElement(By.className("ico-login"));
        homePageLoginBtn.click();

        WebElement loginPageEmail = driver.findElement(By.id("Email"));
        wait.until(ExpectedConditions.visibilityOf(loginPageEmail));
        loginPageEmail.sendKeys("efeersan@gmail.com");

        WebElement loginPagePassword = driver.findElement(By.id("Password"));
        wait.until(ExpectedConditions.visibilityOf(loginPagePassword));
        loginPagePassword.sendKeys("Test12345");

        WebElement loginPageLoginBtn = driver.findElement
                (By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input"));
        loginPageLoginBtn.click();

        driver.quit();



    }
}
