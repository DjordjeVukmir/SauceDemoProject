package Test;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Inventory extends BaseTest {


    @BeforeMethod
    public void inventoryPageSetUp() {

        driver.navigate().to("https://www.saucedemo.com/v1/index.html");
        mainPage.inputUsername(getStandardUsername());
        mainPage.inputPassword(getPassword());
        mainPage.clickLogin();

    }


    @Test
    public void verifyThatTheInventoryIsComplete() throws InterruptedException {

        String inventory = "Products\n" +
                "Name (A to Z)\n" +
                "Name (Z to A)\n" +
                "Price (low to high)\n" +
                "Price (high to low)\n" +
                "Sauce Labs Backpack\n" +
                "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.\n" +
                "$29.99\n" +
                "ADD TO CART\n" +
                "Sauce Labs Bike Light\n" +
                "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.\n" +
                "$9.99\n" +
                "ADD TO CART\n" +
                "Sauce Labs Bolt T-Shirt\n" +
                "Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.\n" +
                "$15.99\n" +
                "ADD TO CART\n" +
                "Sauce Labs Fleece Jacket\n" +
                "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.\n" +
                "$49.99\n" +
                "ADD TO CART\n" +
                "Sauce Labs Onesie\n" +
                "Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.\n" +
                "$7.99\n" +
                "ADD TO CART\n" +
                "Test.allTheThings() T-Shirt (Red)\n" +
                "This classic Sauce Labs t-shirt is perfect to wear when cozying up to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton.\n" +
                "$15.99\n" +
                "ADD TO CARTSauce Labs Backpack\n" +
                "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.\n" +
                "$29.99\n" +
                "ADD TO CART\n" +
                "Sauce Labs Bike Light\n" +
                "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.\n" +
                "$9.99\n" +
                "ADD TO CART\n" +
                "Sauce Labs Bolt T-Shirt\n" +
                "Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.\n" +
                "$15.99\n" +
                "ADD TO CART\n" +
                "Sauce Labs Fleece Jacket\n" +
                "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.\n" +
                "$49.99\n" +
                "ADD TO CART\n" +
                "Sauce Labs Onesie\n" +
                "Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.\n" +
                "$7.99\n" +
                "ADD TO CART\n" +
                "Test.allTheThings() T-Shirt (Red)\n" +
                "This classic Sauce Labs t-shirt is perfect to wear when cozying up to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton.\n" +
                "$15.99\n" +
                "ADD TO CART";



        Assert.assertEquals(inventoryPage.elementsPrintedOut(), inventory);

    } //Verifying that all elements are actually on the page - no thumbnails included

    @Test
    public void verify_that_all_items_in_store_can_be_added_to_cart(){    //Verifying that every single item can be added to cart
        for(WebElement element : inventoryPage.addButtons){
            element.click();
        }
        for(WebElement element : inventoryPage.removeButtons){
            Assert.assertTrue(element.isDisplayed());
        }
        String expectedNumber = cartPage.cartCounter.getText();
        Assert.assertEquals("6", expectedNumber);
    }

    @Test
    public void verify_that_the_cart_counter_increased(){

        for(WebElement element : inventoryPage.addButtons){
            element.click();
        }
        String expectedNumber = cartPage.cartCounter.getText();
        Assert.assertEquals("6", expectedNumber);
    }

    @Test
    public void verify_that_all_items_can_be_removed_from_cart(){

        for(WebElement element : inventoryPage.addButtons){
            element.click();
        }
        for(WebElement element : inventoryPage.removeButtons){
                element.click();
        }
        for(WebElement element : inventoryPage.addButtons){
            Assert.assertTrue(element.isDisplayed());
        }
    }
    @Test
    public void verifySortingZtoAFunctionsProperly(){
        //List of names before sorting
        ArrayList itemNamesAZ = inventoryPage.names();
                //Reversed original list
        Collections.sort(itemNamesAZ, Collections.reverseOrder());
        //------------------------------------------
        //Choosing how to sort
        sorterDropdownPage.selectZtoA();
        //New list of sorted item names
        ArrayList itemNamesAfterSorting = inventoryPage.names();

        Assert.assertEquals(itemNamesAZ, itemNamesAfterSorting);

    }
    @Test
    public void verifySortingPricesWorksProperly() {
        List<Double> prices = inventoryPage.extractPrices(); //Getting prices from the inventory page
        //Sorting prices LOW TO HIGH
        Collections.sort(prices);
        sorterDropdownPage.selectLowHi();
        //New list of prices
        List<Double> pricesLowHigh = inventoryPage.extractPrices(); //Getting prices that are now sorted
        Assert.assertEquals(prices, pricesLowHigh);



    }




}
