import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Execution(ExecutionMode.CONCURRENT)
public class HomePageTest extends BaseTest {
    @Test
    public void shouldLoadMoreStoriesAfterButtonClick(){
        var homePage = app.homePage.openPage();

        int initialStoriesAmount = homePage.getStoriesAmount();
        homePage.loadMoreStories();

        Assertions.assertTrue(initialStoriesAmount < homePage.getStoriesAmount());
    }
}
