import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Execution(ExecutionMode.CONCURRENT)
public class SliderTest extends BaseTest {
    @Test
    public void shouldHideNextButtonWhenNoNextArticleAvailable() {
        var sliderPage = app.sliderPage.openPage();

        sliderPage.clickNextArticleButton(8);

        Assertions.assertTrue(sliderPage.nextButtonIsHidden());
    }

    @Test
    public void shouldActivateNextArticleAfterClickingNextButton() {
        var sliderPage = app.sliderPage.openPage();

        sliderPage.clickNextArticleButton(1);

        Assertions.assertTrue(sliderPage.articleIsActive(2));
    }
}
