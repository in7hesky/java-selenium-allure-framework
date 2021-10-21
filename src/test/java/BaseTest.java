import exercisesapp.ExerciseApp;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BaseTest {
    protected WebDriver driver;
    protected ExerciseApp app;

//    @BeforeClass
//    public void driverSetup()  {
//        WebDriverManager.chromedriver().setup();
//    }
    @Before
    public void initDriver() {
        driver = new ChromeDriver();
        app = new ExerciseApp(driver);
    }

    //@Test

    @After
    public void tearDown() {
        if(this.driver != null)
            driver.quit();
    }
}
