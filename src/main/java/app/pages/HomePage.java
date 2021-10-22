package app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(id = "trending")
    private WebElement moreStoriesButton;

    @FindBy(css = "#cards > a")
    private List<WebElement> stories;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage loadMoreStories() {
        moreStoriesButton.click();
        return this;
    }

    public int getStoriesAmount() {
        return stories.size();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public HomePage openPage() {
        driver.get(BasePage.BASE_URL);
        return this;
    }
}
