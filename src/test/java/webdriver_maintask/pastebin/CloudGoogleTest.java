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

        String vmClassInput = "VM class: regular";
        String instanceTypeInput = "Instance type: n1-standard-8";
        String regionInput = "Region: Frankfurt";
        String ssdInput = "Local SSD: 2x375 GiB";
        String totalCostPerMonthInput = "Total Estimated Cost:\n USD 4,559.11\n per 1 month";


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
//        driver.findElement(By.xpath("//*[@aria-label='GPU type']")).click();
        driver.findElement(By.xpath("//md-option[@value='NVIDIA_TESLA_T4']")).click(); // for now, NVIDIA_TESLA_V100 is disabled

        driver.findElement(By.xpath("//*[@aria-label='Number of GPUs']")).click();
        driver.findElement(By.xpath("//*[contains(@ng-repeat, 'GpuNumbers') and @value='1']")).click();

        driver.findElement(By.xpath("//*[starts-with(@aria-label,'Local SSD')]")).click();
        driver.findElement(By.xpath("//*[contains(@ng-repeat, 'dynamicSsd.computeServer') and @value='2']")).click();

        driver.findElement(By.xpath("//*[starts-with(@aria-label,'Datacenter location')]")).click();
        driver.findElement(By.xpath("//md-option[@value='europe-west3']")).click();

        driver.findElement(By.xpath("//*[starts-with(@aria-label,'Committed usage')]")).click();
        driver.findElement(By.xpath("//*[@class='md-ink-ripple' and @value='1']")).click();

        driver.findElement(By.xpath("//button[@aria-label='Add to Estimate']")).click();


        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(By
                .id("resultBlock")));


        WebElement vmClassOutput = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By
                        .xpath("//*[contains(text(), 'regular') and @class='md-list-item-text ng-binding']")));
            System.out.println(vmClassOutput.getText());
        Assert.assertEquals(vmClassInput, vmClassOutput.getText(), "VM Class is displayed incorrectly.");


        WebElement instanceTypeOutput = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By
                        .xpath("//*[contains(text(), 'n1-standard-8') and @class='md-list-item-text ng-binding cpc-cart-multiline flex']")));
            System.out.println(instanceTypeOutput.getText());
        Assert.assertEquals(instanceTypeInput, instanceTypeOutput.getText(), "Instance type is displayed incorrectly.");


        WebElement regionOutput = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By
                        .xpath("//*[contains(text(), 'Frankfurt') and @class='md-list-item-text ng-binding']")));
            System.out.println(regionOutput.getText());
        Assert.assertEquals(regionInput, regionOutput.getText(), "Region is displayed incorrectly.");


        WebElement ssdOutput = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By
                        .xpath("//*[contains(text(), 'SSD') and @class='md-list-item-text ng-binding flex']")));
        System.out.println(ssdOutput.getText());
        Assert.assertEquals(ssdInput, ssdOutput.getText(), "Local SSD is displayed incorrectly.");


        WebElement totalCostPerMonthOutput = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By
                        .xpath("//*[contains(text(), 'Total Estimated Cost') and @class='ng-binding']")));
        System.out.println(totalCostPerMonthOutput.getText());
        Assert.assertEquals(totalCostPerMonthInput, totalCostPerMonthOutput.getText(), "Local SSD is displayed incorrectly.");

    }

}
