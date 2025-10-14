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

public class TC_206_01_P {
    public static void main(String[] args) throws InterruptedException {

        //
        WebDriver driver = BaseDriver.driver("https://demowebshop.tricentis.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        //
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

        WebElement productName = driver.findElement(By.xpath("//div[2]/h2/a[@href='/141-inch-laptop']"));
        Assert.assertTrue("Product details not displayed", productName.isDisplayed());

        //
        WebElement addToCartBtn = driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div.master-wrapper-main > div.center-3 > div > div > div.product-grid.home-page-product-grid > div:nth-child(3) > div > div.details > div.add-info > div.buttons > input"));
        addToCartBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#bar-notification > p")));

        actions.sendKeys(Keys.PAGE_UP).perform();

        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("span.cart-qty"), "1"));
        WebElement cartQty = driver.findElement(By.cssSelector("span.cart-qty"));
        Assert.assertTrue("Product not added to cart", cartQty.getText().contains("1"));

        //
        WebElement cart = driver.findElement(By.className("ico-cart"));
        cart.click();

        WebElement cartPage = driver.findElement(By.cssSelector("div.page-title h1"));
        Assert.assertTrue("Cart page not displayed", cartPage.isDisplayed());

        //
        WebElement countryDropdown = driver.findElement(By.id("CountryId"));
        countryDropdown.sendKeys("United States");
        WebElement stateDropdown = driver.findElement(By.id("StateProvinceId"));
        stateDropdown.sendKeys("New York");

        //
        WebElement agreeCheckbox = driver.findElement(By.id("termsofservice"));
        agreeCheckbox.click();

        //
        WebElement checkOutBtn = driver.findElement(By.id("checkout"));
        checkOutBtn.click();

        //
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("billing-address-select")));
        WebElement nextBtn = driver.findElement(By.cssSelector("#billing-buttons-container > input"));
        nextBtn.click();

        //
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("BillingNewAddress_City")));
        driver.findElement(By.id("BillingNewAddress_City")).sendKeys("NYC");
        driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("123 Main St");
        driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("10001");
        driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("1234567890");
        WebElement nextBtn1 = driver.findElement(By.cssSelector("input.button-1.new-address-next-step-button"));
        nextBtn1.click();

        //
        wait.until(ExpectedConditions.elementToBeClickable(By.id("PickUpInStore")));
        WebElement pickUpInStore = driver.findElement(By.id("PickUpInStore"));
        pickUpInStore.click();

        WebElement nextBtn2 = driver.findElement(By.cssSelector("input.button-1.shipping-method-next-step-button"));
        nextBtn2.click();

        //
        wait.until(ExpectedConditions.elementToBeClickable(By.id("paymentmethod_1")));
        WebElement paymentMethod =driver.findElement(By.id("paymentmethod_1"));
        paymentMethod.click();
        WebElement nextBtn3 =driver.findElement(By.cssSelector("input.button-1.payment-method-next-step-button"));
        nextBtn3.click();

        //
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CardholderName")));
        WebElement cardHolderName = driver.findElement(By.id("CardholderName"));
        cardHolderName.sendKeys("Test Tester");
        WebElement cardNumber = driver.findElement(By.id("CardNumber"));
        cardNumber.sendKeys("4242424242424242");
        WebElement expireMonth = driver.findElement(By.id("ExpireMonth"));
        expireMonth.sendKeys("01");
        WebElement expireYear = driver.findElement(By.id("ExpireYear"));
        expireYear.sendKeys("2032");
        WebElement cardCode = driver.findElement(By.id("CardCode"));
        cardCode.sendKeys("123");

        WebElement nextBtn4 = driver.findElement(By.cssSelector("input.button-1.payment-info-next-step-button"));
        nextBtn4.click();

        //
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.value-summary")));
        WebElement totalPriceElement = driver.findElement(By.cssSelector("span.value-summary"));
        String totalPrice = totalPriceElement.getText();
        System.out.println("Step 13: Total Price = " + totalPrice);


        //
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input.button-1.confirm-order-next-step-button")));
        WebElement confirm = driver.findElement(By.cssSelector("input.button-1.confirm-order-next-step-button"));
        confirm.click();

        //
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.section.order-completed div.title")));
        WebElement successMessage = driver.findElement(By.cssSelector("div.section.order-completed div.title"));
        Assert.assertTrue("Order not successful", successMessage.getText().contains("Your order has been successfully processed!"));

        //
        driver.quit();
    }
}
