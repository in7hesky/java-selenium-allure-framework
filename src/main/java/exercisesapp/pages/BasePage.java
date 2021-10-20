package exercisesapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    public static final String BASE_URL = "http://the-internet.herokuapp.com";
    public static final int EXPLICIT_WAIT = 10;

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, EXPLICIT_WAIT);
        PageFactory.initElements(driver, this);
    }
}
