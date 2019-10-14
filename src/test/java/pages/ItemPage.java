package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.AllureUtils;

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

    public void isPageOpened() {
        backBtn.isDisplayed();
    }

    @Step("Verifying if user is redirected to details page")
    public ItemPage verifyItemPage() {
        String actualItemName = itemDetailsName.getText();
        Assert.assertEquals(actualItemName, itemName);
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    @Step("User clicks Add To Cart button")
    public ItemPage clickAddBtn() {
        addBtn.click();
        return this;
    }

    @Step("User clicks Remove button")
    public ItemPage clickRemoveBtn() {
        removeBtn.click();
        return this;
    }

    @Step("User clicks Back button")
    public ItemPage clickBackButton() {
        backBtn.click();
        return this;
    }
}
