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
            "--window-size=1920,1080",
            "--ignore-certificate-errors",
            "--disable-extensions",
            "--no-sandbox",
            "--disable-dev-shm-usage"
    };

    public static final String [] DEFAULT_ARGUMENTS = {
            "--window-size=1920,1080",
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

        switch (browserType) {
            case "firefox":
                return new FirefoxDriver(new FirefoxOptions().addArguments(DEFAULT_ARGUMENTS));

            case "chrome":
            default:
                return new ChromeDriver(new ChromeOptions().addArguments(DEFAULT_ARGUMENTS));
        }

    }

    private static WebDriver buildHeadlessDriver(String browserType) {

        switch (browserType) {
            case "firefox":
                return new FirefoxDriver(new FirefoxOptions().addArguments(HEADLESS_ARGUMENTS));

            case "chrome":
            default:
                return new ChromeDriver(new ChromeOptions().addArguments(HEADLESS_ARGUMENTS));
        }
    }

}
