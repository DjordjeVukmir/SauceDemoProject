package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends BaseTest {

    public CartPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#cart_contents_container > div > div.cart_footer > a.btn_secondary")
    public WebElement continueShoppingButton;
    public void clickContinue(){
        continueShoppingButton.click();
    }
    @FindBy(css = ".btn_action.checkout_button")
    WebElement checkoutButton;
    public void clickCheckout(){
        checkoutButton.click();
    }
    @FindBy(id = "shopping_cart_container")
    WebElement cartButton;
    public void clickOnCart(){
        cartButton.click();
    }

    @FindBy(className = "cart_item")
    public List<WebElement> cartList;

    public int amountOfCartItems(){
        int amount = 0;
        for (int i = 0; i < cartList.size(); i++) {
            amount++;
        }
        return amount;
    }

    public void printCart(){
        for (int i = 0; i < cartList.size(); i++) {
            System.out.println(cartList.get(i).getText());
        }
    }

    @FindBy(css = "#cart_contents_container > div > div.cart_list > div.cart_item > div.cart_item_label > div.item_pricebar > button")
    public List<WebElement> cartRemoveButton;

    @FindBy(css = ".fa-layers-counter.shopping_cart_badge")
    public WebElement cartCounter;

}
