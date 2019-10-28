package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class OverviewPage extends BasePage {

    @FindBy(xpath = "//a[contains(text(),'CANCEL')]")
    private WebElement cancelBtn;
    @FindBy(xpath = "//a[contains(text(),'FINISH')]")
    private WebElement finishBtn;

    public OverviewPage(WebDriver driver) {
        super(driver);
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
    public SuccessPage finishOrder() {
        finishBtn.click();
        return new SuccessPage(driver);
    }
}
