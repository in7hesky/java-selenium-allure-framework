import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Execution(ExecutionMode.CONCURRENT)
public class FilterTest extends BaseTest {

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
}
