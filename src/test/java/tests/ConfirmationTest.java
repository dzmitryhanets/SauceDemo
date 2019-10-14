package tests;

import io.qameta.allure.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ConfirmationPage;
import pages.HeaderArea;

public class ConfirmationTest extends BaseTest {

    @Test(description = "Cancel checkout")
    public void userIsRedirectedToCart() {
        new HeaderArea(driver)
                .clickCartIcon();
        new CartPage(driver)
                .clickCheckoutBtn();
        new ConfirmationPage(driver)
                .clickCancelBtn()
                .verifyPresenceOfItem(new CartPage(driver).checkoutBtn, true);
    }

    @Test(dataProvider = "incorrectData")
    @Description("Empty data ban")
    public void emptyDataIsNotAccepted(String firstName, String lastName, String code, String errorMessage) {
        new HeaderArea(driver)
                .clickCartIcon();
        new CartPage(driver)
                .clickCheckoutBtn();
        new ConfirmationPage(driver)
                .inputFisrtName(firstName)
                .inputLastName(lastName)
                .inputPostalCode(code)
                .clickConfirmBtn()
                .verifyIncorrectData(errorMessage);
    }

    @DataProvider
    public Object[][] incorrectData() {
        return new Object[][]{
                {"", "", "", "First Name is required"},
                {"test", "", "", "Last Name is required"},
                {"test", "test", "", "Postal Code is required"}
        };
    }
}
