package Clase15.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SpotifyRegisterPage {
    WebDriver driver;

    public SpotifyRegisterPage(WebDriver remoteDriver) {
        driver = remoteDriver;
    }
    public String getURL(){
        String url;
        url = driver.getCurrentUrl();
        return url;
    }
    public String getTitle(){
        String title;
        title = driver.getTitle();
        return title;
    }
    public void fillInEmail(String email){
        driver.findElement( By.name("email") ).sendKeys( email );
    }
    public WebElement emailField (){
        return driver.findElement( By.name("email") );
    }
    public String findEmailError(){
        return driver.findElement( By.xpath( "//span[contains(text(),'Este correo')]" ) ).getText();
    }
}
