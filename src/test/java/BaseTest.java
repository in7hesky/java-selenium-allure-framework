import exercisesapp.ExerciseApp;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BaseTest {
    protected WebDriver driver;
    protected ExerciseApp app;

    @BeforeAll
    public static void driverSetup()  {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    public void initDriver() {
        driver = new ChromeDriver();
        app = new ExerciseApp(driver);
    }

    //@Test

    @AfterEach
    public void tearDown() {
        if(this.driver != null)
            driver.quit();
    }
}
