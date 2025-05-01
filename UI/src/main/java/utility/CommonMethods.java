package utility;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

//common method class
public class CommonMethods {
    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;

    public CommonMethods(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Centralized wait
        this.js = (JavascriptExecutor) driver;
    }

    public void waitForElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void click(WebElement element) {
        waitForElement(element);
        element.click();
    }

    public void enterText(WebElement element, String text) {
        waitForElement(element); 
        element.clear();
        element.sendKeys(text);
        try {
            Thread.sleep(2000); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    public void clickHidden(WebElement element) {
        js.executeScript("arguments[0].style.visibility='visible';", element); // Make it visible
        js.executeScript("arguments[0].scrollIntoView(true);", element); // Scroll into view
        js.executeScript("arguments[0].click();", element); // Force click
    }
    
    public void verifyPageTitle(String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Page title mismatch!");
    }
    
    public void declineCookies() {
        try {
            WebElement cookieDeclineButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='user-consent-management-granular-banner-decline-all-button']")));
            cookieDeclineButton.click();
        } catch (Exception e) {
            System.out.println("No cookie popup found, proceeding...");
        }
    }
    
    public void verifyMessage(WebElement element, String expectedMessage) {
        wait.until(ExpectedConditions.visibilityOf(element)); // Ensure message appears
        String actualMessage = element.getText().trim();
        Assert.assertEquals(actualMessage, expectedMessage, "Message validation failed!");
    }

    public String takeScreenshot(String testName) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String timestamp = formatter.format(new Date());

        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String filePath = "test-output/screenshots/" + testName + "_" + timestamp + ".png";

        try {
            Files.createDirectories(Paths.get("test-output/screenshots")); 
            Files.copy(srcFile.toPath(), Paths.get(filePath));
            Log.info(" Screenshot saved: " + filePath);
            return filePath;
        } catch (IOException e) {
        	Log.error(" Failed to save screenshot: " + e.getMessage());
            return null;
        }
}
}
