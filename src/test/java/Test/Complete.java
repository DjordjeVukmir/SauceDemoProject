package Test;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Complete extends BaseTest {

    @BeforeMethod
    public void completeSetup() {
        driver.navigate().to("https://www.saucedemo.com/v1/index.html");
        mainPage.inputUsername(getStandardUsername());
        mainPage.inputPassword(getPassword());
        mainPage.clickLogin();
    }

    @Test
    public void verifyThatUserCanOrderItems() {
        for (WebElement element : inventoryPage.addButtons) {
            element.click();
        }
        cartPage.clickOnCart();
        StringBuilder cartBeforeCheckout = new StringBuilder(); //SVI ITEMI IZ CARTA
        for (WebElement element : cartPage.getCartItems()) {
            cartBeforeCheckout.append(element.getText()).append("\n");
        }
        cartPage.clickCheckout();
        checkoutPageOne.enterFirstname("Djordje");
        checkoutPageOne.enterLastname("Vukmir");
        checkoutPageOne.enterZipcode("11090");
        checkoutPageOne.clickContinue();

        StringBuilder cartAfterCheckout = new StringBuilder(); //SVI ITEMI IZ CHECKOUTA
        for (WebElement element : checkoutPageTwo.getCartItems()) {
            cartAfterCheckout.append(element.getText()).append("\n");
        }
        Assert.assertEquals(cartBeforeCheckout.toString(), (cartAfterCheckout.toString()));
        checkoutPageTwo.clickFinish(); // CLICK FINISH
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/v1/checkout-complete.html");
        Assert.assertTrue(checkoutComplete.getOrderCompleteHeader().isDisplayed());
    }


}
