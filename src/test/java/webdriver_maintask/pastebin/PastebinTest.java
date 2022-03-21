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

public class PastebinTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserOpen() {
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--incognito");
//        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
    }

    @Test(description = "I can win")
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
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='notice -success -post-view']")));

        System.out.println(textPosted.getText());

        Assert.assertTrue(textPosted.isDisplayed(), "Pasted text doesn't displayed.");

    }

    @Test (description = "Bring It On")
    public void bringItOn() {
        driver.get("https://pastebin.com");

        driver.findElement(By.id("postform-text"))
                .sendKeys("git config --global user.name  \"New Sheriff in Town\"" +
                        "\ngit reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")" +
                        "\ngit push origin master --force");

        driver.findElement(By.id("select2-postform-format-container"))
                .click();
        driver.findElement(By.xpath("//*[@class='select2-results__option' and text()='Bash']"))
                .click();

        driver.findElement(By.id("select2-postform-expiration-container"))
                .click();
        driver.findElement(By.xpath("//*[@class='select2-results__option' and text()='10 Minutes']"))
                .click();

        driver.findElement(By.id("postform-name"))
                .sendKeys("how to gain dominance among developers");

        driver.findElement(By.xpath("//*[@type='submit']"))
                .click();

        WebElement namePosted = new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfElementLocated(By
                        .xpath("//*[@class='info-top']/h1")));
        System.out.println(namePosted.getText());
        String nameTyped = "how to gain dominance among developers";
        Assert.assertEquals(nameTyped, namePosted, "Pasted name is displayed incorrectly.");

        WebElement highlightedCode = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By
                        .xpath("//a[text()='Bash']")));
        System.out.println(highlightedCode.getText());
        Assert.assertTrue(highlightedCode.isDisplayed(), "Code is not highlighted.");

        WebElement codePosted = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//*[@class='textarea']/text()")));
        String codeTyped = "git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force";
        System.out.println(codePosted.getText());
        Assert.assertEquals(codeTyped, codePosted, "Posted code is displayed incorrectly.");


    }

        @AfterMethod(alwaysRun = true)
    public void browserClose() {
        driver.quit();
        driver = null;
    }
}
