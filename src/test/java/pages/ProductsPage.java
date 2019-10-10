package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ProductsPage extends BasePage {
    WebDriverWait wait;
    public static String itemName;

    @FindBy(xpath = "//div[contains(text(),'Products')]")
    private WebElement productsTitle;
    @FindBy(xpath = "//div[@class='inventory_item_name']")
    private List<WebElement> items;
    @FindBy(xpath = "//button[@class='btn_primary btn_inventory']")
    private List<WebElement> addBtns;

    public ProductsPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 10);
    }

    public String getItemName(int itemNumber) {
        itemName = items.get(itemNumber - 1).getText();
        return itemName;
    }

    public ProductsPage clickItem(int itemNumber) {
        items.get(itemNumber - 1).click();
        return this;
    }

    public HeaderArea clickAddBtn(int itemNumber) {
        addBtns.get(itemNumber - 1).click();
        return new HeaderArea(driver);
    }
}
