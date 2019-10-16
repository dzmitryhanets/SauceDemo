package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HeaderArea;

public class ConfirmationTest extends BaseTest {

    @Test(description = "Cancel checkout")
    public void userIsRedirectedToCart() {
        new HeaderArea(driver)
                .clickCartIcon()
                .clickCheckoutBtn()
                .clickCancelBtn()
                .verifyPresenceOfItem(false);
    }

    @Test(dataProvider = "incorrectData", description = "Empty data ban")
    public void emptyDataIsNotAccepted(String firstName, String lastName, String code, String errorMessage) {
        new HeaderArea(driver)
                .clickCartIcon()
                .clickCheckoutBtn()
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
