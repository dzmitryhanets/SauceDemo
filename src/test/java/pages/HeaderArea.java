package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.AllureUtils;

public class HeaderArea extends BasePage {
    WebDriverWait wait;

    @FindBy(xpath = "//span[@class='fa-layers-counter shopping_cart_badge']")
    public WebElement cartItemsCount;
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
        this.wait = new WebDriverWait(driver, 10);
    }

    public void isPageOpened() {
        cartIcon.isDisplayed();
    }

    @Step("Getting items count from cart")
    public String getItemsCount() {
        return cartItemsCount.getText();
    }

    @Step("Verifying correct number of items in cart")
    public HeaderArea verifyCount(String expectedCount) {
        Assert.assertEquals(getItemsCount(), expectedCount);
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    @Step("User click Cart icon")
    public HeaderArea /*CartPage*/ clickCartIcon() {
        cartIcon.click();
        return this;
        //return new CartPage(driver);
    }

    @Step("User click Menu icon")
    public HeaderArea clickMenuBtn() {
        menuBtn.click();
        wait.until(ExpectedConditions.visibilityOf(resetAppItem));
        return this;
    }

    @Step("User clicks Reset App State link")
    public HeaderArea resetAppState() {
        resetAppItem.click();
        wait.until(ExpectedConditions.elementToBeClickable(cartIcon));
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
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    @Step("User clicks Logout link")
    public HeaderArea clickLogout() {
        logoutItem.click();
        return this;
    }

    @Step("User clicks All Items link")
    public HeaderArea clickInventoryItem() {
        inventoryItem.click();
        return this;
    }
}
