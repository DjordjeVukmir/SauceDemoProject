package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckoutPageOne extends BaseTest {

    public CheckoutPageOne() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "first-name")
    WebElement firstnameField;
    public void enterFirstname(String firstname){
        firstnameField.sendKeys(firstname);
    }

    @FindBy(id = "last-name")
    WebElement lastnameField;
    public void enterLastname(String lastname){
        lastnameField.sendKeys(lastname);
    }
    @FindBy(id = "postal-code")
    WebElement zipcodeField;
    public void enterZipcode(String zipcode){
        zipcodeField.sendKeys(zipcode);
    }

    @FindBy(css = "#checkout_info_container > div > form > div.checkout_buttons > input")
    WebElement continueButton;
    public void clickContinue(){
        continueButton.click();
    }

    @FindBy(css = "#checkout_info_container > div > form > div.checkout_buttons > a")
    WebElement cancelButton;

    public void clickCancel(){
        cancelButton.click();
    }
    public WebElement getFirstnameField() {
        return firstnameField;
    }

    public WebElement getLastnameField() {
        return lastnameField;
    }

    public WebElement getZipcodeField() {
        return zipcodeField;
    }





}
