package app.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FilterPage extends BasePage {
    public static final String PAGE_URL = "education/materials/";

    @FindBy(css = ".search-results-summary > h3")
    private WebElement searchResultsAmountHeader;

    public FilterPage(WebDriver driver) {
        super(driver);
    }

    public boolean filterSectionLabelIsVisible(String labelName) {

        try {
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(
                    String.format("//label[contains(text(), '%s')]", labelName)))));
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    public int getSearchResultsAmount() {
        wait.until(ExpectedConditions.not(
                ExpectedConditions.textToBe(By.cssSelector(".search-results-summary > h3"),"No results")));
        String numberSubstring = searchResultsAmountHeader.getText().split(" ")[0];
        return Integer.parseInt(numberSubstring);
    }



    public FilterPage clickOnDropdownElemByLabel(String labelName, boolean isCheckbox) {
        String locator = "//label[contains(text(), '%s')]/preceding-sibling::";
        if (isCheckbox) {
            locator += "input";
        } else {
            locator += "button";
        }

        driver.findElement(By.xpath(
                String.format(locator, labelName))).click();
        return this;
    }

    public FilterPage openPage() {
        driver.get(BASE_URL + PAGE_URL);
        wait.until(ExpectedConditions.visibilityOf(searchResultsAmountHeader));
        return this;
    }
}
