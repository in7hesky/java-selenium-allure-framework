import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Execution(ExecutionMode.CONCURRENT)
public class GalleryTest extends BaseTest {

    @Test
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
