import app.App;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import utils.WebDriverFactory;

@DisplayName("Critical Path Suite")
public class HomePageTest extends BaseTest {
    private static final String TARGET_DROPDOWN_NAME = "NASA Audiences";
    private static final String TARGET_OPTION_NAME = "For Media";
    private static final String SEARCH_QUERY = "Careers";
    private static final String SEARCH_TARGET = "Careers at NASA";
    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @BeforeEach
    public void initDriver() {
        driver.set(WebDriverFactory.getWebDriver());

        app = new App(getDriver());
    }

    protected  WebDriver getDriver() {
        return driver.get();
    }

    @Test
    public void shouldGetAppropriateSearchResult() {
        var homePage = app.homePage.openPage();

        var searchResultsPage = homePage.searchFor(SEARCH_QUERY);
        String recommendedResultName = searchResultsPage.getRecommendedName();

        Assertions.assertTrue(recommendedResultName.equalsIgnoreCase(SEARCH_TARGET));
    }

    @Test
    public void shouldLoadMoreStoriesAfterButtonClick(){
        var homePage = app.homePage.openPage();

        int initialStoriesAmount = homePage.getStoriesAmount();
        homePage.loadMoreStories();

        Assertions.assertTrue(initialStoriesAmount < homePage.getStoriesAmount());
    }

    @Test
    public void shouldClickOnDropdownOptionAfterHovering() {
        var homePage = app.homePage.openPage();

        homePage.hoverMouseOverDropdown(TARGET_DROPDOWN_NAME);

        Assertions.assertTrue(homePage.canClickOnDropdownOption(TARGET_OPTION_NAME));
    }
}
