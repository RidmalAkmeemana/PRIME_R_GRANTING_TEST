package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage
{
    private WebDriver driver;

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getUserLabel(String username) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Build a dynamic XPath using the username
        By dynamicUserLabel = By.xpath("//div[contains(text(),'"+username+"')]");

        // Wait until the element is visible
        WebElement userLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(dynamicUserLabel));

        // Scroll into view
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", userLabel);

        // Get the text safely
        try {
            return userLabel.getText().trim();
        } catch (org.openqa.selenium.ElementClickInterceptedException e) {
            js.executeScript("arguments[0].click();", userLabel);
            Thread.sleep(1000); // small wait after JS click
            return userLabel.getText().trim();
        }
    }
}
