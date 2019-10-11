package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static pages.ProductsPage.itemName;

public class ItemPage extends BasePage {
    WebDriverWait wait;

    @FindBy(xpath = "//div[@class='inventory_details_name']")
    private WebElement itemDetailsName;
    @FindBy(xpath = "//button[@class='btn_primary btn_inventory']")
    private WebElement addBtn;
    @FindBy(xpath = "//button[@class='btn_secondary btn_inventory']")
    private WebElement removeBtn;
    @FindBy(xpath = "//button[@class='inventory_details_back_button']")
    private WebElement backBtn;

    public ItemPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 10);
    }

    public ItemPage verifyItemPage() {
        String actualItemName = itemDetailsName.getText();
        Assert.assertEquals(actualItemName, itemName);
        return this;
    }

    public ItemPage clickAddBtn() {
        addBtn.click();
        return this;
    }

    public ItemPage clickRemoveBtn() {
        removeBtn.click();
        return this;
    }

    public ItemPage clickBackButton() {
        backBtn.click();
        return this;
    }
}
