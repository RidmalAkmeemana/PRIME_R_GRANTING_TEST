package TransactionTest;

import ErrorValidations.HomePageErrorValidations;
import Infra.BasePage;
import Infra.DataProviders;
import Pages.GrantingPage;
import Pages.LoginPage;
import org.testng.annotations.Test;

public class GrantingFlowTest extends BasePage {

    @Test(priority = 1, description = "Verifying Credentials", dataProvider = "GrantingFlow", dataProviderClass = DataProviders.class)
    public void GrantingFlow(
            String Name,
            String username,
            String password,
            String SearchType,
            String CustomerNIC,
            String CustomerOtherID,
            String ProductName,
            String Item,
            String Appearance,
            String GrossWeight,
            String NetWeight,
            String MachineKaratage,
            String ExperienceKaratage,
            String ArticleRemark,
            String AdvancedAmount,
            String MessureType,
            String Sector,
            String SubSector,
            String ServiceCharge,
            String InterestRate,
            String GrantingRemark
    ) throws InterruptedException {

        logger.info("-------------------------------------------------------");
        logger.info("VERIFYING CREDENTIALS");
        logger.info("-------------------------------------------------------\n");

        LoginPage loginPage = new LoginPage(BasePage.getDriver());
        HomePageErrorValidations homePageErrorValidations = new HomePageErrorValidations(BasePage.getDriver());

        loginPage.openLoginPage(loginPage.setUrl());
        logger.info("REDIRECT TO: " + loginPage.setUrl());

        logger.info("NAME: " + Name);

        loginPage.fillUsername(username);
        logger.info("ENTER USERNAME: " + username);

        loginPage.fillPassword(password);
        logger.info("ENTER PASSWORD: " + password);

        loginPage.clickOnSignIn();
        logger.info("CLICK ON SIGN IN BUTTON \n");

        logger.info("CLICK VISIT SITE \n");
        loginPage.clickVisitSite();

        homePageErrorValidations.HomePageRedirectErrorValidation(username);

        GrantingPage grantingPage = new GrantingPage(BasePage.getDriver());

        grantingPage.goToTransactionPages();
        logger.info("GO TO TRANSACTION DATA");

        grantingPage.goToGrantingPage();
        logger.info("GO TO GRANTING PAGE");

        grantingPage.goToGrantingSelectPage();
        logger.info("SELECT GRANTING  PAGE");

        logger.info("-------------------------------------------------------");
        logger.info("VERIFYING CREDENTIALS PROCESSED");
        logger.info("-------------------------------------------------------\n");

        logger.info("-------------------------------------------------------");
        logger.info("SELECT PRODUCT");
        logger.info("-------------------------------------------------------\n");

        String SearchBy = SearchType;

        if(SearchBy.equals("NIC/EIC"))
        {
            grantingPage.SelectSearchByNIC();
            logger.info("SEARCH BY: " +SearchType);

            grantingPage.FillCustomerID(CustomerNIC);
            logger.info("NIC/EIC: " +CustomerNIC);
        }
        else
        {
            grantingPage.SelectSearchByOther();
            logger.info("SEARCH BY: " +SearchType);

            grantingPage.FillCustomerID(CustomerOtherID);
            logger.info("OTHER ID: " +CustomerOtherID+ "CLICK ON SEARCH BUTTON \n");
        }

        if (grantingPage.isPopUpVisible())
        {
            grantingPage.PopUpClose(); // Call the method to close the popup
            logger.info("CLOSE CUSTOMER COMMENT POP UP");

        }
        else
        {
            logger.info("NO CUSTOMER COMMENT AVAILABLE");
        }

        grantingPage.SelectProduct(ProductName);
        logger.info("SELECT PRODUCT: " +ProductName);

        logger.info("-------------------------------------------------------");
        logger.info("SELECT PRODUCT SUCCESSFULLY");
        logger.info("-------------------------------------------------------\n");

        logger.info("-------------------------------------------------------");
        logger.info("ADD ARTICLE");
        logger.info("-------------------------------------------------------\n");

        grantingPage.selectItem(Item);
        logger.info("SELECT ITEM: " +Item);

        grantingPage.selectAppearance(Appearance);
        logger.info("SELECT APPEARANCE: " +Appearance);

        grantingPage.EnterGrossWeight(GrossWeight);
        logger.info("SELECT GROSS WEIGHT: " +GrossWeight);

        grantingPage.EnterNetWeight(NetWeight);
        logger.info("SELECT NET WEIGHT: " +NetWeight);

        grantingPage.selectKaratage(MachineKaratage);
        logger.info("SELECT MACHINE KARATAGE: " +MachineKaratage);

        grantingPage.selectExpKaratage(ExperienceKaratage);
        logger.info("SELECT MACHINE EXPERIENCE KARATAGE: " +ExperienceKaratage);

        grantingPage.FillRemark(ArticleRemark);
        logger.info("ENTER REMARK: " +ArticleRemark);

        grantingPage.EnterAdvanceAmount(AdvancedAmount);
        logger.info("ENTER ADVANCE AMOUNT: "+AdvancedAmount);

        grantingPage.selectMessureType(MessureType);
        logger.info("SELECT MESSURE TYPE: " +MessureType);

        grantingPage.ClickOnAddItem();
        logger.info("CLICK ON ADD BUTTON");

        logger.info("-------------------------------------------------------");
        logger.info("ARTICLE ADDED");
        logger.info("-------------------------------------------------------\n");

        logger.info("-------------------------------------------------------");
        logger.info("ADD GRANTING DETAILS");
        logger.info("-------------------------------------------------------\n");

        grantingPage.selectSector(Sector);
        logger.info("SELECT SECTOR: "+Sector);

        grantingPage.selectPurpose(SubSector);
        logger.info("SELECT PURPOSE: "+SubSector);

        grantingPage.FillGrantingRemark(GrantingRemark);
        logger.info("ENTER GRANTING REMARK: "+GrantingRemark);

        grantingPage.ClickOnConfirm();
        logger.info("CLICK ON CONFIRM BUTTON");

        grantingPage.ClickYesButton();
        logger.info("CLICK ON YES BUTTON");

        grantingPage.ClickOnSubmitPrint();
        logger.info("CLICK ON SUBMIT & PRINT");

        grantingPage.waitForPopupToLoad();

        logger.info("-------------------------------------------------------");
        logger.info("GRANTING PROCESSED");
        logger.info("-------------------------------------------------------\n");
    }
}
