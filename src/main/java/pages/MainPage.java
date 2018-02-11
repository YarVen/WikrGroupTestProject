package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    private static String URL_MATCH = "https://rozetka.com.ua";

    private WebDriver driver;

    @FindBy(xpath = "//input[@class='rz-header-search-input-text passive']")
    private WebElement searchField;

    @FindBy(xpath = "//button[@class = 'btn-link-i js-rz-search-button']")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@class='g-i-tile g-i-tile-catalog'][position()=1]")
    private WebElement firstSearchItem;

    public MainPage(WebDriver driver) {
        if (!driver.getCurrentUrl().contains(URL_MATCH)) {
            throw new IllegalStateException(
                    "This is not the page you are expected"
            );
        }
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public ProductPage searchProduct(String productModel) {
        searchField.sendKeys(productModel);
        searchButton.isDisplayed();
        searchButton.click();
        firstSearchItem.click();
        return new ProductPage(driver);
    }

}
