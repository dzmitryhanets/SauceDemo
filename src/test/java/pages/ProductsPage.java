package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

@Log4j2
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

    private boolean isItemsAreSorted = false;

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
        Assert.assertEquals(productsTitle.getText(), expectedTitle, "Redirection to Products page verified with page name");
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
        for (int i = 0; i < items.size() - 1; i++) {
            if (items.get(i).getText().compareTo(items.get(i + 1).getText()) > 0) {
                isItemsAreSorted = true;
            }
        }
        return this;
    }

    @Step("Verifying if items are sorted by name")
    public ProductsPage verifySortingByName() {
        Assert.assertTrue(isItemsAreSorted);
        return this;
    }

    @Step("Select sorting by name in ascending order")
    public ProductsPage sortItemsByNameAsc() {
        sortMenu.click();
        sortByNameASC.click();
        for (int i = 0; i < items.size() - 1; i++) {
            if (items.get(i).getText().compareTo(items.get(i + 1).getText()) < 0) {
                isItemsAreSorted = true;
            }
        }
        return this;
    }

    @Step("Select sorting by price in ascending order")
    public ProductsPage sortItemsByPriceAsc() {
        sortMenu.click();
        sortByPriceASC.click();
        waitSelectedElement(sortByPriceASC);
        for (int i = 0; i < itemPrices.size() - 1; i++) {
            if (new Double(Double.parseDouble(itemPrices.get(i).getText().substring(1))) < new Double(Double.parseDouble(itemPrices.get(i + 1).getText().substring(1)))) {
                isItemsAreSorted = true;
            }
        }
        return this;
    }

    @Step("Verifying if items are sorted by price")
    public ProductsPage verifyPricesAreSorted() {
        Assert.assertTrue(isItemsAreSorted);
        log.info("\n" + "Item price 1: " + itemPrices.get(0).getText().substring(1) + "\n" +
                "Item price 2: " + itemPrices.get(1).getText().substring(1));
        return this;
    }

    @Step("Select sorting by price in descending order")
    public ProductsPage sortItemsByPriceDesc() {
        sortMenu.click();
        sortByPriceDESC.click();
        waitSelectedElement(sortByPriceDESC);
        for (int i = 0; i < itemPrices.size() - 1; i++) {
            if (new Double(Double.parseDouble(itemPrices.get(i).getText().substring(1))) > new Double(Double.parseDouble(itemPrices.get(i + 1).getText().substring(1)))) {
                isItemsAreSorted = true;
            }
        }
        return this;
    }
}
