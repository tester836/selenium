package webdriver_maintask;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;



public class CloudGoogleTest {
    private WebDriver driver;
    private final Logger logger = LogManager.getRootLogger();

    @BeforeMethod(alwaysRun = true)
    public void browserOpen() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void browserClose() {
        driver.quit();
        driver = null;
    }

    @Test (description = "'Hurt Me Plenty' and 'Hardcore' tests of Google Cloud")
    public void HurtMePlenty() {

        String baseUrl = "https://cloud.google.com/"; //"https://cloud.google.com/products/calculator"
        String machineClassExpected = "VM class: regular";
        String instanceTypeExpected = "Instance type: n1-standard-8";
        String regionExpected = "Region: Frankfurt";
        String ssdExpected = "Local SSD: 2x375 GiB";
        String totalCostPerMonthExpected = "Total Estimated Cost:\n USD 4,026.13\n per 1 month";
        String totalCostExpected = "Total Estimated Monthly Cost USD 4,026.13";

        By searchQueryLocator = By.name("q");
        String searchText = "Google Cloud Platform Pricing Calculator";
        By calculatorPageLocator = By.xpath("//*[@class='gs-title' and @data-ctorig='https://cloud.google.com/products/calculator']");
        By numberOfInstancesLocator = By.xpath("//*[@ng-model='listingCtrl.computeServer.quantity']");
        String numberOfInstances = "4";
        By operatingSystemLocator = By.xpath("//md-option[@value='free']");
        By vmClassLocator = By.xpath("//md-option[@value='regular']");
        By instanceSeriesLocator = By.xpath("//md-option[@value='n1']");
        By instanceTypeLocator = By.xpath("//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']");
        By addGPUsLocator = By.xpath("//*[@aria-label='Add GPUs' and @aria-checked='false']");
        By gpuTypeLocator = By.xpath("//md-option[@value='NVIDIA_TESLA_P100']");
        By numberOfGPUsMenuLocator = By.xpath("//*[@aria-label='Number of GPUs']");
        By numberOfGPUsLocator = By.xpath("//*[contains(@ng-repeat, 'GpuNumbers') and @value='1']");
        By localSSDmenuLocator = By.xpath("//*[starts-with(@aria-label,'Local SSD')]");
        By localSSDLocator = By.xpath("//*[contains(@ng-repeat, 'dynamicSsd.computeServer') and @value='2']");
        By datacenterLocationMenuLocator = By.xpath("//*[starts-with(@aria-label,'Datacenter location')]");
        By datacenterLocationLocator = By.xpath("//md-option[@value='europe-west3']");
        By committedUsageMenuLocator = By.xpath("//*[starts-with(@aria-label,'Committed usage')]");
        By committedUsageLocator = By.xpath("//*[@class='md-ink-ripple' and @value='1']");
        By addToEstimateLocator = By.xpath("//button[@aria-label='Add to Estimate']");
        By resultsLocator = By.id("resultBlock");
        By machineClassActualLocator = By.xpath("//*[contains(text(), 'regular') and @class='md-list-item-text ng-binding']");
        By instanceTypeActualLocator = By.xpath("//*[contains(text(), 'n1-standard-8') and @class='md-list-item-text ng-binding cpc-cart-multiline flex']");
        By regionActualLocator = By.xpath("//*[contains(text(), 'Frankfurt') and @class='md-list-item-text ng-binding']");
        By ssdActualLocator = By.xpath("//*[contains(text(), 'SSD') and @class='md-list-item-text ng-binding flex']");
        By totalCostPerMonthActualLocator = By.xpath("//*[contains(text(), 'Total Estimated Cost') and @class='ng-binding']");


        driver.get(baseUrl);
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions
                .visibilityOfElementLocated(searchQueryLocator))
                .sendKeys(searchText + Keys.ENTER);

        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions
                .elementToBeClickable(calculatorPageLocator)).click();

        driver.findElement(numberOfInstancesLocator).sendKeys(numberOfInstances);
        driver.findElement(operatingSystemLocator).click();
        driver.findElement(vmClassLocator).click();
        driver.findElement(instanceSeriesLocator).click();
        driver.findElement(instanceTypeLocator).click();
        driver.findElement(addGPUsLocator).click();
        driver.findElement(gpuTypeLocator).click();
        driver.findElement(numberOfGPUsMenuLocator).click();
        driver.findElement(numberOfGPUsLocator).click();
        driver.findElement(localSSDmenuLocator).click();
        driver.findElement(localSSDLocator).click();
        driver.findElement(datacenterLocationMenuLocator).click();
        driver.findElement(datacenterLocationLocator).click();
        driver.findElement(committedUsageMenuLocator).click();
        driver.findElement(committedUsageLocator).click();
        driver.findElement(addToEstimateLocator).click();


        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions
                .visibilityOfElementLocated(resultsLocator));

        WebElement machineClassActual = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions
                .visibilityOfElementLocated(machineClassActualLocator));
        logger.info(machineClassActual.getText());
        Assert.assertEquals(machineClassExpected, machineClassActual.getText(), "VM Class is displayed incorrectly.");


        WebElement instanceTypeActual = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions
                .visibilityOfElementLocated(instanceTypeActualLocator));
        logger.info(instanceTypeActual.getText());
        Assert.assertEquals(instanceTypeExpected, instanceTypeActual.getText(), "Instance type is displayed incorrectly.");


        WebElement regionActual = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions
                .visibilityOfElementLocated(regionActualLocator));
        logger.info(regionActual.getText());
        Assert.assertEquals(regionExpected, regionActual.getText(), "Region is displayed incorrectly.");


        WebElement ssdActual = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions
                .visibilityOfElementLocated(ssdActualLocator));
        logger.info(ssdActual.getText());
        Assert.assertEquals(ssdExpected, ssdActual.getText(), "Local SSD is displayed incorrectly.");


        WebElement totalCostPerMonthActual = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions
                .visibilityOfElementLocated(totalCostPerMonthActualLocator));
        logger.info(totalCostPerMonthActual.getText());
        Assert.assertEquals(totalCostPerMonthExpected, totalCostPerMonthActual.getText(), "Total cost is displayed incorrectly.");


        //Hardcore Test
        driver.findElement(By.xpath("//*[@id='email_quote']")).click();

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By
                    .name("emailForm")));

        ((JavascriptExecutor)driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());


        driver.switchTo().window(tabs.get(1));
        driver.get("https://yopmail.com/en/email-generator");

        WebElement emailGenerated = new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(By
                .id("egen")));
        logger.info(emailGenerated.getText());


        driver.switchTo().window(tabs.get(0));
        driver.findElement(By.xpath("//input[@type='email']"))
                .sendKeys(emailGenerated.getText());
        driver.findElement(By.xpath("//button[@aria-label='Send Email']")).click();


        driver.switchTo().window(tabs.get(1));
        driver.findElement(By.xpath(" //*[text()='Check Inbox']")).click();

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By
                .id("mail")));

        WebElement totalCostTitleFromEmail = new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(By
                .xpath("//h3[contains(text(), 'Total')]")));
        WebElement totalCostAmountFromEmail = new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(By
                .xpath("//h3[contains(text(), 'USD')]")));

        //as improvement: need to get only amount from email and compare it with amount from cloud.google
        String totalCostFromEmail = totalCostTitleFromEmail.getText() + " " + totalCostAmountFromEmail.getText();
        logger.info(totalCostFromEmail);
        Assert.assertEquals(totalCostExpected, totalCostFromEmail, "Total cost in email is displayed incorrectly.");

    }

}
