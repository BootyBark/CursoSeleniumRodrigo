package Clase15.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SpotifyPremiumPage {
    WebDriver driver;
    public SpotifyPremiumPage (WebDriver remoteDriver){
        driver = remoteDriver;
    }
    public List<WebElement> returnTitles(){
        List<WebElement> listTitles = new ArrayList<WebElement>(  );
        listTitles = driver.findElements( By.tagName("h1") );
        return listTitles;
    }
}
