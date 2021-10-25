package app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.NoSuchElementException;

public class GalleryPage extends BasePage {

    public static final String PAGE_URL = "multimedia/imagegallery/iotd.html";
    
    @FindBy (id = "trending")
    private WebElement moreImagesButton;

    @FindBy (css = "div.image")
    private List<WebElement> loadedImages;

    @FindBy (css = "img.img-responsive")
    private WebElement imageInFullSize;


    public boolean fullSizeViewModeIsOn() {
        try {
            wait.until(ExpectedConditions.visibilityOf(imageInFullSize));
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    public GalleryPage clickOnImageForFullSizeView(int imageIndex) {
        loadedImages.get(imageIndex).click();
        return this;
    }


    public GalleryPage(WebDriver driver) {
        super(driver);
    }

    public GalleryPage openPage() {
        driver.get(BASE_URL + PAGE_URL);
        wait.until(ExpectedConditions.visibilityOf(loadedImages.get(0)));
        return this;
    }

    public int getCurrentImagesAmount() {
        return loadedImages.size();
    }

    public GalleryPage clickMoreImagesButton() {
        int imagesAmountBeforeLastLoading = getCurrentImagesAmount();
        moreImagesButton.click();
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(
                By.cssSelector("div.image"), imagesAmountBeforeLastLoading));
        return this;
    }
}
