package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DriverManager {

    public WebDriver driver;
    public WebDriverWait wait;
    String url;

    public WebDriver setUpDriver() throws IOException {
        PropertiesReader pr = new PropertiesReader();

        if(System.getProperty("url") != null) {
            url = System.getProperty("url");
        } else {
            url = pr.getProperty("src/main/resources/mainProp.properties", "url");
        }

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
        //driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(url);
        return driver;
    }


}
