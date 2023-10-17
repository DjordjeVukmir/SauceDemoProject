package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckoutPageTwo extends BaseTest {

    public CheckoutPageTwo(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".btn_action.cart_button")
    WebElement finishButton;
    public void clickFinish(){
        finishButton.click();
    }
    @FindBy(css = ".cart_cancel_link.btn_secondary")
    WebElement cancelButton;
    public void clickCancel(){
        cancelButton.click();
    }

    @FindBy(className = "inventory_item_name")
    List<WebElement> cartItems;

    public List<WebElement> getCartItems() {
        return cartItems;
    }

    public WebElement getTotalSum() {
        return totalSum;
    }

    @FindBy(className = "summary_total_label")
    WebElement totalSum;


}
