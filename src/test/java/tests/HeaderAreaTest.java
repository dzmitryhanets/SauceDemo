package tests;

import org.testng.annotations.Test;
import pages.HeaderArea;
import pages.LoginPage;
import pages.ProductsPage;

public class HeaderAreaTest extends BaseTest {

    @Test
    public void appStateIsReset() {
        new ProductsPage(driver)
                .clickAddBtn(2);
        new HeaderArea(driver)
                .clickMenuBtn()
                .resetAppState()
                .closeMenu()
                .verifyPresenceOfItem(new HeaderArea(driver).cartItemsCount, false);
    }

    @Test
    public void userIsRedirected() {
        new HeaderArea(driver)
                .clickMenuBtn()
                .clickAboutItem()
                .validateURL("https://saucelabs.com/");
    }

    @Test
    public void userIsLoggedOut() {
        new HeaderArea(driver)
                .clickMenuBtn()
                .clickLogout();
        new LoginPage(driver)
                .verifyLoginBtn();
    }

    @Test
    public void userIsRedirectedToInventory() {
        new ProductsPage(driver)
                .clickItem(4);
        new HeaderArea(driver)
                .clickMenuBtn()
                .clickInventoryItem();
        new ProductsPage(driver)
                .verifyRedirectToProducts("Products");
    }
}
