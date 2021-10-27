package app.pages;

import app.AppConfig;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.NoSuchElementException;

public class GalleryPage extends BasePage {

    @FindBy (id = "trending")
    private WebElement moreImagesButton;

    @FindBy (css = "div.image")
    private List<WebElement> loadedImages;

    @FindBy (css = "img.img-responsive")
    private WebElement imageInFullSize;

    public GalleryPage(WebDriver driver) {
        super(driver);
    }

    @Step("Checking visibility of full-size image")
    public boolean fullSizeViewModeIsOn() {
        try {
            wait.until(ExpectedConditions.visibilityOf(imageInFullSize));
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    @Step("Clicking on image [{0}] to view in full-size")
    public GalleryPage clickOnImageForFullSizeView(int imageIndex) {
        loadedImages.get(imageIndex).click();
        return this;
    }

    @Step("Getting current loaded images number")
    @Attachment
    public int getCurrentImagesAmount() {
        return loadedImages.size();
    }

    @Step("Getting more images by clicking on button")
    public GalleryPage clickMoreImagesButton() {
        int imagesAmountBeforeLastLoading = getCurrentImagesAmount();
        moreImagesButton.click();
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(
                By.cssSelector("div.image"), imagesAmountBeforeLastLoading));
        return this;
    }

    public GalleryPage openPage() {
        driver.get(BASE_URL + AppConfig.GALLERY_PAGE_PATH);
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("div.image"), 24));
        return this;
    }

}
