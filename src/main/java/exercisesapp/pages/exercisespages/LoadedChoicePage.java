package exercisesapp.pages.exercisespages;

import exercisesapp.pages.BasePage;
import utils.TabsManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;


public class LoadedChoicePage extends BasePage {
    public static final String PAGE_URL = BASE_URL + "/dynamic_loading";

    @FindBy(xpath = "//a[contains(., '1')]")
    private WebElement hiddenLoadedLink;

    public LoadedChoicePage(WebDriver driver) {
        super(driver);
    }

    public HiddenLoadedPage openHiddenLoadedInNewTab() {
        hiddenLoadedLink.sendKeys(Keys.chord(Keys.LEFT_CONTROL, Keys.ENTER));
        new TabsManager(driver).switchToNextTab();
        return new HiddenLoadedPage(driver);
    }

    public LoadedChoicePage openPage() {
        driver.get(PAGE_URL);
        return this;
    }
}