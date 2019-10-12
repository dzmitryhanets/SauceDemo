package pages;

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

    public OverviewPage cancelOrder() {
        cancelBtn.click();
        return this;
    }

    public OverviewPage finishOrder() {
        finishBtn.click();
        return this;
    }
}
