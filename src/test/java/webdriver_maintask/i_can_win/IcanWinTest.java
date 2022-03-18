package webdriver_maintask.i_can_win;

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

public class IcanWinTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserOpen() {
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
    }

    @Test(description = "I can win")
    public void iCanWin() throws InterruptedException {
        driver.get("https://pastebin.com");

        driver.findElement(By.id("postform-text")).sendKeys("Hello from WebDriver" + Keys.ENTER);


        driver.findElement(By.id("select2-postform-expiration-container")).click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(By
                .xpath("//*[@class='select2-results__option select2-results__option--highlighted' and text()='10 Minutes']")))
                .click();

        driver.findElement(By.id("postform-name")).sendKeys("helloweb" + Keys.ENTER);

        driver.findElement(By.xpath("//*[@type='submit']")).click();

        WebElement textPosted = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='notice -success -post-view']")));

        System.out.println(textPosted.getText());

        Assert.assertTrue(textPosted.isDisplayed(), "Pasted text doesn't displayed.");

    }

    @AfterMethod(alwaysRun = true)
    public void browserClose() {
        driver.quit();
        driver = null;
    }
}
