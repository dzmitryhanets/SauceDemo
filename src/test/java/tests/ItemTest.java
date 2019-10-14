package tests;

import org.testng.annotations.Test;
import pages.*;

public class ItemTest extends BaseTest {

    @Test(description = "Adding goods on the counter")
    public void itemIsAddedToCartOnCounter() {
        new ProductsPage(driver)
                .clickItem(2);
        new ItemPage(driver)
                .clickAddBtn();
        new HeaderArea(driver)
                .verifyCount("1");
    }

    @Test(description = "Adding goods in cart")
    public void itemIsAddedToCartOnCartPage() {
        new ProductsPage(driver)
                .clickItem(2);
        new ItemPage(driver)
                .clickAddBtn();
        new HeaderArea(driver)
                .clickCartIcon()
                .verifyPresenceOfItem(new CartPage(driver).cartItem, true);
    }

    @Test(description = "Removing items from cart")
    public void itemIsRemovedFromCart() {
        new ProductsPage(driver)
                .clickItem(2);
        new ItemPage(driver)
                .clickAddBtn()
                .clickRemoveBtn();
        new HeaderArea(driver)
                .clickCartIcon()
                .verifyPresenceOfItem(new CartPage(driver).cartItem, false);
    }

    @Test(description = "Removing goods from counter")
    public void itemIsRemovedFromCounter() {
        new ProductsPage(driver)
                .clickItem(2);
        new ItemPage(driver)
                .clickAddBtn()
                .clickRemoveBtn()
                .verifyPresenceOfItem(new HeaderArea(driver).cartItemsCount, false);
    }

    @Test(description = "Back button working")
    public void userIsRedirectedFromItemDetailsPage() {
        ProductsPage productsPage = new ProductsPage(driver)
                .clickItem(3);
        new ItemPage(driver)
                .clickBackButton();
        productsPage.verifyRedirectToProducts("Products");
    }
}
