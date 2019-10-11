package tests;

import org.testng.annotations.Test;
import pages.*;

public class ItemTest extends BaseTest {

    @Test
    public void itemIsAddedToCartOnCounter() {
        new ProductsPage(driver)
                .clickItem(2);
        new ItemPage(driver)
                .clickAddBtn();
        new HeaderArea(driver)
                .verifyCount("1");
    }

    @Test
    public void itemIsAddedToCartOnCartPage() {
        new ProductsPage(driver)
                .clickItem(2);
        new ItemPage(driver)
                .clickAddBtn();
        new HeaderArea(driver)
                .clickCartIcon();
        new CartPage(driver)
                .verifyPresenceOfItem(new CartPage(driver).cartItem, true);
    }

    @Test
    public void itemIsRemovedFromCart() {
        new ProductsPage(driver)
                .clickItem(2);
        new ItemPage(driver)
                .clickAddBtn()
                .clickRemoveBtn();
        new HeaderArea(driver)
                .clickCartIcon();
        new CartPage(driver)
                .verifyPresenceOfItem(new CartPage(driver).cartItem, false);
    }

    @Test
    public void itemIsRemovedFromCounter() {
        new ProductsPage(driver)
                .clickItem(2);
        new ItemPage(driver)
                .clickAddBtn()
                .clickRemoveBtn();
        new HeaderArea(driver)
                .verifyPresenceOfItem(new HeaderArea(driver).cartItemsCount, false);
    }

    @Test
    public void userIsRedirectedFromItemDetailsPage() {
        new ProductsPage(driver)
                .clickItem(3);
        new ItemPage(driver)
                .clickBackButton();
        new ProductsPage(driver)
                .verifyRedirectToProducts("Products");
    }
}
