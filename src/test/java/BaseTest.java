import app.App;

import io.github.bonigarcia.wdm.WebDriverManager;

import io.qameta.allure.Attachment;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.TestListener;

@ExtendWith(TestListener.class)
public class BaseTest {
    protected WebDriver driver;
    protected App app;

    @BeforeAll
    public static void driverSetup()  {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void initDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        app = new App(driver);

    }

    //@Test

    @AfterEach
    public void tearDown() {
        if(this.driver != null)
            driver.quit();
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] screenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
