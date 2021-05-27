package Clase15.TestCases;

import Clase15.PageObject.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.*;

public class Clase15 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public WebDriver setUp() {
        System.setProperty( "webdriver.chrome.driver", "drivers/chromedriver" );
        driver = new ChromeDriver();
        wait = new WebDriverWait( driver, 5000, 100 );
        return driver;
    }

    @Test
    public void docuSignTest() throws InterruptedException {

        DocuSignPO docuSign = new DocuSignPO( driver );
        Thread.sleep( 2000 );
        docuSign.SetUpPage();
        RegisteringPO registeringPO = docuSign.clickFreeTrial();
        registeringPO.fillInFirstName( "Rodrigo" );
        registeringPO.fillInLastName( "Ituarte" );
        registeringPO.fillInEmail( "fererere@a.com" );
        registeringPO.fillInPhone( "8885551234" );
        registeringPO.fillInJobTitle( "Quality Assurance" );
        registeringPO.fillInIndustry( "Accounting" );

        Assert.assertEquals( registeringPO.findAllErrors().size(), 0, "there's at least one error on Screen" );

    }

    @Test
    public void Registrarse() {
        SpotifyLoginPage spotifyLoginPage = new SpotifyLoginPage( driver );
        spotifyLoginPage.SetUpSpanish();
        Assert.assertEquals( spotifyLoginPage.getTitle(), "Escuchar es todo - Spotify", "Los Titulos no coinciden" );
        Assert.assertEquals( spotifyLoginPage.getURL(), "https://www.spotify.com/uy/", "Las URLs no coinciden" );
        SpotifyRegisterPage spotifyRegisterPage = spotifyLoginPage.clickOnRegistrarse();
        Assert.assertEquals( spotifyRegisterPage.getTitle(), "Registrarte - Spotify", "Los Titulos no coinciden" );
        Assert.assertEquals( spotifyRegisterPage.getURL(), "https://www.spotify.com/uy/signup/", "Las URLs no coinciden" );
        wait.until( ExpectedConditions.visibilityOf( spotifyRegisterPage.emailField() ) );
        spotifyRegisterPage.fillInEmail( "@@@.com" + Keys.TAB );
        Assert.assertEquals( spotifyRegisterPage.findEmailError(), "Este correo electrónico no es válido. Asegúrate de que tenga un formato como este: ejemplo@email.com", "Los mensajes de error no coinciden." );
    }

    @Test
    public void Premium() {
        SpotifyLoginPage spotifyLoginPage = new SpotifyLoginPage( driver );
        spotifyLoginPage.SetUpSpanish();
        SpotifyPremiumPage spotifyPremiumPage = spotifyLoginPage.clickOnPremium();
        for (WebElement e : spotifyPremiumPage.returnTitles()) {
            if ( e.getText().equals( "Pásate a Premium gratis por 1 mes" ) ) {
                System.out.println( e.getText() );
                Assert.assertEquals( e.getText(), "Pásate a Premium gratis por 1 mes", "Los titulos no coinciden" );
            } else if ( e.getText().equals( "Beneficios de Premium" ) ) {
                System.out.println( e.getText() );
                Assert.assertEquals( e.getText(), "Beneficios de Premium", "Los titulos no coinciden" );
            }
        }
    }

    @Test
    public void OrangeHRMLogin() throws InterruptedException {
        OrangeHRMLandingPage orangeHRMLandingPage = new OrangeHRMLandingPage( driver );
        orangeHRMLandingPage.setUp();
        OrangeHRMLoggedInPage orangeHRMLoggedInPage = orangeHRMLandingPage.clickOnLogin();
        for (WebElement e : orangeHRMLoggedInPage.findAllQuickActionButtons()) {
            System.out.println( e.getText() );
        }
        Thread.sleep( 10000 );
        Assert.assertEquals( orangeHRMLoggedInPage.findAllQuickActionButtons().size(), 8, "La cantidad de quick action buttons no es correcta" );
        OrangeHRMTimeSheets orangeHRMTimeSheets = orangeHRMLoggedInPage.clickOnTimeSheets();
        Thread.sleep( 10000 );
        Assert.assertEquals( orangeHRMTimeSheets.getTitle(), "Employee Timesheets", "Los titulos no coinciden" );
        Assert.assertEquals( orangeHRMTimeSheets.getURL(), "https://orangehrm-demo-6x.orangehrmlive.com/client/#/time/employee_timesheets", "Las URLs no coinciden" );
        System.out.println( orangeHRMTimeSheets.getAmountOfRows().getText() );
    }

    @AfterMethod
    public void quit() {
        driver.quit();
    }
}
