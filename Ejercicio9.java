import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;

public class Ejercicio9 {
    @Test
    public static void fullRegistrationTest() {
        System.setProperty( "webdriver.chrome.driver", "drivers/chromedriver" );
        WebDriver driver = new ChromeDriver();
        driver.get( "https://www.facebook.com/" );
        WebDriverWait wait = new WebDriverWait( driver, 2, 100 );
        List<WebElement> listaSexo;

        driver.findElement( By.linkText( "Español" ) ).click();
        wait.until( ExpectedConditions.visibilityOfElementLocated( By.linkText( "Crear cuenta nueva" ) ) );
        driver.findElement( By.linkText( "Crear cuenta nueva" ) ).click();

        wait.until( ExpectedConditions.visibilityOfElementLocated( By.name( "firstname" ) ) );
        driver.findElement( By.name( "firstname" ) ).sendKeys( "John" );
        driver.findElement( By.name( "lastname" ) ).sendKeys( "Smith" );
        driver.findElement( By.name( "reg_email__" ) ).sendKeys( "5555555" );
        driver.findElement( By.name( "reg_passwd__" ) ).sendKeys( "123456789" );

        Select month = new Select( driver.findElement( By.id( "month" ) ) );
        Select day = new Select( driver.findElement( By.id( "day" ) ) );
        Select year = new Select( driver.findElement( By.id( "year" ) ) );

        month.selectByValue( "6" );
        day.selectByValue( "26" );
        year.selectByValue( "1980" );

        listaSexo = driver.findElements( By.name( "sex" ) );

        for (WebElement e : listaSexo) {
            System.out.println( e.getText() );
        }
        listaSexo.get( 1 ).click();

        driver.close();
    }
}
