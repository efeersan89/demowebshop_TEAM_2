package US_207;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BaseDriver;

import java.time.Duration;

public class TC_207_01 {
    public static void main(String[] args) {
        WebDriver driver = BaseDriver.driver("https://demowebshop.tricentis.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement loginBtn = driver.findElement(By.className("ico-login"));
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        loginBtn.click();

        WebElement email = driver.findElement(By.id("Email"));
        wait.until(ExpectedConditions.visibilityOf(email));
        email.sendKeys("testerasli90@gmail.com");

        WebElement password = driver.findElement(By.id("Password"));
        password.sendKeys("12345678n.");

        WebElement submit = driver.findElement(By.cssSelector("input[value='Log in']"));
        wait.until(ExpectedConditions.elementToBeClickable(submit));
        submit.click();

        WebElement communityPollText = driver.findElement(By.xpath("//div[@class='block block-poll']/div/strong"));

        String expected = "COMMUNITY POLL";
        String actual = communityPollText.getText();

        Assert.assertEquals("Sayfaya ulaşılamadı", expected, actual);

        WebElement radioBtn = driver.findElement(By.xpath("//input[@id='pollanswers-2']"));
        wait.until(ExpectedConditions.elementToBeClickable(radioBtn));
        radioBtn.click();

        WebElement voteBtn = driver.findElement(By.xpath("//input[@id='vote-poll-1']"));
        wait.until(ExpectedConditions.elementToBeClickable(voteBtn));
        voteBtn.click();

        WebElement result = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[contains(text(),'Excellent')]")));
        System.out.println(result);

        String expectedText = "Good";
        String actualText = result.getText();
        System.out.println(actualText);

        Assert.assertTrue(actualText.contains(expectedText));

        driver.quit();
    }
    }