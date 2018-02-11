package tests;

import org.testng.annotations.Test;
import utils.SetUpTest;

import java.io.IOException;

public class PhonesTestClass extends SetUpTest {

    @Test (priority=1)
    public void phonesParametersTest() throws InterruptedException {
        mainPage.searchProduct("Apple iPhone 7 Plus")
                .checkProductParameters("5.5", "3 ГБ", "188");
        mainPage.searchProduct("Apple iPhone 7 32GB")
                .checkProductParameters("4.7", "2 ГБ", "138");
    }

    @Test (priority=2)
    public void addCurrentPricesToReportTest() throws IOException {
        mainPage.searchProduct("Apple iPhone 7 32GB")
                .addPriceToReport();
        mainPage.searchProduct("Apple iPhone 7 Plus 32GB")
                .addPriceToReport();
    }

    @Test (priority=3)
    public void addPhonesToBasketTest() throws InterruptedException {
        mainPage.searchProduct("Apple iPhone 7 32GB")
                .addProductToBasket()
                .continuePurchase()
                .searchProduct("Apple iPhone 7 Plus")
                .addProductToBasket()
                .checkAvailableProducts();
    }

}
