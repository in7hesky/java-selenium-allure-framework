package app.pages;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
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
    @Step("Getting recommended result's header")
    @Attachment
    public String getRecommendedName() {
        return recommendedName.getText();
    }
}
