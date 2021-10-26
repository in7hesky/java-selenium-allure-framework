import app.App;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;


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
        String browserType = System.getProperty("browser");

        switch (browserType) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
            case "chrome":
            default:
                WebDriverManager.chromedriver().setup();
        }


    }

}
