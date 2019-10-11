package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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

    public HeaderArea(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 10);
    }

    public String getItemsCount() {
        return cartItemsCount.getText();
    }

    public HeaderArea verifyCount(String expectedCount) {
        Assert.assertEquals(getItemsCount(), expectedCount);
        return this;
    }

    public HeaderArea clickCartIcon() {
        cartIcon.click();
        return this;
    }

    public HeaderArea clickMenuBtn() {
        menuBtn.click();
        wait.until(ExpectedConditions.visibilityOf(resetAppItem));
        return this;
    }

    public HeaderArea resetAppState() {
        resetAppItem.click();
        return this;
    }

    public HeaderArea closeMenu() {
        closeMenuBtn.click();
        return this;
    }

    public HeaderArea clickAboutItem() {
        aboutItem.click();
        return this;
    }

    public HeaderArea validateURL(String expectedURL) {
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        return this;
    }
}
