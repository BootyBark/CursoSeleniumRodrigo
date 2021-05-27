package Clase15.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrangeHRMLandingPage {
    WebDriver driver;

    public OrangeHRMLandingPage(WebDriver remoteDriver) {
        driver = remoteDriver;
    }
    public void setUp(){
        driver.get("https://orangehrm-demo-6x.orangehrmlive.com/");
    }

    public OrangeHRMLoggedInPage clickOnLogin() {
        driver.findElement( By.name( "Submit" ) ).click();
        OrangeHRMLoggedInPage orangeHRMLoggedInPage = new OrangeHRMLoggedInPage( driver );
        return orangeHRMLoggedInPage;
    }
}
