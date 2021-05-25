package Clase15.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DocuSignPO {
    WebDriver driver;

    public DocuSignPO(WebDriver remoteDriver) {
        driver = remoteDriver;
    }

    public RegisteringPO clickFreeTrial() {
        driver.findElement( By.xpath( "//a[@class='button header-cta  header-trial']" ) ).click();
        RegisteringPO registeringPO = new RegisteringPO( driver );
        return registeringPO;
    }

    public void SetUpPage() {
        driver.get( "https://www.docusign.com/" );
    }
}
