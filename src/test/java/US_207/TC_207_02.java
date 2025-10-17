package US_207;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BaseDriver;

import java.time.Duration;

public class TC_207_02 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = BaseDriver.driver("https://demowebshop.tricentis.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement communityPollText = driver.findElement(By.xpath("//div[@class='block block-poll']/div/strong"));

        String expected = "COMMUNITY POLL";
        String actual = communityPollText.getText();

        Assert.assertEquals("Sayfaya ulaşılamadı", expected, actual);

        WebElement radioBtn = driver.findElement(By.xpath("(//ul[@class='poll-options']/li/input)[3]"));
        wait.until(ExpectedConditions.elementToBeClickable(radioBtn));
        radioBtn.click();

        WebElement voteBtn = driver.findElement(By.xpath("//input[@id='vote-poll-1']"));
        wait.until(ExpectedConditions.elementToBeClickable(voteBtn));
        voteBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='poll-vote-error'][id='block-poll-vote-error-1']")));
        WebElement notMesseage=driver.findElement(By.cssSelector("div[class='poll-vote-error'][id='block-poll-vote-error-1']"));
        Assert.assertTrue("Uyarı mesajı görüntülenemedi",notMesseage.isDisplayed());

        Thread.sleep(1000);
        driver.quit();
    }
}