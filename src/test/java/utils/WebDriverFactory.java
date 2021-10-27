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

    public static final String BROWSER_TYPE =
            System.getProperty("browser") == null ? "chrome" : System.getProperty("browser");

    public static final boolean IS_HEADLESS = System.getProperty("headless") != null &&
            Boolean.parseBoolean(System.getProperty("headless"));

    public static WebDriver getWebDriver() {
        if (IS_HEADLESS) {
            return buildDriver(HEADLESS_ARGUMENTS);
        }
        return buildDriver(DEFAULT_ARGUMENTS);
    }

    private static WebDriver buildDriver(String [] optionsArguments) {

        switch (BROWSER_TYPE) {
            case "firefox":
                return new FirefoxDriver(new FirefoxOptions().addArguments(optionsArguments));

            case "chrome":
            default:
                return new ChromeDriver(new ChromeOptions().addArguments(optionsArguments));
        }

    }

}
