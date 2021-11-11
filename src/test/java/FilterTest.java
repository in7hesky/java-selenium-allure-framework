import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Filtering Behavior")
public class FilterTest extends BaseTest{

    @Test
    public void shouldSpawnNewSectionsByClickingOnParentFilter() {
        var filterPage = app.toFilterPage();

        filterPage.clickOnDropdownElemByLabel("Audience", false);

        assertThat(filterPage.filterSectionLabelIsVisible("Educators")).isTrue();
        assertThat(filterPage.filterSectionLabelIsVisible("Students")).isTrue();
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

        assertThat(resultsAmount).isBetween(50, 100);
    }
}
