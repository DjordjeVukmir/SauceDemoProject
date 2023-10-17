package Test;

import Base.BaseTest;
import Base.ExcelReader;
import org.openqa.selenium.WebElement;
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
    public void verifyThatUserCanCheckoutWithValidData() {
        //int lastRow = excelReader.getLastRow("Sheet1");

        for (int i = 1; i < excelReader.getLastRow("Sheet1"); i++) {
            String firstname = excelReader.getStringData("Sheet1", i, 0);
            String lastname = excelReader.getStringData("Sheet1", i, 1);
            String zipcode = excelReader.getStringData("Sheet1", i, 2);

            checkoutPageOne.enterFirstname(firstname);
            checkoutPageOne.enterLastname(lastname);
            checkoutPageOne.enterZipcode(zipcode);
            checkoutPageOne.clickContinue();
            Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/v1/checkout-step-two.html");
            driver.navigate().back();
        }
    }
    @Test
    public void verifyThatUserCannotCheckoutWithInvalidData() {
        //int lastRow = excelReader.getLastRow("Sheet1");

        for (int i = 1; i < excelReaderInvalid.getLastRow("Sheet1"); i++) {
            String firstname = excelReaderInvalid.getStringData("Sheet1", i, 0);
            String lastname = excelReaderInvalid.getStringData("Sheet1", i, 1);
            String zipcode = excelReaderInvalid.getStringData("Sheet1", i, 2);

            checkoutPageOne.enterFirstname(firstname);
            checkoutPageOne.enterLastname(lastname);
            checkoutPageOne.enterZipcode(zipcode);
            checkoutPageOne.clickContinue();
            Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/v1/checkout-step-one.html");
            driver.navigate().back();
        }
    }

    @Test
    public void verifyThatUserCanContinueWithCheckout(){
        verifyThatUserCanCheckoutWithValidData();
        checkoutPageOne.clickContinue();
        Assert.assertEquals(checkoutPageTwo.getTotalSum().getText(), "Total: $0.00");

    }

    @Test
    public void verifyThatUserCanOrderItems() throws InterruptedException {
        driver.navigate().to("https://www.saucedemo.com/v1/index.html");
        mainPage.inputUsername(getStandardUsername());
        mainPage.inputPassword(getPassword());
        mainPage.clickLogin();
        for (WebElement element : inventoryPage.addButtons) {
            element.click();
        }
        cartPage.clickOnCart();
        StringBuilder cartBeforeCheckout = new StringBuilder(); //SVI ITEMI IZ CARTA
        for (WebElement element : cartPage.getCartItems()){
            cartBeforeCheckout.append(element.getText()).append("\n");
        }
        cartPage.clickCheckout();
        verifyThatUserCanCheckoutWithValidData();
        checkoutPageOne.clickContinue();

        StringBuilder cartAfterCheckout = new StringBuilder(); //SVI ITEMI IZ CHECKOUTA
        for (WebElement element : checkoutPageTwo.getCartItems()){
            cartAfterCheckout.append(element.getText()).append("\n");
        }
        Assert.assertEquals(cartBeforeCheckout.toString(), (cartAfterCheckout.toString()));
        checkoutPageTwo.clickFinish(); // CLICK FINISH
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/v1/checkout-complete.html");
        Assert.assertTrue(checkoutComplete.getOrderCompleteHeader().isDisplayed());



    }
//    @Test
//    public void verifyThatUserCannotCheckoutWithIncompleteData(){
//        //int lastRow = excelReader.getLastRow("Sheet1");
//
//        for (int i = 1; i < excelReaderInvalid.getLastRow("Sheet1"); i++) {
//            String firstname = excelReaderInvalid.getStringData("Sheet1", i, 3);
//            String lastname = excelReaderInvalid.getStringData("Sheet1", i, 4);
//            String zipcode = excelReaderInvalid.getStringData("Sheet1", i, 5);
//
//// Check if the data is empty or null and handle it appropriately
//            if (firstname != null && !firstname.isEmpty()) {
//                checkoutPageOne.enterFirstname(firstname);
//            }
//            if (lastname != null && !lastname.isEmpty()) {
//                checkoutPageOne.enterLastname(lastname);
//            }
//            if (zipcode != null && !zipcode.isEmpty()) {
//                checkoutPageOne.enterZipcode(zipcode);
//            }
//
//            checkoutPageOne.clickContinue();
//            Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/v1/checkout-step-one.html");
//            driver.navigate().back();
//        }
//    }
}
