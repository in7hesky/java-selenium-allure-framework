import app.App;

import io.github.bonigarcia.wdm.WebDriverManager;

import io.qameta.allure.Attachment;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import utils.TestListener;


@ExtendWith(TestListener.class)
@Execution(ExecutionMode.CONCURRENT)
public class BaseTest {

    protected App app;

    @BeforeAll
    public static void driverSetup()  {
        WebDriverManager.chromedriver().setup();
    }

//    @BeforeEach
//    public void initDriver() {
//        driver.set(WebDriverFactory.getWebDriver());
//        getDriver().manage().window().maximize();
//        app = new App(getDriver());
//
//    }
}
