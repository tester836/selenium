import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;



public class WebDriverSeleniumTest {
    private WebDriver driver;

    @BeforeMethod (alwaysRun = true)
    public void browserOpen(){
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
    }

    @Test (description = "selenium search")
    public void searchResultNotEmpty() {
        driver.get("https://selenium.dev");

        WebElement searchInput = driver.findElement(By.xpath("//input[@type='search']"));
        searchInput.sendKeys("test" + Keys.ENTER);
        WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div/h1")));
        System.out.println(firstResult.getText());
    }

    @Test (description = "chrome search")
    public void searchResultChrome() {
        driver.get("https://google.com");

        driver.findElement(By.name("q")).sendKeys("selenium" + Keys.ENTER);
        WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(By.id("result-stats")));
        System.out.println(firstResult.getText());
    }


    @AfterMethod (alwaysRun = true)
    public void browserClose() {
        driver.quit();
        driver = null;
    }
}
