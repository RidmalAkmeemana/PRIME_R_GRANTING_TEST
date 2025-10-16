package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class GrantingPage {
    private WebDriver driver;

    @FindBy(linkText = "Transaction")
    WebElement TransactionPages;

    @FindBy(linkText = "Granting")
    WebElement GrantingPages;

    @FindBy(xpath = "//a[contains(@href,'/granting-exist')]")
    WebElement GrantingSelectPage;

    @FindBy(id = "formradioRight1")
    WebElement SearchByNIC;

    @FindBy(id = "formradioRight2")
    WebElement SearchByOther;

    @FindBy(name = "searchTerm")
    WebElement SearchCustomer;

    @FindBy(xpath = "//body/ngb-modal-window[1]/div[1]/div[1]")
    WebElement CommentWindow;

    @FindBy(xpath = "//ngb-modal-window//button[1]")
    WebElement PopUp;

    @FindBy(id = "selectedItem")
    WebElement Item;

    @FindBy(id = "selectedAppearance")
    WebElement Appearance;

    @FindBy(id = "gWeight")
    WebElement Gross;

    @FindBy(id = "nWeight")
    WebElement Net;

    @FindBy(id = "karatage")
    WebElement Karatage;

    @FindBy(id = "exKaratage")
    WebElement ExpKaratage;

    @FindBy(id = "remark")
    WebElement Remark;

    @FindBy(id="aricleadv")
    WebElement AdvanceAmount;

    @FindBy(id = "messureType")
    WebElement MessureType;

    @FindBy(xpath = "//button[contains(text(),'Add Item')]")
    WebElement AddItem;

//    @FindBy(xpath = "//app-granting-add//ng-stepper//div[7]//div[3]//select")
//    WebElement Sector;
//
//    @FindBy(xpath = "//app-granting-add//ng-stepper//div[7]//div[4]//select")
//    WebElement Subsector;

    @FindBy(id = "sector")
    WebElement Sector;

    @FindBy(id = "subsector")
    WebElement Subsector;

    @FindBy(id = "grantingRemark")
    WebElement GrantingRemark;

    @FindBy(id = "confirm")
    WebElement ConfirmButton;

    @FindBy(xpath = "//button[contains(text(),'Yes')]")
    WebElement yesBtn;

    @FindBy(id = "printandSave")
    WebElement SubmitPrint;

    public GrantingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillField(WebElement field, String value) {
        field.sendKeys(value);
    }

    public void goToTransactionPages() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(TransactionPages));

        // Scroll into view
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", TransactionPages);

        // Try to click the button
        try {
            TransactionPages.click();
        } catch (ElementClickInterceptedException e) {
            js.executeScript("arguments[0].click();", TransactionPages);
        }

        Thread.sleep(2000); // Pause to allow the action to complete
    }

    public void goToGrantingPage() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(GrantingPages));

        // Scroll into view
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", GrantingPages);

        // Try to click the button
        try {
            GrantingPages.click();
        } catch (ElementClickInterceptedException e) {
            js.executeScript("arguments[0].click();", GrantingPages);
        }

        Thread.sleep(2000); // Pause to allow the action to complete
    }

    public void goToGrantingSelectPage() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(GrantingSelectPage));

        // Scroll into view
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", GrantingSelectPage);

        // Try to click the button
        try {
            GrantingSelectPage.click();
        } catch (ElementClickInterceptedException e) {
            js.executeScript("arguments[0].click();", GrantingSelectPage);
        }

        Thread.sleep(2000); // Pause to allow the action to complete
    }

    public void SelectSearchByNIC() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(SearchByNIC));

        // Scroll into view
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", SearchByNIC);

        // Try to click the button
        try {
            SearchByNIC.click();
        } catch (ElementClickInterceptedException e) {
            js.executeScript("arguments[0].click();", SearchByNIC);
        }

        Thread.sleep(2000); // Pause to allow the action to complete
    }

    public void SelectSearchByOther() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(SearchByOther));

        // Scroll into view
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", SearchByOther);

        // Try to click the button
        try {
            SearchByOther.click();
        } catch (ElementClickInterceptedException e) {
            js.executeScript("arguments[0].click();", SearchByOther);
        }

        Thread.sleep(2000); // Pause to allow the action to complete
    }

    public void FillCustomerID(String EnterId) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(SearchCustomer));

        // Scroll into view
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", SearchCustomer);

        // Try to click the button
        try {
            this.fillField(SearchCustomer, EnterId);
            SearchCustomer.sendKeys(Keys.ENTER);
        } catch (ElementClickInterceptedException e) {
            js.executeScript("arguments[0].click();", SearchCustomer);
        }

        Thread.sleep(2000); // Pause to allow the action to complete
    }

    public boolean isPopUpVisible()
    {
        try {
            // Check if the popup window is displayed
            return CommentWindow.isDisplayed();
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
        } catch (ElementClickInterceptedException e) {
            js.executeScript("arguments[0].click();", PopUp);
        }

        Thread.sleep(2000); // Pause to allow the action to complete
    }

    public void SelectProduct(String productName) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        boolean productFound = false;
        int currentPage = 7; // Starting page button index

        while (!productFound) {
            try {
                // Wait for the product cell to be visible in the table
                WebElement productCell = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//td[contains(text(),'" + productName + "')]")
                ));

                // Find the corresponding row (parent `<tr>`) and the `SELECT` button
                WebElement selectButton = productCell.findElement(
                        By.xpath("./parent::tr//button[@title='SELECT']")
                );

                // Wait for the button to be clickable before clicking
                wait.until(ExpectedConditions.elementToBeClickable(selectButton));

                // Scroll the button into view
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", selectButton);

                // Click the `SELECT` button
                selectButton.click();

                productFound = true; // Exit the loop as the product is found and clicked

            } catch (TimeoutException e) {
                // If the product is not found on the current page, navigate to the next page
                if (isNextPageAvailable(currentPage)) {
                    NavigateToAnotherPage(currentPage);
                    currentPage++; // Increment page index for the next page button
                } else {
                    // No more pages available, exit the loop
                    break;
                }
            } catch (ElementClickInterceptedException e) {
                // Handle cases where the button is obstructed by another element
                WebElement productCell = driver.findElement(
                        By.xpath("//td[contains(text(),'" + productName + "')]/parent::tr//button[@title='SELECT']")
                );
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", productCell);
                productFound = true;
            }
        }

        if (!productFound) {
            System.out.println("Product not found on any page: " + productName);
        }

        Thread.sleep(2000); // Optional, to allow for any action to complete
    }


    public void NavigateToAnotherPage(int currentPage) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement nextPageButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//app-granting-exist//button[" + currentPage + "]")
        ));

        // Scroll into view
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", nextPageButton);

        // Try to click the button
        try {
            nextPageButton.click();
        } catch (ElementClickInterceptedException e) {
            js.executeScript("arguments[0].click();", nextPageButton);
        }

        Thread.sleep(2000); // Pause to allow the action to complete
    }

    // Method to check if the "Next Page" button is available and enabled
    private boolean isNextPageAvailable(int currentPage) {
        try {
            WebElement nextPageButton = driver.findElement(By.xpath("//app-granting-exist//button[" + currentPage + "]"));
            return nextPageButton.isDisplayed() && nextPageButton.isEnabled();
        } catch (NoSuchElementException e) {
            // Button is not found, meaning no more pages are available
            return false;
        }
    }

    public void selectItem(String itemName) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Wait for the dropdown to be clickable and click it
            WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(Item));

            // Scroll into view (optional, useful for hidden elements)
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", dropdown);

            dropdown.click(); // Open the dropdown

            // Wait for all options to become visible
            List<WebElement> options = wait.until(
                    ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//select[@id='selectedItem']/option"))
            );

            // Locate and select the option matching the provided itemName
            boolean optionFound = false;
            for (WebElement option : options) {
                String optionText = option.getText().trim();
                if (optionText.equals(itemName)) {
                    try {
                        option.click(); // Try clicking the option
                    } catch (ElementClickInterceptedException e) {
                        // Use JavaScript click if regular click fails
                        js.executeScript("arguments[0].click();", option);
                    }
                    optionFound = true;
                    break;
                }
            }

            // Throw exception if the desired option is not found
            if (!optionFound) {
                throw new NoSuchElementException("Option with text '" + itemName + "' not found in dropdown.");
            }

            // Wait for a short time to ensure the selection is processed
            Thread.sleep(1000);

        }
        finally {
            // Attempt to close the dropdown if it remains open
            try {
                WebElement bodyElement = driver.findElement(By.xpath("//body")); // Adjust selector if needed
                bodyElement.click();
            } catch (Exception e) {
                System.err.println("Failed to close the dropdown: " + e.getMessage());
            }
        }
    }

    public void selectAppearance(String appearanceName) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Wait for the dropdown to be clickable and click it
            WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(Appearance));

            // Scroll into view (optional, useful for hidden elements)
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", dropdown);

            dropdown.click(); // Open the dropdown

            // Wait for all options to become visible
            List<WebElement> options = wait.until(
                    ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//select[@id='selectedAppearance']/option"))
            );

            // Locate and select the option matching the provided itemName
            boolean optionFound = false;
            for (WebElement option : options) {
                String optionText = option.getText().trim();
                if (optionText.equals(appearanceName)) {
                    try {
                        option.click(); // Try clicking the option
                    } catch (ElementClickInterceptedException e) {
                        // Use JavaScript click if regular click fails
                        js.executeScript("arguments[0].click();", option);
                    }
                    optionFound = true;
                    break;
                }
            }

            // Throw exception if the desired option is not found
            if (!optionFound) {
                throw new NoSuchElementException("Option with text '" + appearanceName + "' not found in dropdown.");
            }

            // Wait for a short time to ensure the selection is processed
            Thread.sleep(1000);

        }
        finally {
            // Attempt to close the dropdown if it remains open
            try {
                WebElement bodyElement = driver.findElement(By.xpath("//body")); // Adjust selector if needed
                bodyElement.click();
            } catch (Exception e) {
                System.err.println("Failed to close the dropdown: " + e.getMessage());
            }
        }
    }

    public void EnterGrossWeight(String grossWeight) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(Gross));

        // Scroll into view
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(false);", Gross);

        // Try to click the button
        try {
            this.fillField(Gross, grossWeight);
        } catch (ElementClickInterceptedException e) {
            js.executeScript("arguments[0].click();", Gross);
        }

        Thread.sleep(2000); // Pause to allow the action to complete
    }

    public void EnterNetWeight(String netWeight) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(Net));

        // Scroll into view
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(false);", Net);

        // Try to click the button
        try {
            this.fillField(Net, netWeight);
        } catch (ElementClickInterceptedException e) {
            js.executeScript("arguments[0].click();", Net);
        }

        Thread.sleep(2000); // Pause to allow the action to complete
    }

    public void selectKaratage(String karatage) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Wait for the dropdown to be clickable and click it
            WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(Karatage));

            // Scroll into view (optional, useful for hidden elements)
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", dropdown);

            dropdown.click(); // Open the dropdown

            // Wait for all options to become visible
            List<WebElement> options = wait.until(
                    ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//select[@id='karatage']/option"))
            );

            // Locate and select the option matching the provided itemName
            boolean optionFound = false;
            for (WebElement option : options) {
                String optionText = option.getText().trim();
                if (optionText.equals(karatage)) {
                    try {
                        option.click(); // Try clicking the option
                    } catch (ElementClickInterceptedException e) {
                        // Use JavaScript click if regular click fails
                        js.executeScript("arguments[0].click();", option);
                    }
                    optionFound = true;
                    break;
                }
            }

            // Throw exception if the desired option is not found
            if (!optionFound) {
                throw new NoSuchElementException("Option with text '" + karatage + "' not found in dropdown.");
            }

            // Wait for a short time to ensure the selection is processed
            Thread.sleep(1000);

        }
        finally {
            // Attempt to close the dropdown if it remains open
            try {
                WebElement bodyElement = driver.findElement(By.xpath("//body")); // Adjust selector if needed
                bodyElement.click();
            } catch (Exception e) {
                System.err.println("Failed to close the dropdown: " + e.getMessage());
            }
        }
    }

    public void selectExpKaratage(String expkaratage) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Wait for the dropdown to be clickable and click it
            WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(ExpKaratage));

            // Scroll into view (optional, useful for hidden elements)
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", dropdown);

            dropdown.click(); // Open the dropdown

            // Wait for all options to become visible
            List<WebElement> options = wait.until(
                    ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//select[@id='exKaratage']/option"))
            );

            // Locate and select the option matching the provided itemName
            boolean optionFound = false;
            for (WebElement option : options) {
                String optionText = option.getText().trim();
                if (optionText.equals(expkaratage)) {
                    try {
                        option.click(); // Try clicking the option
                    } catch (ElementClickInterceptedException e) {
                        // Use JavaScript click if regular click fails
                        js.executeScript("arguments[0].click();", option);
                    }
                    optionFound = true;
                    break;
                }
            }

            // Throw exception if the desired option is not found
            if (!optionFound) {
                throw new NoSuchElementException("Option with text '" + expkaratage + "' not found in dropdown.");
            }

            // Wait for a short time to ensure the selection is processed
            Thread.sleep(1000);

        }
        finally {
            // Attempt to close the dropdown if it remains open
            try {
                WebElement bodyElement = driver.findElement(By.xpath("//body")); // Adjust selector if needed
                bodyElement.click();
            } catch (Exception e) {
                System.err.println("Failed to close the dropdown: " + e.getMessage());
            }
        }
    }

    public void FillRemark(String remark) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(Remark));

        // Scroll into view
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(false);", Remark);

        // Try to click the button
        try {
            this.fillField(Remark, remark);
        } catch (ElementClickInterceptedException e) {
            js.executeScript("arguments[0].click();", Remark);
        }

        Thread.sleep(2000); // Pause to allow the action to complete
    }

    public void EnterAdvanceAmount(String advanceAmount) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(AdvanceAmount));

        // Scroll into view
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(false);", AdvanceAmount);

        // Try to click the button
        try {
            this.fillField(AdvanceAmount, advanceAmount);
        } catch (ElementClickInterceptedException e) {
            js.executeScript("arguments[0].click();", AdvanceAmount);
        }

        Thread.sleep(2000); // Pause to allow the action to complete
    }

    public void selectMessureType(String messureType) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try {
            // Wait for the dropdown to be clickable and interactable
            WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(MessureType));

            // Scroll the dropdown into view (optional)
            js.executeScript("arguments[0].scrollIntoView(true);", dropdown);

            // Open the dropdown by clicking it
            dropdown.click();

            // Wait for the options inside the dropdown to load
            List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//select[@id='messureType']/option")));

            // Iterate through options and select the one matching the provided text
            boolean optionFound = false;
            for (WebElement option : options) {
                String optionText = option.getText().trim(); // Get the visible text of the option
                if (optionText.equalsIgnoreCase(messureType)) { // Match ignoring case sensitivity
                    try {
                        option.click(); // Attempt to click the option
                    } catch (ElementClickInterceptedException e) {
                        // Fallback to JavaScript click in case of interception
                        js.executeScript("arguments[0].click();", option);
                    }
                    optionFound = true;
                    break; // Exit loop after selecting the correct option
                }
            }

            // If no matching option is found, throw an exception
            if (!optionFound) {
                throw new NoSuchElementException("Option with text '" + messureType + "' not found in the dropdown.");
            }

            // Wait briefly to ensure the selection is processed
            Thread.sleep(1000);

        } finally {
            // Attempt to close the dropdown if it remains open
            try {
                WebElement bodyElement = driver.findElement(By.xpath("//body")); // Adjust selector if needed
                bodyElement.click();
            } catch (Exception e) {
                System.err.println("Failed to close the dropdown: " + e.getMessage());
            }
        }
    }

    public void ClickOnAddItem() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(AddItem));

        // Scroll into view
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", AddItem);

        // Try to click the button
        try {
            AddItem.click();
        } catch (ElementClickInterceptedException e) {
            js.executeScript("arguments[0].click();", AddItem);
        }

        Thread.sleep(2000); // Pause to allow the action to complete
    }

    public void selectSector(String sector) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try {
            // Wait for dropdown to be visible and clickable
            WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(Sector));

            // Scroll into view and ensure not obscured
            js.executeScript("arguments[0].scrollIntoView({block: 'center'});", dropdown);

            // Wait for any overlay or loader to disappear
            wait.until(ExpectedConditions.invisibilityOfElementLocated(
                    By.xpath("//*[contains(@class,'overlay') or contains(@class,'spinner') or contains(@class,'loading')]")
            ));

            // Try clicking with a safe retry mechanism
            try {
                dropdown.click();
            } catch (ElementClickInterceptedException e) {
                System.out.println("Dropdown click intercepted — using JS click fallback.");
                js.executeScript("arguments[0].click();", dropdown);
            }

            // Wait for the options to load
            List<WebElement> options = wait.until(ExpectedConditions
                    .visibilityOfAllElementsLocatedBy(By.xpath("//select[@id='sector']/option")));

            boolean optionFound = false;
            for (WebElement option : options) {
                if (option.getText().trim().equalsIgnoreCase(sector)) {
                    try {
                        option.click();
                    } catch (ElementClickInterceptedException e) {
                        js.executeScript("arguments[0].click();", option);
                    }
                    optionFound = true;
                    break;
                }
            }

            if (!optionFound) {
                throw new NoSuchElementException("Sector option '" + sector + "' not found.");
            }

            Thread.sleep(1000);

        } finally {
            try {
                js.executeScript("document.activeElement.blur();");
            } catch (Exception ignored) {}
        }
    }


    public void selectPurpose(String purpose) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try {
            // Wait for the dropdown to be clickable and interactable
            WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(Subsector));

            // Scroll the dropdown into view (optional)
            js.executeScript("arguments[0].scrollIntoView(true);", dropdown);

            // Open the dropdown by clicking it
            dropdown.click();

            // Wait for the options inside the dropdown to load
            List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//select[@id='subsector']/option")));

            // Iterate through options and select the one matching the provided text
            boolean optionFound = false;
            for (WebElement option : options) {
                String optionText = option.getText().trim(); // Get the visible text of the option
                if (optionText.equalsIgnoreCase(purpose)) { // Match ignoring case sensitivity
                    try {
                        option.click(); // Attempt to click the option
                    } catch (ElementClickInterceptedException e) {
                        // Fallback to JavaScript click in case of interception
                        js.executeScript("arguments[0].click();", option);
                    }
                    optionFound = true;
                    break; // Exit loop after selecting the correct option
                }
            }

            // If no matching option is found, throw an exception
            if (!optionFound) {
                throw new NoSuchElementException("Option with text '" + purpose + "' not found in the dropdown.");
            }

            // Wait briefly to ensure the selection is processed
            Thread.sleep(1000);

        } finally {
            // Attempt to close the dropdown if it remains open
            try {
                WebElement bodyElement = driver.findElement(By.xpath("//body")); // Adjust selector if needed
                bodyElement.click();
            } catch (Exception e) {
                System.err.println("Failed to close the dropdown: " + e.getMessage());
            }
        }
    }

    public void FillGrantingRemark(String grantingRemark) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(GrantingRemark));

        // Scroll into view
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(false);", GrantingRemark);

        // Try to click the button
        try {
            this.fillField(GrantingRemark, grantingRemark);
        } catch (ElementClickInterceptedException e) {
            js.executeScript("arguments[0].click();", GrantingRemark);
        }

        Thread.sleep(2000); // Pause to allow the action to complete
    }

    public void ClickOnConfirm() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(ConfirmButton));

        // Scroll into view
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", ConfirmButton);

        // Try to click the button
        try {
            ConfirmButton.click();
        } catch (ElementClickInterceptedException e) {
            js.executeScript("arguments[0].click();", ConfirmButton);
        }

        Thread.sleep(2000); // Pause to allow the action to complete
    }

    public void ClickYesButton() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(yesBtn));
        yesBtn.click();
        Thread.sleep(2000);
    }

    public void ClickOnSubmitPrint() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(SubmitPrint));

        // Scroll into view
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", SubmitPrint);

        // Try to click the button
        try {
            SubmitPrint.click();
        } catch (ElementClickInterceptedException e) {
            js.executeScript("arguments[0].click();", SubmitPrint);
        }

        // Wait for the file to download
//        File downloadDir = new File("/Users/ridmal/Downloads");
//        File[] files;
//        boolean isFileDownloaded = false;
//        for (int i = 0; i < 10; i++) { // Retry for 10 seconds
//            files = downloadDir.listFiles();
//            if (files != null && files.length > 0) {
//                for (File file : files) {
//                    if (file.getName().endsWith(".pdf")) {
//                        isFileDownloaded = true;
//                        break;
//                    }
//                }
//            }
//            if (isFileDownloaded) break;
//            Thread.sleep(1000); // Wait 1 second before checking again
//        }
//
//        if (!isFileDownloaded) {
//            throw new RuntimeException("PDF file was not downloaded.");
//        }

        Thread.sleep(2000); // Pause to allow the action to complete
    }

    public void waitForPopupToLoad() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        try {
            // Wait for Angular/Material overlay to appear
            By popupLocator = By.cssSelector(".cdk-overlay-container .cdk-overlay-pane");

            // Wait until popup is visible in DOM
            wait.until(ExpectedConditions.visibilityOfElementLocated(popupLocator));

            System.out.println(" Popup loaded successfully.");
        } catch (TimeoutException e) {
            System.out.println("Popup did not appear within 20 seconds.");
        }
    }

}

