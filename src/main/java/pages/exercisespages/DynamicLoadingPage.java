package pages.exercisespages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

public class DynamicLoadingPage extends BasePage {
    public static final String PAGE_URL = "https://the-internet.herokuapp.com/dynamic_loading/2";

    @FindBy(css = "div button")
    private WebElement startButton;

    @FindBy(css = "#finish h4")
    private WebElement textContainer;

    public DynamicLoadingPage(WebDriver driver) {
        super(driver);
    }

    public DynamicLoadingPage clickToLoadContent() {
        startButton.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(textContainer));
        return this;
    }

    public String getLoadedText() {
        return textContainer.getText();
    }

    public DynamicLoadingPage openPage() {
        driver.get(PAGE_URL);
        return this;
    }
}
