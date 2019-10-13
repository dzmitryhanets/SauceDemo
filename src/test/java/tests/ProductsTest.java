package tests;

import org.testng.annotations.Test;
import pages.CartPage;
import pages.HeaderArea;
import pages.ItemPage;
import pages.ProductsPage;

public class ProductsTest extends BaseTest {

    @Test
    public void userIsRedirectedToItemPage() {
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.getItemName(3);
        productsPage
                .clickItem(3);
        new ItemPage(driver)
                .verifyItemPage();
    }

    @Test
    public void itemIsAddedToCart() {
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage
                .clickAddBtn(2)
                .clickAddBtn(1);
        new HeaderArea(driver)
                .verifyCount("2");
    }

    @Test
    public void itemIsAddedToCartOnCartPage() {
        new ProductsPage(driver)
                .clickAddBtn(2);
        new HeaderArea(driver)
                .clickCartIcon();
        new CartPage(driver)
                .verifyPresenceOfItem(new CartPage(driver).cartItem, true);
    }

    @Test
    public void itemIsRemovedFromCounter() {
        new ProductsPage(driver)
                .clickAddBtn(2)
                .clickRemoveBtn(1);
        new HeaderArea(driver)
                .verifyPresenceOfItem(new HeaderArea(driver).cartItemsCount, false);
    }

    @Test
    public void itemsAreSortedByNameDESC() {
        new ProductsPage(driver)
                .getItemName(1);
        new ProductsPage(driver)
                .sortItemsByNameDesc()
                .verifySortingByName();
    }

    @Test
    public void itemsAreSortedByNameASC() {
        new ProductsPage(driver)
                .sortItemsByNameDesc()
                .getItemName(1);
        new ProductsPage(driver)
                .sortItemsByNameAsc()
                .verifySortingByName();
    }

    @Test
    public void itemsAreSortedByPriceASC() {
        new ProductsPage(driver)
                .sortItemsByPriceAsc()
                .verifyPricesAreSorted(true);
    }

    @Test
    public void itemsAreSortedByPriceDESC() {
        new ProductsPage(driver)
                .sortItemsByPriceDesc()
                .verifyPricesAreSorted(false);
    }
}

