package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static Base.BaseTest.driver;

public class SorterDropdownPage {
    public SorterDropdownPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "product_sort_container")
    WebElement sortDropdown;
    public WebElement getSortDropdown() {
        return sortDropdown;
    }

    public void selectAtoZ() {
        Select sorter = new Select(sortDropdown);
        sorter.selectByVisibleText("Name (A to Z)");
    }
    public void selectZtoA() {
        Select sorter = new Select(sortDropdown);
        sorter.selectByVisibleText("Name (Z to A)");
    }
    public void selectHighLow() {
        Select sorter = new Select(sortDropdown);
        sorter.selectByVisibleText("Price (high to low)");
    }
    public void selectLowHi() {
        Select sorter = new Select(sortDropdown);
        sorter.selectByVisibleText("Price (low to high)");
    }

}
