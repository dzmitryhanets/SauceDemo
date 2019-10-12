package tests;

import org.testng.annotations.Test;
import pages.*;

public class OverviewTest extends BaseTest {

    @Test
    public void userIsAbleToCancelOrder() {
        new ProductsPage(driver)
                .clickAddBtn(2);
        new HeaderArea(driver)
                .clickCartIcon();
        new CartPage(driver)
                .clickCheckoutBtn();
        new ConfirmationPage(driver)
                .inputFisrtName("test")
                .inputLastName("test")
                .inputPostalCode("test")
                .clickConfirmBtn();
        new OverviewPage(driver)
                .cancelOrder();
        new ProductsPage(driver)
                .verifyRedirectToProducts("Products");
    }

    @Test
    public void userIsAbleToFinishOrder() {
        new ProductsPage(driver)
                .clickAddBtn(2);
        new HeaderArea(driver)
                .clickCartIcon();
        new CartPage(driver)
                .clickCheckoutBtn();
        new ConfirmationPage(driver)
                .inputFisrtName("test")
                .inputLastName("test")
                .inputPostalCode("test")
                .clickConfirmBtn();
        new OverviewPage(driver)
                .finishOrder();
        new SuccessPage(driver)
                .verifySuccessOrder("THANK YOU FOR YOUR ORDER");
    }
}
