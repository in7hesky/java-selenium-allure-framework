package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {
    private static TestConfigFactory config = TestConfigFactory.getInstance();

    public static WebDriver getWebDriver() {
//        switch (config.getWebConfig().getBrowser()) {
//            case FIREFOX:
//                return new FirefoxDriver();
//            case CHROME:
//            default:
//                return new ChromeDriver();
//        }
        return new ChromeDriver();
    }

    public enum Browser {
        CHROME, FIREFOX
    }

}
