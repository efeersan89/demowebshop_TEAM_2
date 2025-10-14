package US_206;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BaseDriver;

import java.time.Duration;

public class TC_206_02_N {
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

        //
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        WebElement featuredProduct = driver.findElement(By.cssSelector("div[class='product-item'][data-productid='31']"));
        wait.until(ExpectedConditions.visibilityOf(featuredProduct));

        //
        WebElement addToCartBtn = driver.findElement(By.xpath("//div[@data-productid='31']/div[2]/div[3]/div[2]/input"));
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));
        addToCartBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#bar-notification > p")));

        actions.sendKeys(Keys.PAGE_UP).perform();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#bar-notification > p")));

        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("span.cart-qty"), "1"));
        WebElement cartQty = driver.findElement(By.cssSelector("span.cart-qty"));
        Assert.assertTrue("Product not added to cart", cartQty.getText().contains("1"));

        //
        WebElement cart = driver.findElement(By.xpath("//*[@id='topcartlink']/a"));
        wait.until(ExpectedConditions.elementToBeClickable(cart));
        cart.click();

        WebElement cartPage = driver.findElement(By.cssSelector("div.page-title h1"));
        Assert.assertTrue("Cart page not displayed", cartPage.isDisplayed());

        //
        WebElement countryDropdown = driver.findElement(By.id("CountryId"));
        countryDropdown.sendKeys("United States");
        WebElement stateDropdown = driver.findElement(By.id("StateProvinceId"));
        stateDropdown.sendKeys("New York");

        //
        WebElement checkOutBtn = driver.findElement(By.id("checkout"));
        checkOutBtn.click();

        //
        WebElement termsCheckbox = driver.findElement(By.id("terms-of-service-warning-box"));
        Assert.assertFalse("Terms of service warning displayed", termsCheckbox.isDisplayed());

        //
        driver.quit();

    }
}
