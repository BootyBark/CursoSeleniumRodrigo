package ExamenFinal;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PruebaNetflixTest {
    WebDriver driver;
    Faker faker = new Faker();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        System.setProperty( "webdriver.chrome.driver", "drivers/chromedriver" );
        driver = new ChromeDriver();
        driver.get( "https://www.netflix.com/" );
        driver.manage().timeouts().implicitlyWait( 5, TimeUnit.SECONDS );
    }

    @Test (groups = "TestCases")
    public void iniciarSesionPageTest() {
        String tituloLP;

        tituloLP = driver.getTitle();
        driver.findElement( By.xpath( "//a[@class='authLinks redButton']" ) ).click();

        Assert.assertFalse( tituloLP.equals( driver.getTitle() ),
                "Los titulos son iguales, deberían ser diferentes." );

        Assert.assertTrue( driver.findElement( By.xpath( "//span[@class='fbBtnText']" ) ).isDisplayed(),
                "El texto 'Iniciar sesión con Facebook', no existe en la página." );
    }

    @Test(groups = "TestCases")
    public void fakeEmailTest() throws InterruptedException {
        driver.findElement( By.name( "email" ) ).sendKeys( faker.internet().emailAddress() );
        driver.findElement( By.className( "cta-btn-txt" ) ).click();
        Thread.sleep( 2000 );
        Assert.assertTrue( driver.getCurrentUrl().contains( "signup" ),
                "No nos encontramos en la página de creación de cuentas!" );
    }

    @Test(dataProvider = "emails", dataProviderClass = EmailProvider.class, groups = "TestCases")
    public void dataProviderEmailTest(String email) {
        driver.findElement( By.name( "email" ) ).sendKeys( email );
        driver.findElement( By.className( "cta-btn-txt" ) ).click();
    }

    /*
    Este Ultimo test no es parte de los grupos del archivo "testNG", sin embargo
    si lo agregamos deberiamos hacerlo con un DataProvider o alguna forma de
    darle al usuario la chance de enviarle el tagName por parámetro.
     */
    @Test
    public void printTagsTest (String tagName){
        List<WebElement> listaElementos;
        listaElementos = driver.findElements( By.tagName( tagName ) );
        for(WebElement e: listaElementos){
            System.out.println( e.getText() );
        }
    }

    @AfterMethod(alwaysRun = true)
    public void quitDrivers() {
        driver.quit();
    }
}
