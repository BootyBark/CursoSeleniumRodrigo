import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio14 {
    @Test
    public void netflixTest() {
        //region Settings
        System.setProperty( "webdriver.chrome.driver", "drivers/chromedriver" );
        WebDriver driver = new ChromeDriver();
        //endregion

        //region Accedo a Netflix
        driver.get( "https://www.netflix.com/uy/" );
        //endregion

        //region Listas
        List<WebElement> listaH1 = new ArrayList<WebElement>();
        List<WebElement> listaH2 = new ArrayList<WebElement>();
        List<WebElement> listaDiv = new ArrayList<WebElement>();
        List<WebElement> listaBotones = new ArrayList<WebElement>();
        List<WebElement> listaLinks = new ArrayList<WebElement>();
        //endregion

        // region Mostrar Elementos H1 y H2
        listaH1 = driver.findElements( By.tagName( "h1" ) );
        listaH2 = driver.findElements( By.tagName( "h2" ) );

        for (WebElement e : listaH1) {
            System.out.println( e.getText() );
        }

        for (WebElement e : listaH2) {
            System.out.println( e.getText() );
        }
        //endregion

        //region Refrescar pagina
        driver.navigate().refresh();
        //endregion

        //region Mostrar texto botones
        listaBotones = driver.findElements( By.tagName( "button" ) );
        for (WebElement e : listaBotones) {
            System.out.println( e.getText() );
        }
        //endregion

        //region Mostrar cantidad de divs
        listaDiv = driver.findElements( By.tagName( "div" ) );
        System.out.println( listaDiv.size() );
        //endregion

        //region Mostrar titulo de la pagina
        System.out.println( driver.getTitle() );
        //endregion

        //region Mostrar la cantidad de elementos Link
        listaLinks = driver.findElements( By.tagName( "a" ) );
        System.out.println( listaLinks.size() );
        //endregion

        driver.close();
    }
}
