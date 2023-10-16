package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.reporters.jq.Main;

public class MainPage extends BaseTest {

    public MainPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-name")
    WebElement usernameField;

    public WebElement getUsernameField() {
        return usernameField;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public void inputUsername(String username){
        usernameField.sendKeys(username);
    }
    @FindBy(id = "password" )
    WebElement passwordField;
    public void inputPassword(String password){
        passwordField.sendKeys(password);
    }
    @FindBy(id = "login-button")
    WebElement loginButton;
    public void clickLogin(){
        loginButton.click();
    }

    @FindBy(className = "error-button")
    public WebElement error;


}
