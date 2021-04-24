import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SpotifyWithCssSelectorTest {
    public static WebDriver getDriver() {
        System.setProperty( "webdriver.chrome.driver", "drivers/chromedriver" );
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    @Test
    public static void spotifyByPlaceHolderTest() {
        WebDriver driver = getDriver();
        driver.get( "https://www.spotify.com/uy/signup/" );
        driver.findElement( By.cssSelector( "input[placeholder='Introduce tu correo electrónico.']" ) ).sendKeys( "1234@hotmail.com" );
        driver.findElement( By.cssSelector( "input[placeholder='Vuelve a introducir tu correo electrónico.']" ) ).sendKeys( "1234@hotmail.com" );
        driver.findElement( By.cssSelector( "input[placeholder='Crea una contraseña.']" ) ).sendKeys( "12345678" );
        driver.findElement( By.cssSelector( "input[placeholder='Introduce un nombre de perfil.']" ) ).sendKeys( "Rodrigo" );
        driver.findElement( By.cssSelector( "input[placeholder='DD']" ) ).sendKeys( "10" );
        driver.findElement( By.cssSelector( "input[placeholder='AAAA']" ) ).sendKeys( "1995" );

        //No pude encontrar placeholder para el elemento "Month", lo hice por su nombre.
        WebElement month = driver.findElement( By.cssSelector( "select[name='month']" ) );

        Select selectMonth = new Select( month );
        selectMonth.selectByValue( "07" );

        driver.close();
    }
}
