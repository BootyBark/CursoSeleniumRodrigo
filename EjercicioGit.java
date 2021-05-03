import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EjercicioGit {
    private static final String SALESFORCE_URL = "https://login.salesforce.com/";
    private static final String ERROR_MESSAGE = "Your access to salesforce.com has been disabled by your system administrator. Please contact your Administrator for more information.";
    WebDriver driver;

    @BeforeMethod
    public void setUpSalesforceDriver() {
        System.setProperty( "webdriver.chrome.driver", "drivers/chromedriver" );
        driver = new ChromeDriver();
        driver.get( SALESFORCE_URL );
    }
    @Test(priority = 3)
    public void LoginFailureTest() {
        Assert.assertTrue( driver.findElement( By.xpath( "//img[@alt='Salesforce']" ) ).isDisplayed() );
        driver.findElement( By.xpath( "//input[@type='email']" ) ).sendKeys( "test@test.com" );
        driver.findElement( By.xpath( "//input[@type='password']" ) ).sendKeys( "123466" );
        driver.findElement( By.xpath( "//input[@name='Login']" ) ).click();

        Assert.assertTrue( driver.findElement( By.xpath( "//div[@id='error']" ) ).getText().equals( ERROR_MESSAGE ) );

    }

    @AfterMethod
    public void quitDriver() {
        driver.quit();
    }
}
