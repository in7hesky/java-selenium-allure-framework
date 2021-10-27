import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Slider Behavior")
public class SliderTest extends BaseTest {

    @Test
    public void shouldHideNextButtonWhenNoNextArticleAvailable() {
        var sliderPage = app.toSliderPage();

        sliderPage.clickNextArticleButton(8);

        Assertions.assertTrue(sliderPage.nextButtonIsHidden());
    }

    @Test
    @Description("Checks correct switching of the topmost articles slider")
    public void shouldActivateNextArticleAfterClickingNextButton() {
        var sliderPage = app.toSliderPage();

        sliderPage.clickNextArticleButton(1);

        Assertions.assertTrue(sliderPage.articleIsActive(2));
    }

}
