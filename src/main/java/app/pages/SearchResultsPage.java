package app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchResultsPage extends BasePage {

    @FindBy (css = "h4.title:first-child")
    private WebElement recommendedName;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.visibilityOf(recommendedName));
    }

    public String getRecommendedName() {
        return recommendedName.getText();
    }
}
