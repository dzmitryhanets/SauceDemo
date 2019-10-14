package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.AllureUtils;

public class LoginPage extends BasePage{
    WebDriverWait wait;

    String URL = "https://www.saucedemo.com";
    @FindBy(id = "user-name")
    private WebElement userName;
    @FindBy(id = "password")
    private  WebElement passwordField;
    @FindBy(xpath = "//input[@class='btn_action']")
    private  WebElement loginBtn;
    @FindBy(xpath = "//div[contains(text(),'Products')]")
    private WebElement productsTitle;
    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement incorrectMsg;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 10);
    }

    @Step("Open Login page")
    public LoginPage openPage(){
        driver.get(URL);
        return this;
    }

    @Step("User inputs name")
    public LoginPage inputName(String name) {
        userName.sendKeys(name);
        return this;
    }

    @Step("User inputs password")
    public LoginPage inputPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    @Step("User clicks Login button")
    public LoginPage clickLoginBtn() {
        loginBtn.click();
        return this;
    }

    @Step("Verifying is user is successfully logged out")
    public LoginPage verifyLoginBtn() {
        Assert.assertTrue(loginBtn.isDisplayed());
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    @Step("Verifying that incorrect data is forbidden")
    public LoginPage verifyIncorrectLogin(String errorMsg) {
        Assert.assertTrue(incorrectMsg.getText().contains(errorMsg));
        AllureUtils.takeScreenshot(driver);
        return this;
    }
}
