package Clase15.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SpotifyLoginPage {
    WebDriver driver;

    public SpotifyLoginPage(WebDriver remoteDriver) {
        driver = remoteDriver;
    }
    public void SetUpSpanish(){
        driver.get( "https://www.spotify.com/uy/" );
    }

    public SpotifyRegisterPage clickOnRegistrarse() {
        driver.findElement( By.xpath("//a[contains(text(),'Registrarse')]") ).click();
        SpotifyRegisterPage spotifyRegisterPage = new SpotifyRegisterPage( driver );
        return spotifyRegisterPage;
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
    public SpotifyPremiumPage clickOnPremium() {
        driver.findElement( By.xpath("//a[contains(text(),'Premium')]") ).click();
        SpotifyPremiumPage spotifyPremiumPage = new SpotifyPremiumPage( driver );
        return spotifyPremiumPage;
    }

}
