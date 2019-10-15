package tests;

import org.testng.annotations.Test;
import pages.HeaderArea;
import pages.ItemPage;
import pages.ProductsPage;

public class ProductsTest extends BaseTest {

    @Test(description = "Redirection to Details page")
    public void userIsRedirectedToItemPage() {
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.getItemName(3);
        productsPage
                .clickItem(3);
        new ItemPage(driver)
                .verifyItemPage();
    }

    @Test(description = "Items count")
    public void itemIsAddedToCart() {
        new ProductsPage(driver)
                .clickAddBtn(2)
                .clickAddBtn(1);
        new HeaderArea(driver)
                .verifyCount("2");
    }

    @Test(description = "Items in cart")
    public void itemIsAddedToCartOnCartPage() {
        new ProductsPage(driver)
                .clickAddBtn(2);
        new HeaderArea(driver)
                .clickCartIcon()
                .verifyPresenceOfItem(true);
    }

    @Test(description = "Empty counter")
    public void itemIsRemovedFromCounter() {
        new ProductsPage(driver)
                .clickAddBtn(2)
                .clickRemoveBtn(1)
                .verifyPresenceOfItem(false);
    }

    @Test(description = "Sort by name in descending order")
    public void itemsAreSortedByNameDESC() {
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.getItemName(1);
        productsPage
                .sortItemsByNameDesc()
                .verifySortingByName();
    }

    @Test(description = "Sort by name in ascending order")
    public void itemsAreSortedByNameASC() {
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.sortItemsByNameDesc()
                .getItemName(1);
        productsPage
                .sortItemsByNameAsc()
                .verifySortingByName();
    }

    @Test(description = "Sort by price in ascending order")
    public void itemsAreSortedByPriceASC() {
        new ProductsPage(driver)
                .sortItemsByPriceAsc()
                .verifyPricesAreSorted(true);
    }

    @Test(description = "Sort by price in descending order")
    public void itemsAreSortedByPriceDESC() {
        new ProductsPage(driver)
                .sortItemsByPriceDesc()
                .verifyPricesAreSorted(false);
    }
}

