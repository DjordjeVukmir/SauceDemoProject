package Base;

import BurgerMenu_SideBar.BurgerMenuPage;
import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
    public WebDriverWait wait;

    public MainPage mainPage;
    public InventoryPage inventoryPage;
    public CartPage cartPage;
    public BurgerMenuPage burgerMenuPage;
    public CheckoutPageOne checkoutPageOne;
    public CheckoutPageTwo checkoutPageTwo;
    public CheckoutComplete checkoutComplete;
    public String standardUsername = "standard_user";
    public String problemUsername = "problem_user";
    public String lockedOutUsername = "locked_out_user";
    public String performanceGlitchUsername = "performance_glitch_user";
    public String password = "secret_sauce";
    public ExcelReader excelReader;
    public ExcelReader excelReaderInvalid;

    public String getStandardUsername() {
        return standardUsername;
    }


    public String getProblemUsername() {
        return problemUsername;
    }

    public String getLockedOutUsername() {
        return lockedOutUsername;
    }

    public String getPerformanceGlitchUsername() {
        return performanceGlitchUsername;
    }


    public String getUsername() {
        return standardUsername;
    }

    public String getPassword() {
        return password;
    }

    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        mainPage = new MainPage();
        inventoryPage = new InventoryPage();
        cartPage = new CartPage();
        burgerMenuPage = new BurgerMenuPage();
        checkoutPageOne = new CheckoutPageOne();
        checkoutPageTwo = new CheckoutPageTwo();
        excelReader = new ExcelReader("src\\test\\java\\loginDataSauce.xlsx");
        excelReaderInvalid = new ExcelReader("src\\test\\java\\invalidDataSauce.xlsx");
        checkoutComplete = new CheckoutComplete();

    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException, InterruptedException {
        if (result.getStatus() == ITestResult.FAILURE || result.getStatus() == ITestResult.SKIP) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File savedScreenshot = new File("target/screenshots/" + System.currentTimeMillis() + ".jpg");
            FileUtils.copyFile(screenshot, savedScreenshot);
        }
    }
    @AfterClass
    public void driverQuit() throws InterruptedException {
        //Thread.sleep(2000);
        //driver.quit();
    }
}
