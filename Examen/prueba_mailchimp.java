package Examen;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class prueba_mailchimp {
    WebDriver driver;
    Faker faker = new Faker();
    int numero;

    public prueba_mailchimp(int unNumero) {
        this.numero = unNumero;
    }

    public prueba_mailchimp() {
        this.numero = 0;
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws InterruptedException {
        System.setProperty( "webdriver.chrome.driver", "drivers/chromedriver" );
        driver = new ChromeDriver();
        driver.get( "https://login.mailchimp.com/" );
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait( 2, TimeUnit.SECONDS );
        driver.findElement( By.id( "onetrust-pc-btn-handler" ) ).click();
        driver.findElement( By.id( "accept-recommended-btn-handler" ) ).click();
        Thread.sleep( 2000 );
    }

    @Test(groups = {"allTests"}, priority = 0)
    public void validarTituloTest() {
        Assert.assertEquals( driver.getTitle(),
                "Login | Mailchimp",
                "Los titulos no coinciden." );
    }

    @Test(groups = {"allTests"}, priority = 1)
    public void iniciarSesionPageTest() {
        Assert.assertEquals( driver.findElement( By.tagName( "h1" ) ).getText(),
                "Log In",
                "El texto 'log in' no existe en esta página" );

        Assert.assertEquals( driver.findElement( By.xpath( "//span[contains(text(),'Need a Mailchimp account?')]" ) ).getText(),
                "Need a Mailchimp account?",
                "El texto 'Need a Mailchimp account?' no existe en esta página" );
    }

    @Test(groups = {"allTests"}, priority = 2)
    public void loginErrorTest() {
        driver.findElement( By.name( "username" ) ).sendKeys( "XXXXX@gmail.com" );
        driver.findElement( By.xpath( "//button[contains(text(),'Log in')]" ) ).click();

        Assert.assertTrue( driver.findElement( By.xpath( "//p[contains(text(),'Looks like you forgot your password there')]" ) ).isDisplayed(),
                "El texto no se muestra en la pantalla." );

        Assert.assertFalse( driver.findElement( By.name( "stay-signed-in" ) ).isSelected(),
                "El checkbox esta seleccionado..." );
    }

    @Test(groups = {"allTests"}, priority = 3)
    public void fakeEmailTest() {
        driver.findElement( By.xpath( "//a[contains(text(),' Create an account ')]" ) ).click();
        driver.findElement( By.name( "email" ) ).sendKeys( faker.internet().emailAddress() );
        Assert.assertTrue( driver.getCurrentUrl().contains( "signup" ),
                "La URL no contiene la palabra signup" );

    }

    @Test(dataProvider = "EmailProvider", dataProviderClass = Mailchimp_Data.class, priority = 4)
    public void dataProviderEmailTest(String email, String password) throws InterruptedException {
        driver.findElement( By.name( "username" ) ).sendKeys( email );
        driver.findElement( By.name( "password" ) ).sendKeys( password );
        driver.findElement( By.xpath( "//button[contains(text(),'Log in')]" ) ).click();
        Thread.sleep( 2000 );
        Assert.assertTrue( driver.findElement( By.xpath( "//p[contains(text(),'Can we help you recover your')]" ) ).isDisplayed(),
                "El texto que se quiere buscar no se encuentra en la pagina." );
        Assert.assertTrue( driver.findElement( By.xpath( "//a[contains(text(),'username')]" ) ).isDisplayed(),
                "El texto que se quiere buscar no se enuentra en la pagina." );
    }

    @AfterMethod(alwaysRun = true)
    public void quit() {
        driver.quit();
    }
}
