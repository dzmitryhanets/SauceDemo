package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class ProductsPage extends BasePage {
    public static String itemName;

    @FindBy(xpath = "//div[contains(text(),'Products')]")
    private WebElement productsTitle;
    @FindBy(xpath = "//div[@class='inventory_item_name']")
    private List<WebElement> items;
    @FindBy(xpath = "//button[@class='btn_primary btn_inventory']")
    private List<WebElement> addBtns;
    @FindBy(xpath = "//button[@class='btn_secondary btn_inventory']")
    private List<WebElement> removeBtns;
    @FindBy(xpath = "//select[@class='product_sort_container']")
    private WebElement sortMenu;
    @FindBy(xpath = "//option[@value='za']")
    private WebElement sortByNameDESC;
    @FindBy(xpath = "//option[@value='az']")
    private WebElement sortByNameASC;
    @FindBy(xpath = "//div[@class='inventory_item_price']")
    private List<WebElement> itemPrices;
    @FindBy(xpath = "//option[@value='lohi']")
    private WebElement sortByPriceASC;
    @FindBy(xpath = "//option[@value='hilo']")
    private WebElement sortByPriceDESC;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void verifyPresenceOfItem(boolean isPresented) {
        Assert.assertEquals(isElementPresented(productsTitle), isPresented);
    }

    @Step("Getting item name")
    public String getItemName(int itemNumber) {
        itemName = items.get(itemNumber - 1).getText();
        return itemName;
    }

    @Step("Select item")
    public ItemPage clickItem(int itemNumber) {
        items.get(itemNumber - 1).click();
        return new ItemPage(driver);
    }

    @Step("Click Add To Cart button")
    public ProductsPage clickAddBtn(int itemNumber) {
        addBtns.get(itemNumber - 1).click();
        return this;
    }

    @Step("Verifying that user is on Products page")
    public ProductsPage verifyRedirectToProducts(String expectedTitle) {
        Assert.assertEquals(productsTitle.getText(), expectedTitle, "Redirection to Products page is verified with page name");
        return this;
    }

    @Step("Click Remove button")
    public HeaderArea clickRemoveBtn(int btnNumber) {
        removeBtns.get(btnNumber - 1).click();
        return new HeaderArea(driver);
    }

    @Step("Select sorting by name in descending order")
    public ProductsPage sortItemsByNameDesc() {
        sortMenu.click();
        sortByNameDESC.click();
        return this;
    }

    @Step("Verifying if items are sorted by name")
    public ProductsPage verifySortingByName() {
        String expectedItem = items.get(items.size() - 1).getText();
        Assert.assertEquals(itemName, expectedItem, "First item should become last");
        return this;
    }

    @Step("Select sorting by name in ascending order")
    public ProductsPage sortItemsByNameAsc() {
        sortMenu.click();
        sortByNameASC.click();
        return this;
    }

    @Step("Select sorting by price in ascending order")
    public ProductsPage sortItemsByPriceAsc() {
        sortMenu.click();
        sortByPriceASC.click();
        waitSelectedElement(sortByPriceASC);
        return this;
    }

    @Step("Verifying if items are sorted by price")
    public ProductsPage verifyPricesAreSorted(boolean expectedResult) {
        Double priceItem1 = new Double(Double.parseDouble(itemPrices.get(0).getText().substring(1)));
        Double priceItem2 = new Double(Double.parseDouble(itemPrices.get(1).getText().substring(1)));
        Assert.assertEquals(priceItem1 < priceItem2, expectedResult, "{priceItem2} should be greater then {priceItem1}");
        return this;
    }

    @Step("Select sorting by price in descending order")
    public ProductsPage sortItemsByPriceDesc() {
        sortMenu.click();
        sortByPriceDESC.click();
        waitSelectedElement(sortByPriceDESC);
        return this;
    }
}
