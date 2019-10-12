package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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

    public ConfirmationPage clickCancelBtn() {
        cancelBtn.click();
        return this;
    }

    public ConfirmationPage inputFisrtName(String userFirstName) {
        firstName.sendKeys(userFirstName);
        return this;
    }

    public ConfirmationPage inputLastName(String userLastName) {
        lastName.sendKeys(userLastName);
        return this;
    }

    public ConfirmationPage inputPostalCode(String userPostalCode) {
        lastName.sendKeys(userPostalCode);
        return this;
    }

    public ConfirmationPage clickConfirmBtn() {
        confirmBtn.click();
        return this;
    }

    public ConfirmationPage verifyIncorrectData(String errorMsgText) {
        Assert.assertTrue(errorMsg.getText().contains(errorMsgText));
        return this;
    }
}
