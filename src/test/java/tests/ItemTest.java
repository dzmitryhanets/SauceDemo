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
                .verifyPresenceOfItem(true);
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
                .verifyPresenceOfItem(false);
    }

    @Test(description = "Removing goods from counter")
    public void itemIsRemovedFromCounter() {
        new ProductsPage(driver)
                .clickItem(2);
        new ItemPage(driver)
                .clickAddBtn()
                .clickRemoveBtn()
                .verifyPresenceOfItem(false);
    }

    @Test(description = "Back button working")
    public void userIsRedirectedFromItemDetailsPage() {
        new ProductsPage(driver)
                .clickItem(3);
        new ItemPage(driver)
                .clickBackButton()
                .verifyRedirectToProducts("Products");
    }
}
