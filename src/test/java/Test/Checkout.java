package Test;

import Base.BaseTest;
import Base.ExcelReader;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Checkout extends BaseTest {

    @BeforeMethod
    public void checkoutOneSetUp() {
        driver.navigate().to("https://www.saucedemo.com/v1/index.html");
        mainPage.inputUsername(getStandardUsername());
        mainPage.inputPassword(getPassword());
        mainPage.clickLogin();
        cartPage.clickOnCart();
        cartPage.clickCheckout();
    }

    @Test
    public void verifyPage() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/v1/checkout-step-one.html");
        Assert.assertTrue(checkoutPageOne.getFirstnameField().isDisplayed());
        Assert.assertTrue(checkoutPageOne.getLastnameField().isDisplayed());
        Assert.assertTrue(checkoutPageOne.getZipcodeField().isDisplayed());
    }

    @Test
    public void verifyThatUserCanEnterData() {
        //int lastRow = excelReader.getLastRow("Sheet1");

        for (int i = 1; i < 3; i++) {
            String firstname = excelReader.getStringData("Sheet1", i, 0);
            String lastname = excelReader.getStringData("Sheet1", i, 1);
            String zipcode = excelReader.getStringData("Sheet1", i, 2);

            checkoutPageOne.enterFirstname(firstname);
            checkoutPageOne.enterLastname(lastname);
            checkoutPageOne.enterZipcode(zipcode);

        }
    }
}
