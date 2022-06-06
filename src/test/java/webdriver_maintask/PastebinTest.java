package webdriver_maintask;

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
//    String username = "test";
//    String password = "test";
    String pastebinURL = "https://pastebin.com";
    By codeTextLocator = By.id("postform-text");
    String codeTextToSend = "Hello from WebDriver";
    By codeFormatMenuLocator = By.id("select2-postform-format-container");
    By codeFormatLocator = By.xpath("//*[@class='select2-results__option' and text()='Bash']");
    By pasteExpirationMenuLocator = By.id("select2-postform-expiration-container");
    By pasteExpirationLocator = By.xpath("//li[@id='select2-postform-expiration-result-2mfr-10M' or text()='10 Minutes']");
    By pasteNameLocator = By.id("postform-name");
    String pasteNameTextToSend = "helloweb";
    By submitButtonLocator = By.xpath("//*[@type='submit']");
    By postLocator = By.xpath("//*[@class='notice -success -post-view']");

    String codeTyped = "git config --global user.name  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force";
    String nameTyped = "how to gain dominance among developers";
    By namePostedLocator = By.xpath("//*[@class='info-top']/h1");
    By codeFormatPostedLocator = By.xpath("//a[text()='Bash']");
    By codePostedLocator = By.xpath("//textarea[contains(@class, 'textarea')]");

    @BeforeMethod(alwaysRun = true)
    public void browserOpen() {
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--incognito");

        driver = new ChromeDriver(/*options*/);
        driver.manage().window().maximize();

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

        driver.get(pastebinURL);
        driver.findElement(codeTextLocator).sendKeys(codeTextToSend);
        driver.findElement(pasteExpirationMenuLocator).click();
        driver.findElement(pasteExpirationLocator).click();
        driver.findElement(pasteNameLocator).sendKeys(pasteNameTextToSend);
        driver.findElement(submitButtonLocator).click();

        WebElement textPosted = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(postLocator));

        System.out.println(textPosted.getText());
            Assert.assertTrue(textPosted.isDisplayed(), "Pasted text doesn't displayed.");

    }

    @Test (description = "'Bring It On' test of pastebin.com")
    public void bringItOn() {

        driver.get(pastebinURL);
        driver.findElement(codeTextLocator).sendKeys(codeTyped);
        driver.findElement(codeFormatMenuLocator).click();
        driver.findElement(codeFormatLocator).click();
        driver.findElement(pasteExpirationMenuLocator).click();
        driver.findElement(pasteExpirationLocator).click();
        driver.findElement(pasteNameLocator).sendKeys(nameTyped + Keys.ENTER);


        WebElement namePosted = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(namePostedLocator));
        System.out.println("Posted name:\n" + namePosted.getText());
            Assert.assertEquals(nameTyped, namePosted.getText(), "Posted name is displayed incorrectly.");

        WebElement highlightedCode = driver.findElement(codeFormatPostedLocator);
        System.out.println("\nPosted syntax:\n" + highlightedCode.getText());
            Assert.assertTrue(highlightedCode.isDisplayed(), "Code is not highlighted.");

        WebElement codePosted = driver.findElement(codePostedLocator);
        System.out.println("\nPosted code:\n" + codePosted.getText());
            Assert.assertEquals(codeTyped, codePosted.getText(), "Posted code is displayed incorrectly.");

    }
}
