package app;

import app.pages.*;
import org.openqa.selenium.WebDriver;

public class App {

    private WebDriver driver;

    public App(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage toHomePage() {
        return new HomePage(driver).openPage();
    }

    public TopicsPage toTopicsPage() { return new TopicsPage(driver).openPage(); }

    public GalleryPage toGalleryPage() {
        return new GalleryPage(driver).openPage();
    }

    public SliderPage toSliderPage() {
        return new SliderPage(driver).openPage();
    }

    public FilterPage toFilterPage() {
        return new FilterPage(driver).openPage();
    }
}
