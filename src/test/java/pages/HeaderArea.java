package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HeaderArea extends BasePage {
    WebDriverWait wait;

    @FindBy(xpath = "//span[@class='fa-layers-counter shopping_cart_badge']")
    private WebElement cartItemsCount;
    @FindBy(tagName = "svg")
    private WebElement cartIcon;

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

    public CartPage clickCartIcon() {
        cartIcon.click();
        return new CartPage(driver);
    }

}
