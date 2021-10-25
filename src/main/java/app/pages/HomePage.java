package app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(id = "trending")
    private WebElement moreStoriesButton;

    @FindBy(xpath = "//input[@name='query']")
    private WebElement searchField;

    @FindBy(css = "#cards > a")
    private List<WebElement> stories;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public SearchResultsPage searchFor(String searchQuery) {
        searchField.sendKeys(searchQuery);
        searchField.submit();
        return new SearchResultsPage(driver);
    }

    public boolean canClickOnDropdownOption(String optionName) {
        try {
            driver.findElement(By.xpath(
                    String.format("//li//a[contains(., '%s')]", optionName))).click();
        } catch (ElementNotInteractableException e) {
            return false;
        }
      return true;
    }

    public HomePage hoverMouseOverDropdown(String dropdownName) {
        WebElement targetDropdown = driver.findElement(By.xpath(
                String.format("//li[contains(., '%s')]", dropdownName)));

        new Actions(driver).moveToElement(targetDropdown).perform();

        return this;

    }

    public HomePage loadMoreStories() {
        moreStoriesButton.click();
        return this;
    }

    public int getStoriesAmount() {
        return stories.size();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public HomePage openPage() {
        driver.get(BasePage.BASE_URL);
        return this;
    }
}
