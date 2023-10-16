package Test;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login extends BaseTest {

    @BeforeMethod
    public void loginPageSetUp(){
        driver.navigate().to("https://www.saucedemo.com/v1/index.html");
    }

    @Test
    public void testUserLoginAsStandardUser(){
            //verify that the user can log in with standard user credentials
        mainPage.inputUsername(getStandardUsername());
        mainPage.inputPassword(getPassword());
        mainPage.clickLogin();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/v1/inventory.html");
    }
    @Test
    public void testUserLoginAsProblemUser(){
        mainPage.inputUsername(getProblemUsername());
        mainPage.inputPassword(getPassword());
        mainPage.clickLogin();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/v1/inventory.html");
    }
    @Test
    public void testUserLoginAsPerformanceGlitchUser(){
        mainPage.inputUsername(getPerformanceGlitchUsername());
        mainPage.inputPassword(getPassword());
        mainPage.clickLogin();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/v1/inventory.html");
    }
    @Test
    public void verifyLockedOutUserCannotLogin(){
        mainPage.inputUsername(getLockedOutUsername());
        mainPage.inputPassword(getPassword());
        mainPage.clickLogin();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/v1/index.html");
        Assert.assertTrue(mainPage.error.isDisplayed());
    }

    @Test
    public void verifyThatUserCannotLoginWithBlankFields(){
        mainPage.inputUsername("");
        mainPage.inputPassword("");
        mainPage.clickLogin();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/v1/index.html");
        Assert.assertTrue(mainPage.error.isDisplayed());
    }
    @Test
    public void verify_that_user_cannot_login_with_blank_username_and_correct_password(){
        mainPage.inputUsername("");
        mainPage.inputPassword(getPassword());
        mainPage.clickLogin();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/v1/index.html");
        Assert.assertTrue(mainPage.error.isDisplayed());
    }
    @Test
    public void verify_that_user_cannot_login_with_correct_username_and_blank_password(){
        mainPage.inputUsername(getStandardUsername());
        mainPage.inputPassword("");
        mainPage.clickLogin();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/v1/index.html");
        Assert.assertTrue(mainPage.error.isDisplayed());
    }

    @Test
    public void verify_that_user_cannot_log_in_with_incorrect_username(){
        mainPage.inputUsername("Djordje123");
        mainPage.inputPassword(getPassword());
        mainPage.clickLogin();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/v1/index.html");
        Assert.assertTrue(mainPage.error.isDisplayed());
    }
    @Test
    public void verify_that_user_cannot_log_in_with_incorrect_password(){
        mainPage.inputUsername(getStandardUsername());
        mainPage.inputPassword("notAValidPassword");
        mainPage.clickLogin();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/v1/index.html");
        Assert.assertTrue(mainPage.error.isDisplayed());
    }

}
