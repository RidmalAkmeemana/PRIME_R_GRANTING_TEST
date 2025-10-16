package ErrorValidations;

import Infra.BasePage;
import Pages.HomePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePageErrorValidations extends HomePage
{
    public static Logger logger = LogManager.getLogger(BasePage.class);

    private WebDriver driver;

    public HomePageErrorValidations(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void HomePageRedirectErrorValidation(String Username) throws InterruptedException {

        HomePage homePage = new HomePage(driver);
        String getUsername = homePage.getUserLabel(Username);
        String getEnteredUsername = Username;

        if(getEnteredUsername.equals(getUsername))
        {
            logger.info("USER LOG IN SUCCESSFULLY\n");
        }
        else
        {
            logger.info("USER LOGIN FAILED\n");
        }
        Assert.assertEquals(getUsername, getEnteredUsername, "USER LOGIN FAILED");
    }
}
