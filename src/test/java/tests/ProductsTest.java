package tests;

import org.testng.annotations.Test;
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
                .clickAddBtn(2);
        productsPage
                .clickAddBtn(1)
                .verifyCount("2");
    }
}
