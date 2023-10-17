package Test;

import Base.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Cart extends BaseTest {

    @BeforeMethod
    public void cartSetUp() {
        driver.navigate().to("https://www.saucedemo.com/v1/index.html");
        mainPage.inputUsername(getStandardUsername());
        mainPage.inputPassword(getPassword());
        mainPage.clickLogin();
        for (WebElement element : inventoryPage.addButtons) {
            element.click();
        }
    }

    @Test
    public void verify_that_cart_lists_all_added_items() {
        cartPage.clickOnCart();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/v1/cart.html");
        for (WebElement element : cartPage.cartList) {
            Assert.assertTrue(element.isDisplayed());
        }
        cartPage.printCartItems();

    }

    @Test
    public void verify_that_continue_button_functions_as_intended(){
        cartPage.clickOnCart();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cartPage.continueShoppingButton);
        cartPage.clickContinue();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/v1/inventory.html");
    }

    @Test
    public void verify_that_items_can_be_removed_from_cart(){
        cartPage.clickOnCart();
        for(WebElement element : cartPage.cartRemoveButton){
            element.click();
        }
        Assert.assertEquals(cartPage.cartList.size(), 0);
    }

//    @Test
//    public void printer(){
//        cartPage.clickOnCart();
//        for(WebElement element : cartPage.cartRemoveButton){
//            System.out.println(element.getText());
//        }
//
//    }
}
