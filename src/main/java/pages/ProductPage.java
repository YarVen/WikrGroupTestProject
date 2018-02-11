package pages;

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

public class ProductPage {

    private WebDriver driver;

    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//h1[@class='detail-title']")
    private WebElement title;

    @FindBy(xpath = "//span[@id='price_label']")
    private WebElement price;

    @FindBy(xpath = "//a[@class='novisited nav-tabs-link'] [position()=1]")
    private WebElement characteristics;

    @FindBy(xpath = "//button[@class='btn-link-i' and @name = 'topurchases']")
    private WebElement buyButton;

    @FindBy(xpath = "//*[@id='tab_content']//tr[3]/td[2]//span/a")
    private WebElement phoneDiagonal;

    @FindBy(xpath = "//*[@id='tab_content']//tr[13]/td[2]")
    private WebElement phoneRAM;

    @FindBy(xpath = "//div[contains(text(),'Вага, г')]//..//..//span")
    private WebElement phoneWeight;

    public ProductPage checkProductParameters(String diagonal, String ram, String weight) throws InterruptedException {
        characteristics.click();
        Thread.sleep(2000);
        Assert.assertEquals(phoneDiagonal.getText(), diagonal);
        Assert.assertEquals(phoneRAM.getText(), ram);
        Assert.assertEquals(phoneWeight.getText(), weight);
        return new ProductPage(driver);
    }

    public BasketPage addProductToBasket(){
        buyButton.click();
        return new BasketPage(driver);
    }

    public void addPriceToReport() throws IOException {
        PropertiesReader pr = new PropertiesReader();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        FileWriter fw = new FileWriter(pr.getProperty("src/main/resources/mainProp.properties", "report"), true);
        String date = LocalDateTime.now().format(formatter);

        fw.write(date + " - " + title.getText() + " - " + price.getText() + "\n");
        fw.flush();
        fw.close();
    }

}
