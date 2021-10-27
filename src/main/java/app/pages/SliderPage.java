package app.pages;

import app.AppConfig;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SliderPage extends BasePage {

    @FindBy(xpath = "(//div[@aria-label='Next slide'])[1]")
    private WebElement nextSliderButton;

    public SliderPage(WebDriver driver) {
        super(driver);
    }

    /**
     * @param articleIndex 1-based
     */
    @Step("Checking if article [{0}] (1-based index) contains 'active' in attributes")
    public boolean articleIsActive(int articleIndex) {
        WebElement articleByIndex = driver.findElement(By.xpath(
                String.format("((//div[@class='swiper-wrapper'])[1]/div)[%d]", articleIndex)
        ));

        return articleByIndex.getAttribute("class").contains("active");
    }

    @Step("Switching to the next slider article")
    public SliderPage clickNextArticleButton(int timesToClick) {
        for (int i = 0; i < timesToClick; i++) {
            nextSliderButton.click();
        }
        return this;
    }

    @Step("Checking if the next button is hidden")
    public boolean nextButtonIsHidden() {
        try {
            nextSliderButton.click();
        } catch (ElementNotInteractableException e) {
            return true;
        }
        return false;
    }

    public SliderPage openPage() {
        driver.get(BASE_URL + AppConfig.SLIDER_PAGE_PATH);
        wait.until(ExpectedConditions.visibilityOf(nextSliderButton));
        return this;
    }
}
