import io.qameta.allure.Description;
//import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


@DisplayName("Home Page Interactions")
public class HomePageTest extends BaseTest {
    private static final String TARGET_DROPDOWN_NAME = "NASA Audiences";
    private static final String TARGET_OPTION_NAME = "For Media";
    private static final String SEARCH_QUERY = "Careers";
    private static final String SEARCH_TARGET = "Careers at NASA";


    @Test
    public void shouldGetAppropriateSearchResult() {
        var homePage = app.toHomePage();

        var searchResultsPage = homePage.searchFor(SEARCH_QUERY);
        String recommendedResultName = searchResultsPage.getRecommendedName();

        assertThat(recommendedResultName).isEqualToIgnoringCase(SEARCH_TARGET);
    }

    @Test
    public void shouldLoadMoreStoriesAfterButtonClick(){
        var homePage = app.toHomePage();

        int initialStoriesAmount = homePage.getStoriesAmount();
        homePage.loadMoreStories();

        assertThat(initialStoriesAmount).isLessThan(homePage.getStoriesAmount());
    }

    @Test
    @Description("Checks behavior of a dropdown activated by hovering over it")
    public void shouldClickOnDropdownOptionAfterHovering() {
        var homePage = app.toHomePage();

        homePage.hoverMouseOverDropdown(TARGET_DROPDOWN_NAME);

        assertThat(homePage.canClickOnDropdownOption(TARGET_OPTION_NAME)).isTrue();
    }
}
