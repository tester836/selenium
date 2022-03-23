package webdriver_maintask.pastebin;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;



public class CloudGoogleTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserOpen() {
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
    }

    @AfterMethod(alwaysRun = true)
    public void browserClose() {
        driver.quit();
        driver = null;
    }


    @Test (description = "'Hurt Me Plenty' test of Google Cloud")
    public void HurtMePlenty() {

//        driver.get("https://cloud.google.com/");
//        driver.findElement(By.name("q"))
//                .sendKeys("Google Cloud Platform Pricing Calculator" + Keys.ENTER);
//
//        new WebDriverWait(driver, Duration.ofSeconds(30))
//                .until(ExpectedConditions.elementToBeClickable(By
//                        .xpath("//*[@class='gs-title' and @data-ctorig='https://cloud.google.com/products/calculator']")))
//                .click();

        driver.get("https://cloud.google.com/products/calculator");//debug

//        new WebDriverWait(driver, Duration.ofSeconds(10))
//                .until(ExpectedConditions.elementToBeClickable(By
//                        .xpath("//*[@title='Compute Engine' and @class='tab-holder compute']")))
//                .click();



        new WebDriverWait(driver, Duration.ofSeconds(60)).until(ExpectedConditions.elementToBeClickable(By
                        .name("quantity")))
                .sendKeys("4");

//        driver.findElement(By.id("select_value_label_72")).click();
        driver.findElement(By.xpath("//md-option[@value='free']")).click();

//        driver.findElement(By.id("select_value_label_73")).click();
        driver.findElement(By.xpath("//md-option[@value='regular']")).click();

//        driver.findElement(By.id("select_value_label_663")).click();
        driver.findElement(By.xpath("//md-option[@value='n1']")).click();

//        driver.findElement(By.id("select_value_label_664")).click();
        driver.findElement(By.xpath("//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']")).click();

        driver.findElement(By.xpath("//*[@aria-label='Add GPUs' and @aria-checked='false']")).click();
        driver.findElement(By.id("select_1126")).click();
        driver.findElement(By.id("select_option_1133")).click();

        driver.findElement(By.id("select_value_label_455")).click();
        driver.findElement(By.id("select_option_481")).click();

        driver.findElement(By.id("select_value_label_417")).click();
        driver.findElement(By.id("select_option_444")).click();

        driver.findElement(By.id("select_value_label_78")).click();
        driver.findElement(By.id("select_option_241")).click();

        driver.findElement(By.id("select_value_label_79")).click();
        driver.findElement(By.id("select_option_118")).click();

        driver.findElement(By.xpath("//button[@aria-label='Add to Estimate']")).click();


    }

}
