package tests;

import org.testng.annotations.Test;
import pages.CartPage;
import pages.HeaderArea;
import pages.ItemPage;
import pages.ProductsPage;

public class ItemTest extends BaseTest {

    @Test
    public void itemIsAddedToCart() {
        new ProductsPage(driver)
                .clickItem(2);
        new ItemPage(driver)
                .clickAddBtn();
        new HeaderArea(driver)
                .verifyCount("1");
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
                .verifyPresenceOfItem();
    }
}
