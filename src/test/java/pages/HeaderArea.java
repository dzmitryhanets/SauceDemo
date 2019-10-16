package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HeaderArea extends BasePage {

    @FindBy(xpath = "//span[@class='fa-layers-counter shopping_cart_badge']")
    private WebElement cartItemsCount;
    @FindBy(tagName = "svg")
    private WebElement cartIcon;
    @FindBy(xpath = "//button[text()='Open Menu']")
    private WebElement menuBtn;
    @FindBy(id = "reset_sidebar_link")
    private WebElement resetAppItem;
    @FindBy(xpath = "//button[text()='Close Menu']")
    private WebElement closeMenuBtn;
    @FindBy(id = "about_sidebar_link")
    private WebElement aboutItem;
    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutItem;
    @FindBy(id = "inventory_sidebar_link")
    private WebElement inventoryItem;

    public HeaderArea(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Verifying if element is presented on page")
    public void verifyPresenceOfItem(boolean isPresented) {
        Assert.assertEquals(isElementPresented(cartItemsCount), isPresented, "Counter should be presented");
    }

    @Step("Getting items count from cart")
    public String getItemsCount() {
        return cartItemsCount.getText();
    }

    @Step("Verifying correct number of items in cart")
    public HeaderArea verifyCount(String expectedCount) {
        Assert.assertEquals(getItemsCount(), expectedCount, "Correct count is displayed");
        return this;
    }

    @Step("User click Cart icon")
    public CartPage clickCartIcon() {
        cartIcon.click();
        return new CartPage(driver);
    }

    @Step("User click Menu icon")
    public HeaderArea clickMenuBtn() {
        menuBtn.click();
        waitClickableElement(resetAppItem);
        return this;
    }

    @Step("User clicks Reset App State link")
    public HeaderArea resetAppState() {
        resetAppItem.click();
        waitClickableElement(cartIcon);
        return this;
    }

    @Step("User clicks Close menu button")
    public HeaderArea closeMenu() {
        closeMenuBtn.click();
        return this;
    }

    @Step("User clicks About link")
    public HeaderArea clickAboutItem() {
        aboutItem.click();
        return this;
    }

    @Step("Verifying if user redirected to correct page")
    public HeaderArea validateURL(String expectedURL) {
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL, "Page with correct URL is reached");
        return this;
    }

    @Step("User clicks Logout link")
    public LoginPage clickLogout() {
        logoutItem.click();
        return new LoginPage(driver);
    }

    @Step("User clicks All Items link")
    public ProductsPage clickInventoryItem() {
        inventoryItem.click();
        return new ProductsPage(driver);
    }
}
