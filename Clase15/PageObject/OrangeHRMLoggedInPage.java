package Clase15.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OrangeHRMLoggedInPage {
    WebDriver driver;
    public OrangeHRMLoggedInPage(WebDriver remoteDriver){
        driver = remoteDriver;
    }
    public List<WebElement> findAllQuickActionButtons(){
        List<WebElement> quickActionsButtons = driver.findElements( By.xpath("//span[@class='quick-access-icon']") );
        return quickActionsButtons;
    }

    public OrangeHRMTimeSheets clickOnTimeSheets() {
        driver.findElement( By.xpath( "//span[contains(text(),'Timesheets to Approve')]" ) ).click();
        OrangeHRMTimeSheets orangeHRMTimeSheets = new OrangeHRMTimeSheets(driver);
        return orangeHRMTimeSheets;
    }
    public WebElement findRandomElement(){
        return driver.findElement( By.xpath( "//img[@src='images/dashboard/icons/appraisals1.png']" ) );
    }
}
