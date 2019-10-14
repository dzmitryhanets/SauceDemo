package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.AllureUtils;

public abstract class BasePage {
    public WebDriver driver;

    BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isElementPresented(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Step("Verifying if element is presented on page")
    public void verifyPresenceOfItem(WebElement element, boolean isPresented) {
        Assert.assertEquals(isElementPresented(element), isPresented);
        AllureUtils.takeScreenshot(driver);
    }

    public abstract void isPageOpened();

    /*public abstract void openPage();*/
}
