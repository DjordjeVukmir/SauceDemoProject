package BurgerMenu_SideBar;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BurgerMenuPage extends BaseTest {

    public BurgerMenuPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "bm-burger-button")
    WebElement burgerMenu;
    public void clickOnTheBurgerMenu(){
        burgerMenu.click();
    }

    @FindBy(id = "about_sidebar_link")
    WebElement burgerAboutButton;
    public void clickBurgerAboutButton(){
        burgerAboutButton.click();
    }

    @FindBy(id = "logout_sidebar_link")
    WebElement logoutButton;
    public void clickLogout(){
        logoutButton.click();
    }

    @FindBy(id = "inventory_sidebar_link")
    WebElement inventoryButton;
    public void clickOnInventory(){
        inventoryButton.click();
    }
}
