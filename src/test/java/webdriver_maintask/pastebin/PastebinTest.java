package webdriver_maintask.pastebin;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class PastebinTest {
    private WebDriver driver;
//    String username = "*";
//    String password = "*";

    @BeforeMethod(alwaysRun = true)
    public void browserOpen() {
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--incognito");

        driver = new ChromeDriver(/*options*/);
        driver.manage().window().fullscreen();

//        driver.get("https://pastebin.com/login");
//        new WebDriverWait(driver, Duration.ofSeconds(60))
//                .until(ExpectedConditions.visibilityOfElementLocated(By
//                        .id("loginform-username")));
//        driver.findElement(By.id("loginform-username"))
//                .sendKeys(username);
//        driver.findElement(By.id("loginform-password"))
//                .sendKeys(password + Keys.ENTER);

    }

    @AfterMethod(alwaysRun = true)
    public void browserClose() {
        driver.quit();
        driver = null;
    }

    @Test(description = "'I can win' test of pastebin.com")
    public void iCanWin() {
        driver.get("https://pastebin.com");

        driver.findElement(By.id("postform-text"))
                .sendKeys("Hello from WebDriver");

        driver.findElement(By.id("select2-postform-expiration-container"))
                .click();
        driver.findElement(By.xpath("//*[@class='select2-results__option' and text()='10 Minutes']"))
                .click();

        driver.findElement(By.id("postform-name"))
                .sendKeys("helloweb");

        driver.findElement(By.xpath("//*[@type='submit']"))
                .click();

        WebElement textPosted = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By
                        .xpath("//*[@class='notice -success -post-view']")));

        System.out.println(textPosted.getText());
            Assert.assertTrue(textPosted.isDisplayed(), "Pasted text doesn't displayed.");

    }

    @Test (description = "'Bring It On' test of pastebin.com")
    public void bringItOn() {
        String codeTyped = "git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force";
        String nameTyped = "how to gain dominance among developers";

        driver.get("https://pastebin.com");

        driver.findElement(By.id("postform-text"))
                .sendKeys(codeTyped);

        driver.findElement(By.id("select2-postform-format-container"))
                .click();
        driver.findElement(By.xpath("//*[@class='select2-results__option' and text()='Bash']"))
                .click();

        driver.findElement(By.id("select2-postform-expiration-container"))
                .click();
        driver.findElement(By.xpath("//*[@class='select2-results__option' and text()='10 Minutes']"))
                .click();

        driver.findElement(By.id("postform-name"))
                .sendKeys(nameTyped + Keys.ENTER);


        WebElement namePosted = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By
                        .xpath("//*[@class='info-top']/h1")));
        System.out.println(namePosted.getText());
            Assert.assertEquals(nameTyped, namePosted.getText(), "Posted name is displayed incorrectly.");

        WebElement highlightedCode = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By
                        .xpath("//a[text()='Bash']")));
        System.out.println(highlightedCode.getText());
            Assert.assertTrue(highlightedCode.isDisplayed(), "Code is not highlighted.");

        WebElement codePosted = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//textarea[@class='textarea']/text()")));

        System.out.println(codePosted.getText());
            Assert.assertEquals(codeTyped, codePosted.getText(), "Posted code is displayed incorrectly.");

    }
}
