import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Filtering Behavior")
public class FilterTest extends BaseTest{

    @Test
    public void shouldSpawnNewSectionsByClickingOnParentFilter() {
        var filterPage = app.toFilterPage();

        filterPage.clickOnDropdownElemByLabel("Audience", false);

        Assertions.assertTrue(filterPage.filterSectionLabelIsVisible("Educators"));
        Assertions.assertTrue(filterPage.filterSectionLabelIsVisible("Students"));
    }

    @Test
    @Description("Checks if the results of filtering are in [50 - 100] bound since" +
            " actual results number may drastically change in future")
    public void shouldVerifyCorrectFilteringResults() {
        var filterPage = app.toFilterPage();

        filterPage.clickOnDropdownElemByLabel("Subjects", false).
                clickOnDropdownElemByLabel("Careers", false).
                clickOnDropdownElemByLabel("Computer Science", true);
        int resultsAmount = filterPage.getSearchResultsAmount();

        Assertions.assertTrue(resultsAmount >= 50 && resultsAmount <= 100 );
    }
}
