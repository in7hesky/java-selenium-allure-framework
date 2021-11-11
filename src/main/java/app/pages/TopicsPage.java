package app.pages;

import app.AppConfig;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TopicsPage extends BasePage {

    public static final String PAGE_URL = BASE_URL + AppConfig.TOPICS_PAGE_PATH;

    @FindBy(xpath = "(//a[@title='Home Page'])[1]")
    private WebElement topLeftLogo;

    public TopicsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Clicking on the menu section button {0}")
    public void clickOnMenuLetter(Character letter) {
        WebElement menuLetter = driver.findElement(By.xpath(String.format(
                "//div[@id='tag-anchors']//a[contains(., '%c')]", letter)));
        menuLetter.click();
    }

    @Step("Clicking on the top-left NASA logo")
    public HomePage clickOnNasaLogo() {
        topLeftLogo.click();
        return new HomePage(driver);
    }

    public TopicsPage openPage() {
        driver.get(PAGE_URL);
        wait.until(ExpectedConditions.visibilityOf(topLeftLogo));
        return this;
    }




}
