package exercisesapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    public static final String BASE_URL = "http://the-internet.herokuapp.com";
    public static final Duration EXPLICIT_WAIT = Duration.ofSeconds(5);

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, EXPLICIT_WAIT);
        PageFactory.initElements(driver, this);
    }
}
