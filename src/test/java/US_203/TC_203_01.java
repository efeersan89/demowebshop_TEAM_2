package US_203;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BaseDriver;

import java.time.Duration;

public class TC_203_01 {
    public static void main(String[] args) {

        //
        WebDriver driver = BaseDriver.driver("https://demowebshop.tricentis.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Login
        WebElement loginBtn = driver.findElement(By.className("ico-login"));
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        loginBtn.click();

        WebElement email = driver.findElement(By.id("Email"));
        wait.until(ExpectedConditions.visibilityOf(email));
        email.sendKeys("ruyatest123@gmail.com");

        WebElement password = driver.findElement(By.id("Password"));
        password.sendKeys("Test123*");

        WebElement submit = driver.findElement(By.cssSelector("input[value='Log in']"));
        wait.until(ExpectedConditions.elementToBeClickable(submit));
        submit.click();

        // Logout
        WebElement logoutBtn = driver.findElement(By.className("ico-logout"));
        wait.until(ExpectedConditions.elementToBeClickable(logoutBtn));
        logoutBtn.click();

        // Redirect
        String expectedUrl = "https://demowebshop.tricentis.com/login";
        String actualUrl = driver.getCurrentUrl();

        try {
            Assert.assertEquals("User not redirected to Login page.", expectedUrl, actualUrl);
            System.out.println("Step 5: PASS - Redirected to Login page");
        } catch (AssertionError e) {
            System.out.println("Step 5: FAIL - " + e.getMessage());
        }

        // Back
        driver.navigate().back();
        try {
            Assert.assertFalse("User should remain logged out.", driver.getCurrentUrl().contains("login"));
            System.out.println("Step 6: PASS - User remains logged out after back navigation");
        } catch (AssertionError e) {
            System.out.println("Step 6: FAIL - " + e.getMessage());
        }

        // User Data
        try {
            Assert.assertFalse("User data still visible!", driver.getPageSource().contains("testuser@example.com"));
            System.out.println("Step 7: PASS - User data cleared successfully");
        } catch (AssertionError e) {
            System.out.println("Step 7: FAIL - " + e.getMessage());
        }

        //
        driver.quit();
    }
}
