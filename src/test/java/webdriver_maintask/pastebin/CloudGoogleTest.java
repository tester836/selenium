package webdriver_maintask.pastebin;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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

//    @AfterMethod(alwaysRun = true)
//    public void browserClose() {
//        driver.quit();
//        driver = null;
//    }


    @Test (description = "'Hurt Me Plenty' test of Google Cloud")
    public void HurtMePlenty() {

        String searchText = "Google Cloud Platform Pricing Calculator";
        String numberOfInstances = "4";

        driver.get("https://cloud.google.com/");
        driver.findElement(By.name("q"))
                .sendKeys(searchText + Keys.ENTER);

        new WebDriverWait(driver, Duration.ofSeconds(60))
                .until(ExpectedConditions.elementToBeClickable(By
                        .xpath("//*[text()='Google Cloud Pricing Calculator']")))
                .click();

        new WebDriverWait(driver, Duration.ofSeconds(60))
                .until(ExpectedConditions.elementToBeClickable(By
                        .xpath("//div[@class='name ng-binding' and text()='Compute Engine']")))
               .click();

        driver.findElement(By.id("input_668"))
                .sendKeys(numberOfInstances);

        driver.findElement(By.id("select_value_label_660")).click();
        driver.findElement(By.id("select_option_670")).click();

        driver.findElement(By.id("select_value_label_661")).click();
        driver.findElement(By.id("select_option_683")).click();

        driver.findElement(By.id("select_value_label_663")).click();
        driver.findElement(By.id("select_option_846")).click();

        driver.findElement(By.id("select_value_label_664")).click();
        driver.findElement(By.id("select_option_1053")).click();

        driver.findElement(By.xpath("//*[@aria-label='Add GPUs' and @aria-checked='false']"))
                .click();
        driver.findElement(By.id("select_1126")).click();
        driver.findElement(By.id("select_option_1133")).click();





















    }

}
