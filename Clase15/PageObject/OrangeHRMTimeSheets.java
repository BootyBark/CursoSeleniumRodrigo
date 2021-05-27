package Clase15.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeHRMTimeSheets {
    WebDriver driver;

    public OrangeHRMTimeSheets(WebDriver remoteDriver) {
        driver = remoteDriver;
    }

    public String getURL() {
        String url;
        url = driver.getCurrentUrl();
        return url;
    }

    public String getTitle() {
        String title;
        title = driver.getTitle();
        return title;
    }
    public WebElement getAmountOfRows(){
        return driver.findElement( By.xpath("//li[@class='summary']") );
    }
}
