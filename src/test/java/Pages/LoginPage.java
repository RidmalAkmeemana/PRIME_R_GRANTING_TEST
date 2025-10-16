package Pages;

import Infra.LoadEnv;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage
{
    private WebDriver driver;
    @FindBy(id="email")
    WebElement userNameField;
    @FindBy(id="password-input")
    WebElement passwordField;

    @FindBy(xpath = "//button[contains(text(),'Sign In')]")
    WebElement signInButton;

    @FindBy(xpath = "//div[contains(@class, 'input-group') and .//input[@placeholder='Prime Pawning']]//button")
    WebElement primepawning;

    @FindBy(id = "swal2-html-container")
    WebElement InsuranceLimit;

    @FindBy(css = ".swal2-confirm")
    WebElement PopUp;

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillField(WebElement field, String value)
    {
        field.sendKeys(value);
    }

    public String setEnv()
    {
        LoadEnv loadEnv = new LoadEnv();
        String env = loadEnv.getEnv();
        return env;
    }

    public String setUrl()
    {
        LoadEnv loadEnv = new LoadEnv();
        String url = loadEnv.getUrl();
        return url;
    }

    public void openLoginPage(String url) {
        driver.get(url);
    }

    public void fillUsername(String username) throws InterruptedException {
        this.fillField(userNameField,username);
        Thread.sleep(2000);
    }

    public void fillPassword(String password) throws InterruptedException {
        this.fillField(passwordField,password);
        Thread.sleep(2000);
    }

    public void clickOnSignIn() throws InterruptedException {
        // Wait for the "Sign In" button to be clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Use Duration for the timeout
        wait.until(ExpectedConditions.elementToBeClickable(signInButton));

        // Scroll into view (in case it's not fully visible)
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", signInButton);

        // Use JavaScript to click the button if the regular click method fails
        try {
            signInButton.click();
        } catch (org.openqa.selenium.ElementClickInterceptedException e) {
            js.executeScript("arguments[0].click();", signInButton);
        }

        Thread.sleep(2000); // Pause to allow the action to complet
    }
    public void clickVisitSite() throws InterruptedException {
        // Wait for the "Sign In" button to be clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Use Duration for the timeout
        wait.until(ExpectedConditions.elementToBeClickable(primepawning));

        // Scroll into view (in case it's not fully visible)
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", primepawning);

        // Use JavaScript to click the button if the regular click method fails
        try {
            primepawning.click();
        } catch (org.openqa.selenium.ElementClickInterceptedException e) {
            js.executeScript("arguments[0].click();", primepawning);
        }

        Thread.sleep(2000); // Pause to allow the action to complet
    }

    public boolean isInsuranceExceeded()
    {
        try {
            // Check if the popup window is displayed
            return InsuranceLimit.isDisplayed();
        } catch (NoSuchElementException e) {
            // If the element is not found, it means the popup is not visible
            return false;
        }
    }

    public void PopUpClose() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(PopUp));

        // Scroll into view
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", PopUp);

        // Try to click the button
        try {
            PopUp.click();
        } catch (org.openqa.selenium.ElementClickInterceptedException e) {
            js.executeScript("arguments[0].click();", PopUp);
        }

        Thread.sleep(2000); // Pause to allow the action to complete
    }
}
