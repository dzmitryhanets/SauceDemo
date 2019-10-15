package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.AllureUtils;

public class SuccessPage extends BasePage {
    WebDriverWait wait;

    @FindBy(xpath = "//h2[@class='complete-header']")
    private WebElement successMsg;

    public SuccessPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 10);
    }

    @Override
    public void verifyPresenceOfItem(boolean isPresented) {
        Assert.assertEquals(isElementPresented(successMsg), isPresented);
    }

    @Step("Verifying if order is finished successfully")
    public SuccessPage verifySuccessOrder(String expectedText) {
        Assert.assertEquals(successMsg.getText(), expectedText);
        AllureUtils.takeScreenshot(driver);
        return this;
    }
}
