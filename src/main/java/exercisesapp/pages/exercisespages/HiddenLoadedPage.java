package exercisesapp.pages.exercisespages;

import exercisesapp.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HiddenLoadedPage extends BasePage {

    @FindBy(tagName = "button")
    private WebElement button;

    public HiddenLoadedPage(WebDriver driver) {
        super(driver);
    }

    public boolean buttonIsVisible() {
        try {
            wait.until(ExpectedConditions.visibilityOf(button));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
