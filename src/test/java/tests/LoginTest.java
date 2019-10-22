package tests;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.ProductsPage;
import utils.AllureUtils;
import utils.CapabilitiesGenerator;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Log4j2
public class LoginTest {
    WebDriver driver;

    @BeforeMethod(description = "Open browser and redirect to page")
    public void openDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
        driver = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

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

    @Test(dataProvider = "incorrectLogin", description = "Incorrect data ban")
    public void incorrectDataIsNotAccepted(String name, String password, String expectedResult) {
        new LoginPage(driver)
                .openPage()
                .inputName(name)
                .inputPassword(password)
                .clickLoginBtn()
                .verifyIncorrectLogin(expectedResult);
        log.info("\n" + "Name: " + name + "\n" + "Password: " +
                password + "\n" + "Error: " + expectedResult);
    }

    @DataProvider
    public Object[][] incorrectLogin() {
        return new Object[][]{
                {"standard_user11", "secret_sauce11", "Username and password do not match any user in this service"},
                {"locked_out_user", "secret_sauce", "Sorry, this user has been locked out."},
        };
    }

    @AfterMethod(description = "Close browser",  alwaysRun = true)
    public void driverClose(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            AllureUtils.takeScreenshot(driver);
        }
        driver.quit();
    }
}
