package US_208;

import java.time.Duration;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BaseDriver;

public class TC_208 {
    public static void main(String[] args) {
        WebDriver driver = BaseDriver.driver("https://demowebshop.tricentis.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5L));

        final String email = "tanerozcelik@gmail.com";
        final String password = "Pas..123";

        Actions actions = new Actions(driver);
        WebElement loginBtn = driver.findElement(By.xpath("//a[@class='ico-login']"));
        loginBtn.click();

        WebElement emailBtn = driver.findElement(By.id("Email"));
        emailBtn.sendKeys(email);

        WebElement passwordBtn = driver.findElement(By.id("Password"));
        passwordBtn.sendKeys(password);

        WebElement loginBtn2 = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        loginBtn2.click();

        WebElement computersBtn = driver.findElement(By.xpath("//div[@class='header-menu']//ul[@class='top-menu']//a[@href='/computers']"));
        wait.until(ExpectedConditions.visibilityOf(computersBtn));
        computersBtn.click();

        WebElement notebooks = driver.findElement(By.xpath("//div[contains(@class,'block-category-navigation')]//a[@href='/notebooks']"));
        wait.until(ExpectedConditions.visibilityOf(notebooks));
        notebooks.click();

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,100);");

        WebElement addCartBtn = driver.findElement(By.xpath("//input[@class='button-2 product-box-add-to-cart-button']"));
        addCartBtn.click();

        WebElement cartProduct = driver.findElement(By.xpath("//a[@class='ico-cart']//span[@class='cart-label']"));
        wait.until(ExpectedConditions.visibilityOf(cartProduct));
        cartProduct.click();

        WebElement couponBtn = driver.findElement(By.xpath("//input[@class='button-2 apply-discount-coupon-code-button']"));
        couponBtn.click();

        WebElement message = driver.findElement(By.xpath("//div[@class='message']"));
        Assert.assertTrue("Message not displayed", message.isDisplayed());

        WebElement giftCard = driver.findElement(By.xpath("//input[@class='button-2 apply-gift-card-coupon-code-button']"));
        giftCard.click();

        WebElement message1 = driver.findElement(By.xpath("//div[@class='message']"));
        Assert.assertTrue("Message1 not displayed", message1.isDisplayed());

        WebElement agreeCheckbox = driver.findElement(By.xpath("//input[@id='termsofservice']"));
        agreeCheckbox.click();

        WebElement checkOutBtn = driver.findElement(By.id("checkout"));
        checkOutBtn.click();

        WebElement addressChoice = driver.findElement(By.id("billing-address-select"));
        if (!addressChoice.getAttribute("value").isEmpty()) {
            WebElement submitBtn = driver.findElement(By.xpath("//*[@id='billing-buttons-container']/input"));
            wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
            submitBtn.click();
        }

        if (addressChoice.getAttribute("value").isEmpty()) {
            WebElement countryDropdown2 = driver.findElement(By.id("BillingNewAddress_CountryId"));
            countryDropdown2.sendKeys("UK");
            WebElement stateDropdown2 = driver.findElement(By.id("BillingNewAddress_StateProvinceId"));
            stateDropdown2.sendKeys("London");
            WebElement city = driver.findElement(By.id("BillingNewAddress_City"));
            city.sendKeys("UK");
            WebElement address1 = driver.findElement(By.id("BillingNewAddress_Address1"));
            address1.sendKeys("123");
            WebElement zipCode = driver.findElement(By.id("BillingNewAddress_ZipPostalCode"));
            zipCode.sendKeys("NBC123");
            WebElement phoneNumber = driver.findElement(By.id("BillingNewAddress_PhoneNumber"));
            phoneNumber.sendKeys("123456789");
            WebElement nextBtn1 = driver.findElement(By.cssSelector("input.button-1.new-address-next-step-button"));
            nextBtn1.click();
        }

        wait.until(ExpectedConditions.elementToBeClickable(By.id("PickUpInStore")));

        WebElement pickUpInStore = driver.findElement(By.id("PickUpInStore"));
        pickUpInStore.click();

        WebElement nextBtn2 = driver.findElement(By.cssSelector("#shipping-buttons-container > input"));
        nextBtn2.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("paymentmethod_2")));

        WebElement paymentMethod = driver.findElement(By.id("paymentmethod_2"));
        paymentMethod.click();

        WebElement nextBtn3 = driver.findElement(By.cssSelector("input.button-1.payment-method-next-step-button"));
        nextBtn3.click();
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

        WebElement nextBtn = driver.findElement(By.cssSelector("input.button-1.payment-info-next-step-button"));
        nextBtn.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#opc-confirm_order > div.step-title > h2")));
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#confirm-order-buttons-container > input")));

        WebElement confirm = driver.findElement(By.cssSelector("#confirm-order-buttons-container > input"));
        confirm.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.section.order-completed div.title")));

        WebElement successMessage = driver.findElement(By.cssSelector("div.section.order-completed div.title"));
        Assert.assertTrue("Order not successful", successMessage.getText().contains("Your order has been successfully processed!"));
        driver.quit();
    }
}
