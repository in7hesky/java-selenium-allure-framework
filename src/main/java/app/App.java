package app;

import app.pages.HomePage;
import app.pages.TopicsPage;
import org.openqa.selenium.WebDriver;

public class App {

    public HomePage homePage;
    public TopicsPage topicsPage;

    public App(WebDriver driver) {
        this.homePage = new HomePage(driver);
        this.topicsPage = new TopicsPage(driver);
    }
}
