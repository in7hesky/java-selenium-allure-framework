import app.App;
import io.qameta.allure.Flaky;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.WebDriver;
import utils.WebDriverFactory;

@Execution(ExecutionMode.CONCURRENT)
public class SliderTest extends BaseTest {
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

    @Test
    @Flaky
    public void shouldToggleFullSizeImageView() {
        var galleryPage = app.galleryPage.openPage();

        galleryPage.clickOnImageForFullSizeView(0);

        Assertions.assertTrue(galleryPage.fullSizeViewModeIsOn());
    }

    @Test
    public void shouldLoadEqualToInitialAmountOfNewImages() {
        var galleryPage = app.galleryPage.openPage();

        int imagesInitialAmount = galleryPage.getCurrentImagesAmount();
        galleryPage.clickMoreImagesButton();

        Assertions.assertEquals(imagesInitialAmount * 2, galleryPage.getCurrentImagesAmount());
    }
}
