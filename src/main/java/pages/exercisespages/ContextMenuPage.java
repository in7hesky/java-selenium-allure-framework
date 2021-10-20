package pages.exercisespages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class ContextMenuPage extends BasePage {

    private static final String PAGE_URL = "https://the-internet.herokuapp.com/context_menu";

    @FindBy(id = "hot-spot")
    private WebElement targetArea;

    public ContextMenuPage(WebDriver driver) {
        super(driver);
    }

    public String getAlertsText() {
        return driver.switchTo().alert().getText();
    }

    public ContextMenuPage callContextMenuOnTarget() {
        new Actions(driver).contextClick(targetArea).perform();
        return this;
    }

    public ContextMenuPage openPage() {
        driver.get(PAGE_URL);
        return this;
    }


}
