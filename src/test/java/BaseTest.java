import exercisesapp.ExerciseApp;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BaseTest {
    protected WebDriver driver;
    protected ExerciseApp app;

    @BeforeClass
    public void driverSetup()  {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void initDriver() {
        this.driver = new ChromeDriver();
        this.app = new ExerciseApp(driver);
    }

    //@Test

    @AfterMethod
    public void tearDown() {
        if(this.driver != null)
            driver.quit();
    }
}
