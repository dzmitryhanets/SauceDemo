package tests;

import org.testng.annotations.Test;
import pages.*;

public class OverviewTest extends BaseTest {

    @Test(description = "Order cancellation")
    public void userIsAbleToCancelOrder() {
        new ProductsPage(driver)
                .clickAddBtn(2);
        new HeaderArea(driver)
                .clickCartIcon()
                .clickCheckoutBtn()
                .inputFisrtName("test")
                .inputLastName("test")
                .inputPostalCode("test")
                .clickConfirmBtn();
        new OverviewPage(driver)
                .cancelOrder()
                .verifyRedirectToProducts("Products");
    }

    @Test(description = "Finish order")
    public void userIsAbleToFinishOrder() {
        new ProductsPage(driver)
                .clickAddBtn(2);
        new HeaderArea(driver)
                .clickCartIcon()
                .clickCheckoutBtn()
                .inputFisrtName("test")
                .inputLastName("test")
                .inputPostalCode("test")
                .clickConfirmBtn();
        new OverviewPage(driver)
                .finishOrder()
                .verifySuccessOrder("THANK YOU FOR YOUR ORDER");
    }
}
