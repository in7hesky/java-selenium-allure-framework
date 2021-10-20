import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class BaseTest {
    protected WebDriver driver;
    @BeforeTest
    public void driverSetup()  {

        //WebDriverManager.firefoxdriver().setup();

    }

    @BeforeMethod
    public void initDriver() {
        WebDriverManager.chromedriver().setup();

        this.driver = new ChromeDriver();
    }

    //@Test

    @AfterMethod
    public void tearDown() {
        if(this.driver != null)
            driver.quit();
    }
}
