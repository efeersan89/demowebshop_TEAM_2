package US_209;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BaseDriver;

public class TC_209 {
    public static void main(String[] args) {
        WebDriver driver = BaseDriver.driver("https://demowebshop.tricentis.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5L));
        final String email = "tanerozcelik@gmail.com";
        final String password = "Pas..123";
        new Actions(driver);

        WebElement loginBtn = driver.findElement(By.xpath("//a[@class='ico-login']"));
        loginBtn.click();

        WebElement emailBtn = driver.findElement(By.id("Email"));
        emailBtn.sendKeys(email);

        WebElement passwordBtn = driver.findElement(By.id("Password"));
        passwordBtn.sendKeys(password);

        WebElement loginBtn1 = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        loginBtn1.click();

        WebElement myAccountBtn = driver.findElement(By.xpath("//div[@class='header-links']//a[@class='account']"));
        myAccountBtn.click();

        WebElement ordersBtn = driver.findElement(By.xpath("//ul[@class='list']//a[@href='/customer/orders']"));
        ordersBtn.click();

        WebElement ordersBtn1 = driver.findElement(By.xpath("//div[@class='order-list']//div[@class='section order-item']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='order-list']//div[@class='section order-item']")));

        WebElement details = driver.findElement(By.xpath("//div[@class='buttons']//input[@class='button-2 order-details-button']"));
        wait.until(ExpectedConditions.visibilityOf(details));
        details.click();

        WebElement invoiceBtn = driver.findElement(By.xpath("//a[@href='/orderdetails/print/2121181']"));
        wait.until(ExpectedConditions.elementToBeClickable(invoiceBtn));
        invoiceBtn.click();

        driver.quit();
    }
}
