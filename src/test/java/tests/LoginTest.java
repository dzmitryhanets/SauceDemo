package tests;

import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void userIsSuccessfullyLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .openPage()
                .inputName("standard_user")
                .inputPassword("secret_sauce")
                .clickLoginBtn()
                .verifyLogin("Products");
    }

}
