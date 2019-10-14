package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public void isPageOpened() {
        finishBtn.isDisplayed();
    }

    @Step("User cancels order")
    public OverviewPage cancelOrder() {
        cancelBtn.click();
        return this;
    }

    @Step("User finishes order")
    public OverviewPage finishOrder() {
        finishBtn.click();
        return this;
    }
}
