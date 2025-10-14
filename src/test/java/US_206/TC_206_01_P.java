package US_206;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class TC_206_01_P {
    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("autofill.credit_card_enabled", false);
        prefs.put("autofill.profile_enabled", false);
        options.setExperimentalOption("prefs", prefs);

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("https://demowebshop.tricentis.com/");
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

        WebElement featuredProduct = driver.findElement(By.cssSelector("div[class='product-item'][data-productid='31']"));
        wait.until(ExpectedConditions.visibilityOf(featuredProduct));

        //
        WebElement addToCartBtn = driver.findElement(By.xpath("//div[@data-productid='31']/div[2]/div[3]/div[2]/input"));
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));
        addToCartBtn.click();
        addToCartBtn.sendKeys(Keys.ENTER);

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
        WebElement agreeCheckbox = driver.findElement(By.id("termsofservice"));
        agreeCheckbox.click();

        //
        WebElement checkOutBtn = driver.findElement(By.id("checkout"));
        checkOutBtn.click();

        //
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#opc-billing > div.step-title > h2")));

        WebElement addressChoice = driver.findElement(By.id("billing-address-select"));

        if (!addressChoice.getAttribute("value").isEmpty()){
            WebElement submitBtn = driver.findElement(By.xpath("//*[@id='billing-buttons-container']/input"));
            wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
            submitBtn.click();
        }

        if (addressChoice.getAttribute("value").isEmpty()) {

            WebElement countryDropdown2 = driver.findElement(By.id("BillingNewAddress_CountryId"));
            countryDropdown2.sendKeys("United States");
            WebElement stateDropdown2 = driver.findElement(By.id("BillingNewAddress_StateProvinceId"));
            stateDropdown2.sendKeys("New York");

            WebElement city = driver.findElement(By.id("BillingNewAddress_City"));
            city.sendKeys("NYC");
            WebElement address1 = driver.findElement(By.id("BillingNewAddress_Address1"));
            address1.sendKeys("123 Main St");
            WebElement zipCode = driver.findElement(By.id("BillingNewAddress_ZipPostalCode"));
            zipCode.sendKeys("10001");
            WebElement phoneNumber = driver.findElement(By.id("BillingNewAddress_PhoneNumber"));
            phoneNumber.sendKeys("1234567890");
            WebElement nextBtn1 = driver.findElement(By.cssSelector("input.button-1.new-address-next-step-button"));
            nextBtn1.click();
        }

        //
        wait.until(ExpectedConditions.elementToBeClickable(By.id("PickUpInStore")));
        WebElement pickUpInStore = driver.findElement(By.id("PickUpInStore"));
        pickUpInStore.click();

        WebElement nextBtn2 = driver.findElement(By.cssSelector("#shipping-buttons-container > input"));
        nextBtn2.click();

        //
        wait.until(ExpectedConditions.elementToBeClickable(By.id("paymentmethod_2")));
        WebElement paymentMethod = driver.findElement(By.id("paymentmethod_2"));
        paymentMethod.click();
        WebElement nextBtn3 = driver.findElement(By.cssSelector("input.button-1.payment-method-next-step-button"));
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#opc-confirm_order > div.step-title > h2")));

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        //
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#confirm-order-buttons-container > input")));
        WebElement confirm = driver.findElement(By.cssSelector("#confirm-order-buttons-container > input"));
        confirm.click();

        //
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.section.order-completed div.title")));
        WebElement successMessage = driver.findElement(By.cssSelector("div.section.order-completed div.title"));
        Assert.assertTrue("Order not successful", successMessage.getText().contains("Your order has been successfully processed!"));

        //
        driver.quit();
    }
}