package tests;

import org.testng.annotations.Test;
import pages.HeaderArea;
import pages.LoginPage;
import pages.ProductsPage;

public class HeaderAreaTest extends BaseTest {

    @Test(description = "Reset App State working")
    public void appStateIsReset() {
        new ProductsPage(driver)
                .clickAddBtn(2);
        new HeaderArea(driver)
                .clickMenuBtn()
                .resetAppState()
                .closeMenu()
                .verifyPresenceOfItem(false);
    }

    @Test(description = "About link working")
    public void userIsRedirected() {
        new HeaderArea(driver)
                .clickMenuBtn()
                .clickAboutItem()
                .validateURL("https://saucelabs.com/");
    }

    @Test(description = "Logout working")
    public void userIsLoggedOut() {
        new HeaderArea(driver)
                .clickMenuBtn()
                .clickLogout()
                .verifyPresenceOfItem(true);
    }

    @Test(description = "All Items link working" )
    public void userIsRedirectedToInventory() {
        new ProductsPage(driver)
                .clickItem(4);
        new HeaderArea(driver)
                .clickMenuBtn()
                .clickInventoryItem()
                .verifyRedirectToProducts("Products");
    }
}
