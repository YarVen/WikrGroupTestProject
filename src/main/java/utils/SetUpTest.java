package utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.BasketPage;
import pages.MainPage;
import pages.ProductPage;

import java.io.IOException;

public class SetUpTest {

    public MainPage mainPage;
    public ProductPage productPage;
    public BasketPage basketPage;

    public WebDriver driver;
    DriverManager drM = new DriverManager();

    @BeforeClass
    public void setUp() throws IOException {
        driver = drM.setUpDriver();
        mainPage = new MainPage(driver);
        productPage = new ProductPage(driver);
        basketPage = new BasketPage(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
