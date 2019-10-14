package tests;

import org.testng.annotations.Test;
import pages.CartPage;
import pages.HeaderArea;
import pages.ProductsPage;

public class CartTest extends BaseTest {

    @Test(description = "Continue Shopping btn working capacity")
    public void userIsRedirectedToProducts() {
        new HeaderArea(driver)
                .clickCartIcon();
        new CartPage(driver)
                .clickContinueBtn();
        new ProductsPage(driver)
                .verifyRedirectToProducts("Products");
    }
}
