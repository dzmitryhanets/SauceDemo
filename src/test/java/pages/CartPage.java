package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class CartPage extends BasePage {
    WebDriverWait wait;

    @FindBy(xpath = "//div[@class='cart_item']")
    private WebElement cartItem;
    @FindBy(xpath = "//div[@class='inventory_item_name']")
    private List<WebElement> cartItemName;
    @FindBy(xpath = "//a[contains(text(),'Continue Shopping')]")
    private WebElement continueBtn;
    @FindBy(xpath = "//a[contains(text(),'CHECKOUT')]")
    public WebElement checkoutBtn;

    public CartPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 10);
    }

    @Override
    @Step("Verifying if element is presented on page")
    public void verifyPresenceOfItem(boolean isPresented) {
        Assert.assertEquals(isElementPresented(cartItem), isPresented);
    }

    @Step("User clicks Continue Shopping button")
    public CartPage clickContinueBtn() {
        continueBtn.click();
        return this;
    }

    @Step("User clicks Checkout button")
    public CartPage clickCheckoutBtn() {
        checkoutBtn.click();
        return this;
    }
}
