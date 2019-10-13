package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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

    public ProductsPage clickAddBtn(int itemNumber) {
        addBtns.get(itemNumber - 1).click();
        return this;
    }

    public ProductsPage verifyRedirectToProducts(String expectedTitle) {
        Assert.assertEquals(productsTitle.getText(), expectedTitle);
        return new ProductsPage(driver);
    }

    public ProductsPage clickRemoveBtn(int btnNumber) {
        removeBtns.get(btnNumber - 1).click();
        return this;
    }

    public ProductsPage sortItemsByNameDesc() {
        sortMenu.click();
        sortByNameDESC.click();
        return this;
    }

    public ProductsPage verifySortingByName() {
        String expectedItem = items.get(items.size() - 1).getText();
        Assert.assertEquals(itemName, expectedItem);
        return this;
    }

    public ProductsPage sortItemsByNameAsc() {
        sortMenu.click();
        sortByNameASC.click();
        return this;
    }

    public ProductsPage sortItemsByPriceAsc() {
        sortMenu.click();
        sortByPriceASC.click();
        wait.until(ExpectedConditions.elementToBeSelected(sortByPriceASC));
        return this;
    }

    public ProductsPage verifyPricesAreSorted(boolean expectedResult) {
        Double priceItem1 = new Double(Double.parseDouble(itemPrices.get(0).getText().substring(1)));
        Double priceItem2 = new Double(Double.parseDouble(itemPrices.get(1).getText().substring(1)));
        Assert.assertEquals(priceItem1 < priceItem2, expectedResult);
        return this;
    }

    public ProductsPage sortItemsByPriceDesc() {
        sortMenu.click();
        sortByPriceDESC.click();
        wait.until(ExpectedConditions.elementToBeSelected(sortByPriceDESC));
        return this;
    }
}
