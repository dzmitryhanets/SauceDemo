package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static pages.ProductsPage.itemName;

public class ItemPage extends BasePage {

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
    }

    @Override
    public void verifyPresenceOfItem(boolean isPresented) {
        Assert.assertEquals(isElementPresented(backBtn), isPresented);
    }

    @Step("Verifying if user is redirected to details page")
    public ItemPage verifyItemPage() {
        String actualItemName = itemDetailsName.getText();
        Assert.assertEquals(actualItemName, itemName, "Details page verified with selected item name");
        return this;
    }

    @Step("User clicks Add To Cart button")
    public ItemPage clickAddBtn() {
        addBtn.click();
        return this;
    }

    @Step("User clicks Remove button")
    public HeaderArea clickRemoveBtn() {
        removeBtn.click();
        return new HeaderArea(driver);
    }

    @Step("User clicks Back button")
    public ProductsPage clickBackButton() {
        backBtn.click();
        return new ProductsPage(driver);
    }
}
