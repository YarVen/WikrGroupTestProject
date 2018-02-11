package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.PropertiesReader;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class BasketPage {

    private WebDriver driver;

    public BasketPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//a[@class = 'btn-link-i' and @name = 'close']")
    private WebElement closeButton;

    public MainPage continuePurchase() throws InterruptedException {
        Thread.sleep(5000);
        closeButton.click();
        return new MainPage(driver);
    }

    public BasketPage checkAvailableProducts() {
        ArrayList<WebElement> elements = (ArrayList<WebElement>) driver.findElements(By.xpath("//a[@class = 'novisited cart-i-title-link' and @name = 'goods-link']"));

        Assert.assertEquals(elements.get(0).getText(), "Apple iPhone 7 Plus 32GB Jet Black");
        Assert.assertEquals(elements.get(1).getText(), "Apple iPhone 7 32GB Silver");

        return new BasketPage(driver);
    }

}

