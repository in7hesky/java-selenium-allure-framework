import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MainPageTest {





    @BeforeTest
    public void driverSetup()  {

        WebDriverManager.firefoxdriver().setup();
    }

    @Test
    public void dummy() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://github.com/bonigarcia/webdrivermanager");
        Assert.assertTrue(true);
    }

    @Test
    public void dummy2()  {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.suvoda.com/services");
        Assert.assertTrue(true);
    }

//    @BeforeMethod
//    public void initDriver() {
//        //WebDriverManager.chromedriver().setup();
//
//        this.driver = new ChromeDriver();
//    }
//
//    @AfterMethod
//    public void tearDown() {
//        if(this.driver != null)
//            driver.quit();
//    }

}
