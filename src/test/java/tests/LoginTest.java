package tests;

import io.qameta.allure.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

public class LoginTest extends BaseTest {

    @Test(description = "Successful login")
    public void userIsSuccessfullyLogin() {
        new LoginPage(driver)
                .openPage()
                .inputName("standard_user")
                .inputPassword("secret_sauce")
                .clickLoginBtn();
        new ProductsPage(driver)
                .verifyRedirectToProducts("Products");
    }

    @Test(dataProvider = "incorrectLogin")
    @Description("Incorrect data ban")
    public void incorrectDataIsNotAccepted(String name, String password, String expectedResult) {
        new LoginPage(driver)
                .openPage()
                .inputName(name)
                .inputPassword(password)
                .clickLoginBtn()
                .verifyIncorrectLogin(expectedResult);
    }

    @DataProvider
    public Object[][] incorrectLogin() {
        return new Object[][]{
                {"standard_user11", "secret_sauce11", "Username and password do not match any user in this service"},
                {"locked_out_user", "secret_sauce", "Sorry, this user has been locked out."},
        };
    }
}
