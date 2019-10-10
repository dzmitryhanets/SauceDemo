package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CartPage extends BasePage {
    WebDriverWait wait;

    @FindBy(xpath = "//div[@class='cart_item']")
    private WebElement cartItem;

    public CartPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 10);
    }

    public CartPage verifyPresenceOfItem() {

        return this;
    }
}
