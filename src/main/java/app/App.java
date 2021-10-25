package app;

import app.pages.*;
import org.openqa.selenium.WebDriver;

public class App {

    public final FilterPage filterPage;
    public final  HomePage homePage;
    public final TopicsPage topicsPage;
    public final GalleryPage galleryPage;
    public final SliderPage sliderPage;


    public App(WebDriver driver) {
        this.homePage = new HomePage(driver);
        this.topicsPage = new TopicsPage(driver);
        this.galleryPage = new GalleryPage(driver);
        this.sliderPage = new SliderPage(driver);
        this.filterPage = new FilterPage(driver);
    }
}
