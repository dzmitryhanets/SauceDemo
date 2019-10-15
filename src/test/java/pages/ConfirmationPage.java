package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.AllureUtils;

public class ConfirmationPage extends BasePage {
    WebDriverWait wait;

    @FindBy(xpath = "//a[contains(text(),'CANCEL')]")
    private WebElement cancelBtn;
    @FindBy(id = "first-name")
    private WebElement firstName;
    @FindBy(id = "last-name")
    private  WebElement lastName;
    @FindBy(id = "postal-code")
    private  WebElement postalCode;
    @FindBy(xpath = "//input[@class='btn_primary cart_button']")
    private  WebElement confirmBtn;
    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement errorMsg;

    public ConfirmationPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 10);
    }

    @Override
    public void verifyPresenceOfItem(boolean isPresented) {
        Assert.assertEquals(isElementPresented(postalCode), isPresented);
    }

    @Step("User cancels checkout")
    public CartPage clickCancelBtn() {
        cancelBtn.click();
        return new CartPage(driver);
    }

    @Step("User inputs first name")
    public ConfirmationPage inputFisrtName(String userFirstName) {
        firstName.sendKeys(userFirstName);
        wait.until(ExpectedConditions.elementToBeClickable(lastName));
        return this;
    }

    @Step("User inputs last name")
    public ConfirmationPage inputLastName(String userLastName) {
        lastName.sendKeys(userLastName);
        wait.until(ExpectedConditions.elementToBeClickable(postalCode));
        return this;
    }

    @Step("User inputs postal code")
    public ConfirmationPage inputPostalCode(String userPostalCode) {
        postalCode.sendKeys(userPostalCode);
        return this;
    }

    @Step("User confirms checkout")
    public ConfirmationPage clickConfirmBtn() {
        confirmBtn.click();
        return this;
    }

    @Step("Verifying that incorrect personal data is not accepted")
    public ConfirmationPage verifyIncorrectData(String errorMsgText) {
        Assert.assertTrue(errorMsg.getText().contains(errorMsgText));
        AllureUtils.takeScreenshot(driver);
        return this;
    }
}
