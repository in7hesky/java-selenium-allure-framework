package app.pages;

import app.AppConfig;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FilterPage extends BasePage {

    @FindBy(css = ".search-results-summary > h3")
    private WebElement searchResultsAmountHeader;

    public FilterPage(WebDriver driver) {
        super(driver);
    }

    @Step("Checking visibility of filter '{0}' section")
    @Attachment
    public boolean filterSectionLabelIsVisible(String labelName) {

        try {
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(
                    String.format("//label[contains(text(), '%s')]", labelName)))));
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    @Step("Getting search results number")
    @Attachment
    public int getSearchResultsAmount() {
        wait.until(ExpectedConditions.not(
                ExpectedConditions.textToBe(By.cssSelector(".search-results-summary > h3"),"No results")));
        String numberSubstring = searchResultsAmountHeader.getText().split(" ")[0];
        return Integer.parseInt(numberSubstring);
    }


    @Step("Clicking On Filter's '{0}' Dropdown")
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
        driver.get(BASE_URL + AppConfig.FILTER_PAGE_PATH);
        wait.until(ExpectedConditions.visibilityOf(searchResultsAmountHeader));
        return this;
    }
}
