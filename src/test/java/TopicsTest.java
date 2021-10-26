import app.App;
import app.pages.BasePage;
import app.pages.TopicsPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.WebDriver;
import utils.WebDriverFactory;

@Execution(ExecutionMode.CONCURRENT)
public class TopicsTest extends BaseTest {
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
    public void shouldSpawnNewSectionsByClickingOnParentFilter() {
        var filterPage = app.filterPage.openPage();

        filterPage.clickOnDropdownElemByLabel("Audience", false);

        Assertions.assertTrue(filterPage.filterSectionLabelIsVisible("Educators"));
        Assertions.assertTrue(filterPage.filterSectionLabelIsVisible("Students"));
    }

    @Test
    public void shouldVerifyCorrectFilteringResults() {
        var filterPage = app.filterPage.openPage();

        filterPage.clickOnDropdownElemByLabel("Subjects", false).
                clickOnDropdownElemByLabel("Careers", false).
                clickOnDropdownElemByLabel("Computer Science", true);
        int resultsAmount = filterPage.getSearchResultsAmount();

        Assertions.assertTrue(resultsAmount >= 50 && resultsAmount <= 100 );
    }

    @Test
    public void shouldGetToHomePageAfterClickingOnLogo() {
        var topicsPage = app.topicsPage.openPage();

        String currentUrl = topicsPage.clickOnNasaLogo().getCurrentUrl();

        Assertions.assertEquals(BasePage.BASE_URL, currentUrl);
    }


    @Test
    public void shouldVerifyCorrectMenuLettersPointing() {
        var topicsPage = app.topicsPage.openPage();
        char[] menuLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

        for (Character letter: menuLetters) {
            topicsPage.clickOnMenuLetter(letter);

            Assertions.assertEquals((BasePage.BASE_URL + TopicsPage.PAGE_URL + "/#letter-" + letter),
                    topicsPage.getCurrentUrl());
        }

    }

}
