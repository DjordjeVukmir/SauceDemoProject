package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutComplete extends BaseTest {
    public CheckoutComplete(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "checkout_complete_container")
    WebElement orderCompleteHeader;

    public WebElement getOrderCompleteHeader() {
        return orderCompleteHeader;
    }
}
