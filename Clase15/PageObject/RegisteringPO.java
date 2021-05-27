package Clase15.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class RegisteringPO {
    public WebDriver driver;

    public RegisteringPO(WebDriver remoteDriver) {
        driver = remoteDriver;
    }

    public void fillInFirstName(String firstName) {
        driver.findElement( By.name( "first_name" ) ).sendKeys( firstName );
    }

    public void fillInLastName(String lastName) {
        driver.findElement( By.name( "last_name" ) ).sendKeys( lastName );
    }

    public void fillInEmail(String email) {
        driver.findElement( By.name( "email" ) ).sendKeys( email );
    }

    public void fillInPhone(String phone) {
        driver.findElement( By.name( "phone" ) ).sendKeys( phone );
    }

    public void fillInJobTitle(String jobTitle) {
        driver.findElement( By.name( "title" ) ).sendKeys( jobTitle );
    }

    public void fillInIndustry(String anIndustry) {
        Select industry = new Select( driver.findElement( By.name( "ds_industry" ) ) );
        industry.selectByValue( anIndustry );
    }

    public List<WebElement> findAllErrors() {
        List<WebElement> listErrors = new ArrayList<WebElement>(  );
        listErrors = driver.findElements( By.className( "invalid" ) );
        return listErrors;
    }
}
