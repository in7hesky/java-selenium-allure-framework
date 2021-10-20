package exercisesapp.pages.exercisespages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import exercisesapp.pages.BasePage;

public class ShiftingContentPage extends BasePage {
    @FindBy(linkText = "Example 1: Menu Element")
    private WebElement menuExampleLink;

    public ShiftingContentPage(WebDriver driver) {
        super(driver);
    }

    public MenuExamplePage chooseMenuExample() {
        menuExampleLink.click();
        return new MenuExamplePage(driver);
    }


}
