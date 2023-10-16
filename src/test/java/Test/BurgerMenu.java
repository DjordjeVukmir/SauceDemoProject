package Test;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BurgerMenu extends BaseTest {

    @BeforeMethod
    public void bsetUp() {
        driver.navigate().to("https://www.saucedemo.com/v1/index.html");
        mainPage.inputUsername(getStandardUsername());
        mainPage.inputPassword(getPassword());
        mainPage.clickLogin();

    }
    @Test
    public void burgerMenuFunctionality(){
        burgerMenuPage.clickOnTheBurgerMenu();
        burgerMenuPage.clickBurgerAboutButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://saucelabs.com/");
        driver.navigate().back();
        driver.navigate().refresh();
        burgerMenuPage.clickOnTheBurgerMenu();
        burgerMenuPage.clickOnInventory();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/v1/inventory.html");
        burgerMenuPage.clickOnTheBurgerMenu();
        burgerMenuPage.clickLogout();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/v1/index.html");
        Assert.assertTrue(mainPage.getUsernameField().isDisplayed());
        Assert.assertTrue(mainPage.getPasswordField().isDisplayed());
        Assert.assertTrue(mainPage.getLoginButton().isDisplayed());

    }

}
