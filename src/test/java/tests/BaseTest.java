package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver driver;

    @BeforeMethod
    public void openDriver(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .openPage()
                .inputName("standard_user")
                .inputPassword("secret_sauce")
                .clickLoginBtn();
    }

    @AfterMethod
    public void closeDriver() {
        driver.quit();
    }
}
