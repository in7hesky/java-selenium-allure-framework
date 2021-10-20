package exercisesapp.pages.exercisespages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import exercisesapp.pages.BasePage;

import java.util.List;

public class MenuExamplePage extends BasePage {

    @FindBy (tagName = "li")
    private List<WebElement> options;

    public MenuExamplePage(WebDriver driver) {
        super(driver);
    }

    public int getOptionsAmount() {
        return options.size();
    }


}
