package ExamenFinal;

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

public class InterviewQuestionSiteTest {
    WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        System.setProperty( "webdriver.chrome.driver", "drivers/chromedriver" );
        driver = new ChromeDriver();
        driver.get( "https://allstq.com/most-popular-testng-interview-questions/" );
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait( 5, TimeUnit.SECONDS );
    }

    @Test
    public void landingPageTest() {
        List<WebElement> listaPreguntas;
        List<WebElement> listaElmntsMenu;
        WebElement Selenium = null;
        WebElement Java = null;

        System.out.println( driver.findElement( By.tagName( "h1" ) ).getText() );
        listaPreguntas = driver.findElements( By.xpath( "//h3[contains(text(),'Ques.')]" ) );
        for (int i = 0; i < 5; i++) {
            System.out.println( listaPreguntas.get( i ).getText() );
        }
        Assert.assertEquals( driver.getTitle(),
                "Most popular TestNG interview questions - Software Testing Questions",
                "los Titulos de la página son distintos!" );
        Assert.assertTrue( driver.getCurrentUrl().equals( "https://allstq.com/most-popular-testng-interview-questions/" ),
                "Los URLs son distintos!" );
        listaElmntsMenu = driver.findElements( By.xpath( "//a[@class='menu-link']" ) );

        for (WebElement e : listaElmntsMenu) {
            if ( e.getText().equals( "Selenium" ) ) {
                Selenium = e;
            } else if ( e.getText().equals( "Java" ) ) {
                Java = e;
            }
        }
        Assert.assertTrue( Selenium.isDisplayed(),
                "El elemento 'Selenium' no se encuentra en el menu de esta página" );
        Assert.assertTrue( Java.isDisplayed(),
                "El elemento 'Java' no se encuentra en el menu de esta página" );
    }

    @AfterMethod(alwaysRun = true)
    public void quitDrivers() {
        driver.quit();
    }
}
