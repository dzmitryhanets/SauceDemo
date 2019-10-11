package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class CartPage extends BasePage {
    WebDriverWait wait;

    @FindBy(xpath = "//div[@class='cart_item']")
    public WebElement cartItem;
    @FindBy(xpath = "//div[@class='inventory_item_name']")
    private List<WebElement> cartItemName;

    public CartPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 10);
    }

    public String getItemNameInCart(int itemNumber) {
        String itemNameInCart = cartItemName.get(itemNumber - 1).getText();
        return itemNameInCart;
    }

}
