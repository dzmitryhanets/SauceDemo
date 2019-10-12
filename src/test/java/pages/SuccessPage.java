package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SuccessPage extends BasePage {
    WebDriverWait wait;

    @FindBy(xpath = "//h2[@class='complete-header']")
    private WebElement successMsg;

    public SuccessPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 10);
    }

    public SuccessPage verifySuccessOrder(String expectedText) {
        Assert.assertEquals(successMsg.getText(), expectedText);
        return this;
    }
}
