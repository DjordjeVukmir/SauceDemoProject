package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
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

    @FindBy(className = "inventory_item_name")
    List<WebElement> itemNamesList;

    public List<WebElement> getItemNamesList() {
        return itemNamesList;
    }

    public ArrayList names(){
        ArrayList names = new ArrayList<>();
        for (WebElement element : getItemNamesList()){
            names.add(element.getText());
        }
        return names;
    }

    @FindBy(className = "inventory_item_price")
    List<WebElement> itemPriceList;

    public List<WebElement> getItemPriceList() {
        return itemPriceList;
    }

    public List<Double> extractPrices() {
        List<Double> prices = new ArrayList<>();
        for (WebElement element : getItemPriceList()) {
            String priceText = element.getText();
            // Remove dollar signs
            priceText = priceText.replaceAll("[^0-9.]", "");

            try {
                double priceValue = Double.valueOf(priceText);
                prices.add(priceValue);
            } catch (NumberFormatException e) {
                // Try catch, just in case
            }
        }
        return prices;
    }

}

