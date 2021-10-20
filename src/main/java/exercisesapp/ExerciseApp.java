package exercisesapp;

import exercisesapp.pages.exercisespages.*;
import org.openqa.selenium.WebDriver;

public class ExerciseApp {
    public HomePage homePage;
    public SliderPage sliderPage;
    public ContextMenuPage contextMenuPage;
    public NestedFramesPage nestedFramesPage;
    public DynamicLoadingPage dynamicLoadingPage;


    public ExerciseApp(WebDriver driver) {
        this.homePage = new HomePage(driver);
        this.sliderPage = new SliderPage(driver);
        this.contextMenuPage = new ContextMenuPage(driver);
        this.nestedFramesPage = new NestedFramesPage(driver);
        this.dynamicLoadingPage = new DynamicLoadingPage(driver);
    }
}
