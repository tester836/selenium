package webdriver_maintask;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;

public class SwitchTabsTest {
    private WebDriver driver;

    @Test
    public void tempTest(){

    driver = new ChromeDriver();
    driver.manage().window().maximize();

    driver.get("https://cloud.google.com");

    new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body")))
            .sendKeys(Keys.CONTROL +"t");
//        ((JavascriptExecutor)driver).executeScript("window.open()");
    ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());


    driver.switchTo().window(tabs.get(1));
    driver.get("https://yopmail.com/en/email-generator");
    driver.findElement(By.xpath(" //*[text()='Check Inbox']")).click();
    new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By
                .id("mail")));


    driver.switchTo().window(tabs.get(0));
    driver.findElement(By.xpath("//*[@ng-model='listingCtrl.computeServer.quantity']"))
            .sendKeys("4");
    }
}