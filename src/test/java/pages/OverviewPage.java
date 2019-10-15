package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class OverviewPage extends BasePage {
    WebDriverWait wait;

    @FindBy(xpath = "//a[contains(text(),'CANCEL')]")
    private WebElement cancelBtn;
    @FindBy(xpath = "//a[contains(text(),'FINISH')]")
    private WebElement finishBtn;

    public OverviewPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 10);
    }

    @Override
    public void verifyPresenceOfItem(boolean isPresented) {
        Assert.assertEquals(isElementPresented(finishBtn), isPresented);
    }

    @Step("User cancels order")
    public ProductsPage cancelOrder() {
        cancelBtn.click();
        return new ProductsPage(driver);
    }

    @Step("User finishes order")
    public OverviewPage finishOrder() {
        finishBtn.click();
        return this;
    }
}
