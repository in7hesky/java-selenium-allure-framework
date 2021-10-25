package app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SliderPage extends BasePage {

    public static final String PAGE_URL = "solve/";

    @FindBy(xpath = "(//div[@aria-label='Next slide'])[1]")
    private WebElement nextSliderButton;

    public SliderPage(WebDriver driver) {
        super(driver);
    }

    /**
     * @param articleIndex 1-based
     */
    public boolean articleIsActive(int articleIndex) {
        WebElement articleByIndex = driver.findElement(By.xpath(
                String.format("((//div[@class='swiper-wrapper'])[1]/div)[%d]", articleIndex)
        ));

        return articleByIndex.getAttribute("class").contains("active");
    }

    public SliderPage clickNextArticleButton(int timesToClick) {
        for (int i = 0; i < timesToClick; i++) {
            nextSliderButton.click();
        }
        return this;
    }

    public boolean nextButtonIsHidden() {
        try {
            nextSliderButton.click();
        } catch (ElementNotInteractableException e) {
            return true;
        }
        return false;
    }

    public SliderPage openPage() {
        driver.get(BASE_URL + PAGE_URL);
        wait.until(ExpectedConditions.visibilityOf(nextSliderButton));
        return this;
    }
}
