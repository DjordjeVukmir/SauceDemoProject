package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class InventoryPage extends BaseTest {

    public InventoryPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "inventory_container")
    public List<WebElement> inventory;

    public String elementsPrintedOut() {
        String a = "";
        for (int i = 0; i < inventory.size(); i++) {
            a += inventory.get(i).getText();
        }
        return a;
    }

    public void listElements() {
        for (int i = 0; i < inventory.size(); i++) {
            System.out.println(inventory.get(i).getText());
        }
    }

    @FindBy(css = ".btn_primary.btn_inventory")
    public List<WebElement> addButtons;

    @FindBy(css = ".btn_secondary.btn_inventory")
    public List<WebElement> removeButtons;





}

