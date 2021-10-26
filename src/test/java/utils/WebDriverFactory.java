package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverFactory {
    public static final String [] HEADLESS_ARGUMENTS = {
            "--headless",
            "--disable-gpu",
            "--window-size=1920,1200",
            "--ignore-certificate-errors",
            "--disable-extensions",
            "--no-sandbox",
            "--disable-dev-shm-usage"
    };

    public static WebDriver getWebDriver() {
        String browserType = System.getProperty("browser").toLowerCase();
        boolean isHeadless = Boolean.parseBoolean(System.getProperty("headless"));

        if (isHeadless) {
            return buildHeadlessDriver(browserType);
        } else {
            return buildDefaultDriver(browserType);
        }
    }

    private static WebDriver buildDefaultDriver(String browserType) {
        WebDriver driver;
        switch (browserType) {
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "chrome":
            default:
                driver = new ChromeDriver();
                break;
        }
        driver.manage().window().maximize();
        return driver;
    }

    private static WebDriver buildHeadlessDriver(String browserType) {

        switch (browserType) {
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments(HEADLESS_ARGUMENTS);
                return new FirefoxDriver(firefoxOptions);

            case "chrome":
            default:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments(HEADLESS_ARGUMENTS);
                return new ChromeDriver(chromeOptions);
        }
    }

}
